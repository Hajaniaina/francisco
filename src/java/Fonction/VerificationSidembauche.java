/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonction;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class VerificationSidembauche {
   public int listMatInDeb(int id) throws SQLException{
        Connection  c = Connexion.getConnexion();
        String req = "select count(idemp) as nb from debauche where idemp="+id+"";
        ResultSet rs = c.createStatement().executeQuery(req);
        int sommeGain=0;
        while(rs.next()){
            sommeGain = rs.getInt(1);
        }
        return sommeGain;
    }
}
