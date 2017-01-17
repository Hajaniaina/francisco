/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selection;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mapping.Retenues;

/**
 *
 * @author Bae
 */
public class GetListRetenues {
    public double getRetenues(int employe) throws SQLException{
        Connection  c = Connexion.getConnexion();
        String req = "select sum(duree) from retenues where employe= "+employe+"";
        ResultSet rs = c.createStatement().executeQuery(req);
        double sommeGain=0;
        while(rs.next()){
            sommeGain = rs.getDouble(1);
        }
        c.close();
        return sommeGain;
    }
}
