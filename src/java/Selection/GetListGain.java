/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selection;

import java.sql.SQLException;
import java.util.ArrayList;
import mapping.Gains;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
/**
 *
 * @author Bae
 */
public class GetListGain {
    public double getGains(int employe) throws SQLException{
        Connection  c = Connexion.getConnexion();
        String req = "select sum(duree) from gain where employe= "+employe+"";
        ResultSet rs = c.createStatement().executeQuery(req);
        double sommeGain=0;
        while(rs.next()){
            sommeGain = rs.getDouble(1);
        }
        c.close();
        return sommeGain;
    }
}
