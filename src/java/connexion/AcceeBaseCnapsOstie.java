/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mapping.Personnel;

/**
 *
 * @author User
 */
public class AcceeBaseCnapsOstie {
    
    
    public int getOstieCnaps(String nom) throws SQLException
    {
        int nbr=0;
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select valeur from ostiecnaps where nom='"+nom+"'";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               nbr=rs.getInt(1);
            }
            c.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getOstieCnaps:"+ex.getMessage());
            ex.printStackTrace();

        }
        return nbr;
    }
    
}
