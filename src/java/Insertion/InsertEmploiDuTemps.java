/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insertion;

import Exception.GestionExecption;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class InsertEmploiDuTemps {
    
     public boolean insertEmploiDuTemps(Time entreeMatin, Time sortiMidi,Time entreeMidi,Time sortieSoir,int   matricule,String poste) throws SQLException, GestionExecption{
        Connection c = Connexion.getConnexion();
       try
       {
            String sql="insert into emploidutemps(hentree,hsortie,matricule,midisortie,midientree,poste)values('"+entreeMatin+"','"+sortiMidi+"',"+matricule+",'"+entreeMidi+"','"+sortieSoir+"','"+poste+"')";
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            c.close();
       }
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, "Probleme insertEmploiDuTemps:"+ ex.getMessage());
       }
       
        return false;
    }
}
