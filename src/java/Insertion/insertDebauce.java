/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insertion;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mapping.JourFeries;

/**
 *
 * @author User
 */
public class insertDebauce {
     public boolean insertDebauche(int matricule, Date daty,int jour,int moi, int annee,Date app, String rem, String motif ) throws SQLException {
        Connection c = Connexion.getConnexion();
        PreparedStatement ps = c.prepareStatement("insert into debauche (idemp,daty,jour,moi,annee,dateapplication,remarque,motif)values(?,?,?,?,?,?,?,?)");
            ps.setInt(1,matricule);
            ps.setDate(2, daty);
            ps.setInt(3, jour);
            ps.setInt(4, moi);
            ps.setInt(5, annee);
            ps.setDate(6, app);
            ps.setString(7, rem);
            ps.setString(8, motif);
            
            ps.executeUpdate();
            c.close();
        return false;
    }
     
     public int[] TesteApartien( int id ) throws SQLException
     {
         int [] res= new int[3];

         try
         {
        Connection  c = Connexion.getConnexion();
        String req = "select moi,jour,annee from debauche where idemp= "+id+"";
        ResultSet rs = c.createStatement().executeQuery(req);
        while(rs.next()){
            res[0] =rs.getInt(1);
            res[1] =rs.getInt(2);
            res[2] =rs.getInt(3);
        }  
         c.close();
         }catch(Exception ex)
         {
          JOptionPane.showMessageDialog(null,"Probleme de requette TesteApartien:"+ex.getMessage());
         }
      
        return res;
         
     }
     //
}
