/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import mapping.Personnel;

/**
 *
 * @author User
 */
public class UpdateAvance {
    String sql,sqlcount;
    PreparedStatement stat;
    Connection con;
    ResultSet rs;
    ResultSet rsCount;
    int taille=0,i=0;
    public void updateAvace(int matricule,int numero)
    {
        Connection con=Connexion.getConnexion();
        try
        {
            sql="update avance set etatsdejavalides=0 where idpers="+matricule+" and numero ="+numero+"";
            stat=con.prepareStatement(sql);
            int i=stat.executeUpdate();
            con.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Erreur updateInitAux: "+ex);
        }
    }
}
