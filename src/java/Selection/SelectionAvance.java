/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selection;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mapping.Personnel;
import mapping.Pointage;

/**
 *
 * @author User
 */
public class SelectionAvance {
     public Object[][] getAvance() throws SQLException
     {
         Connection  c = Connexion.getConnexion();
         int taille=0;
         try
         {
             String req = "select nom,poste,sum(montant)as mont,datesaisie,nombre,idpers,numero from avance join personnel on avance.idpers=personnel.matricule where etatsdejavalides=1 group  by  numero,nom,poste,datesaisie,nombre,idpers ";
              ResultSet rs = c.createStatement().executeQuery(req);
              while(rs.next())
              {
                  taille=rs.getRow();
              }
         }
         catch(Exception ex)
         {
             
         }
        Object[][]  rep=new Object[taille][7];
        int i=0;
        try
        {
            String req = "select nom,poste,sum(montant)as mont,datesaisie,nombre ,idpers,numero from avance join personnel on avance.idpers=personnel.matricule  where etatsdejavalides=1 group  by  numero,nom,poste,datesaisie,nombre,idpers";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
               rep[i][0]=rs.getString(1);
               rep[i][1]=rs.getString(2);
               rep[i][2]=rs.getInt(3);
               rep[i][3]=rs.getDate(4);
               rep[i][4]=rs.getInt(5);
               rep[i][5]=rs.getInt(6);
               rep[i][6]=rs.getInt(7);
               i++;
            }
             c.close();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"Probleme de requette getAvance:"+ex.getMessage());
           ex.printStackTrace();
        }
            return rep;
       }
     
     // detaille de demande d'avance
     
     public Object[][] getDetailleAvanceAvance(int matricule) throws SQLException
     {
         Connection  c = Connexion.getConnexion();
         int taille=0;
         try
         {
             String req = "select nom,poste,montant  mont,datesaisie,nombre,idpers,numero from avance join personnel on avance.idpers=personnel.matricule where etatsdejavalides=1 and  idpers = "+matricule+"";
              ResultSet rs = c.createStatement().executeQuery(req);
              while(rs.next())
              {
                  taille=rs.getRow();
              }
         }
         catch(Exception ex)
         {
             
         }
        Object[][]  rep=new Object[taille][7];
        int i=0;
        try
        {
            String req = "select nom,poste,montant,datesaisie,nombre ,idpers,numero from avance join personnel on avance.idpers=personnel.matricule  where etatsdejavalides=1 and idpers="+matricule+"";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
               rep[i][0]=rs.getString(1);
               rep[i][1]=rs.getString(2);
               rep[i][2]=rs.getInt(3);
               rep[i][3]=rs.getDate(4);
               rep[i][4]=rs.getInt(5);
               rep[i][5]=rs.getInt(6);
               rep[i][6]=rs.getInt(7);
               i++;
            }
             c.close();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"Probleme de requette getAvance:"+ex.getMessage());
           ex.printStackTrace();
        }
            return rep;
       }
}
