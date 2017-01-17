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
import mapping.Personnel;

/**
 *
 * @author Bae
 */
public class SelectInPersonnel {
    public double getSalaire(int matricule) throws SQLException{
        Connection  c = Connexion.getConnexion();
        String req = "select montant from salairedebasefixe where matriculeemploye= "+matricule;
        ResultSet rs = c.createStatement().executeQuery(req);
        double salaire= 0;
        while(rs.next()){
            salaire =rs.getDouble(1);
        }
        c.close();
        return salaire;
    }
}
