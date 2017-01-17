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
public class GetAllModel {
    
    
    public Object[][]getModel()
    {
        int taille=0,i=0;
        String req = "select lundi,mardi,mercredi,jeudi,vendredi,samedi,dimanche,nommodel,idemploye from model";
        Connection  c = Connexion.getConnexion();
        try
        {
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               taille=rs.getRow();
            }
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette countIdPersonnel:"+ex.getMessage());

        }
       Object[][]resp=new Object[taille][9];
       
       try
       {
            //String req = "select nom,poste,dateemboche,sexe,matricule,codematricule from personnel where matricule not in(select idemp from debauche)";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
            
             resp[i][0]=rs.getString(1);
             resp[i][1]=rs.getString(2);
             resp[i][2]=rs.getString(3);
             resp[i][3]=rs.getString(4);
             resp[i][4]=rs.getString(5);
             resp[i][5]=rs.getString(6);
             resp[i][6]=rs.getString(7);
             resp[i][7]=rs.getString(8);
             resp[i][8]=rs.getInt(9);
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
    
    public Object[][]modelOnNom(String model)
    {
        int taille=0,i=0;
        String req = "select lundi,mardi,mercredi,jeudi,vendredi,samedi,dimanche,nommodel,idemploye from model where nommodel='"+model+"'";
        System.out.print(req);
        Connection  c = Connexion.getConnexion();
        try
        {
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               taille=rs.getRow();
            }
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette countIdPersonnel:"+ex.getMessage());

        }
       Object[][]resp=new Object[taille][9];
       
       try
       {
            //String req = "select nom,poste,dateemboche,sexe,matricule,codematricule from personnel where matricule not in(select idemp from debauche)";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
            
             resp[i][0]=rs.getString(1);
             resp[i][1]=rs.getString(2);
             resp[i][2]=rs.getString(3);
             resp[i][3]=rs.getString(4);
             resp[i][4]=rs.getString(5);
             resp[i][5]=rs.getString(6);
             resp[i][6]=rs.getString(7);
             resp[i][7]=rs.getString(8);
             resp[i][8]=rs.getInt(9);
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
