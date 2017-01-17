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

/**
 *
 * @author User
 */
public class InsertPersonnel {
    public boolean insertSalaire(String nom,String poste,String typeTravail,String sexe,String  codeMatricule,Date dateEmbauche) throws SQLException, GestionExecption{
        Connection c = Connexion.getConnexion();
       
        String sql="insert into personnel(nom,poste,typetravail,sexe,codematricule,dateemboche)values('"+nom+"','"+poste+"','"+typeTravail+"','"+sexe+"','"+codeMatricule+"','"+dateEmbauche+"')";
        Statement s = c.createStatement();
        s.executeUpdate(sql);
        c.close();
        return false;
    }
}
