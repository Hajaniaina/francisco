/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selection;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class GetAllEmploye {
    
    public Object[][] getAllAmploye()
    {
        int taille=0,i=0;
        Connection  c = Connexion.getConnexion();
        try
        {
           
           
            String req = "select nom,poste,dateemboche,sexe,matricule,codematricule from personnel where matricule not in(select idemp from debauche)";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               taille=rs.getRow();
            }
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette countIdPersonnel:"+ex.getMessage());

        }
       Object[][]resp=new Object[taille][6];
       
       try
       {
            String req = "select nom,poste,dateemboche,sexe,matricule,codematricule from personnel where matricule not in(select idemp from debauche)";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
            
             resp[i][0]=rs.getString(1);
             resp[i][1]=rs.getString(2);
             resp[i][2]=rs.getDate(3);
             resp[i][3]=rs.getString(4);
             resp[i][4]=rs.getInt(5);
             resp[i][5]=rs.getString(6);
              i++;
            }
             c.close();
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null,"Probleme de requette getAllAmploye:"+ex.getMessage());
       }
       return resp;
    }
    
    
    //All Employe on poste//
    public Object[][] getAllAmployeOnPoste(String poste)
    {
        int taille=0,i=0;
        Connection  c = Connexion.getConnexion();
        try
        {
           
           
            String req = "select nom,poste,dateemboche,sexe,matricule,codematricule from personnel where matricule not in(select idemp from debauche) and poste='"+poste+"'";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               taille=rs.getRow();
            }
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette countIdPersonnel:"+ex.getMessage());

        }
       Object[][]resp=new Object[taille][6];
       
       try
       {
            String req = "select nom,poste,dateemboche,sexe,matricule,codematricule from personnel where matricule not in(select idemp from debauche)and poste='"+poste+"'";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
            
             resp[i][0]=rs.getString(1);
             resp[i][1]=rs.getString(2);
             resp[i][2]=rs.getDate(3);
             resp[i][3]=rs.getString(4);
             resp[i][4]=rs.getInt(5);
             resp[i][5]=rs.getString(6);
              i++;
            }
             c.close();
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null,"Probleme de requette getAllAmploye:"+ex.getMessage());
       }
       return resp;
    }
    
}
