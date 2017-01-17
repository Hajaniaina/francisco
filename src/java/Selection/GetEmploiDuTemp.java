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
import java.util.ArrayList;
import mapping.EmploiDuTemps;

/**
 *
 * @author Bae
 */
public class GetEmploiDuTemp {
    public ArrayList<EmploiDuTemps> getEmpoiDuTempsPersonnel() throws SQLException{
        Connection  c = Connexion.getConnexion();
        String req = "select * from emploidutemps";
        ResultSet rs = c.createStatement().executeQuery(req);
        ArrayList<EmploiDuTemps> et = new ArrayList<>();
        while(rs.next()){
            et.add(new EmploiDuTemps(rs.getInt(1),rs.getTime(2),rs.getTime(3),rs.getTime(4),rs.getTime(5),rs.getString(6)));
        }
        c.close();
        return et;
    }
}
