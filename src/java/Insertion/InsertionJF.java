/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insertion;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mapping.JourFeries;

/**
 *
 * @author Bae
 */
public class InsertionJF {
    public boolean insertJourFeries(JourFeries jf) throws SQLException {
        Connection c = Connexion.getConnexion();
        PreparedStatement ps = c.prepareStatement("insert into jourferies(dateinsertion,motif,heuredebut,heurefin) values(?,?,?,?)");
            ps.setDate(1,jf.getDateinsertion());
            ps.setString(2, jf.getMotif());
            ps.setTime(3, jf.getHeuredebut());
            ps.setTime(4, jf.getHeurefin());
            ps.executeUpdate();
        return false;
    }
}
