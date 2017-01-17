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
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class insertEdition {
    
     public boolean insertHist( Date daty,int montant,int mtr ) throws SQLException {
        Connection c = Connexion.getConnexion();
        PreparedStatement ps = c.prepareStatement("insert into salairedebashistorique (daty,montant,matriculeempl)values(?,?,?)");
            ps.setDate(1,daty);
            ps.setInt(2, montant);
            ps.setInt(3, mtr);
            ps.executeUpdate();
           
            return false;
    }
     
     public boolean updateSalaire( Date daty,int montant,int mtr ) throws SQLException {
        Connection c = Connexion.getConnexion();
        PreparedStatement ps = c.prepareStatement("update salairedebasefixe set daty=?,datdeb=?,montant=? where matriculeemploye=?");
            ps.setDate(1,daty);
            ps.setDate(2,daty);
            ps.setInt(3, montant);
            ps.setInt(4, mtr);
            ps.executeUpdate();
           
            return false;
    }
}
