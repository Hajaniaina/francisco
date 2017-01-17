/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selection;

import PointageMultiple.Fonction.ListeDateHeureNonNull;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SelectRetardUnEmpSemaine {
    
    public int getRetUnEmpSem(int matricule,Date d){
        Connection  c = Connexion.getConnexion();
        String datyFin=new ListeDateHeureNonNull().addDaysRet(d, 7);
        int   rep=0;
        int i=0;
        try
        {
            String req = "select sum(duree) from retenues  where employe="+matricule+" and datesaisie<='"+datyFin+"' and datesaisie>='"+d+"' group by employe" ;
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
              rep=rs.getInt(1);
              i++;
            }
             c.close();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"Probleme de requette getRetUnEmpSem:"+ex.getMessage());
           ex.printStackTrace();
        }
            return rep;
    }
    
    //par jour
    public Object[][] getRetUnEmpJour(int matricule,Date d){
        Connection  c = Connexion.getConnexion();
        String datyFin=new ListeDateHeureNonNull().addDaysRet(d, 7);
        
        int taille=0;
        int i=0;
        String req = "select sum(duree),jours from retenues  where employe="+matricule+" and datesaisie<='"+datyFin+"' and datesaisie>='"+d+"' group by employe,jours" ;
        try
        {
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
              
              taille=rs.getRow();
            }
        }
        catch(Exception ex)
        {

        }
        Object  [] []rep=new Object[taille][];
        try
        {
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
              rep[i][0]=rs.getInt(1);
              rep[i][1]=rs.getInt(2);
              i++;
            }
             c.close();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"Probleme de requette getRetUnEmpJour:"+ex.getMessage());
           ex.printStackTrace();
        }
        return rep;
    }
}
