/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insertion;

import DateTime.DateHeure;
import Exception.GestionExecption;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class InsertSalaire {
    
     public boolean insertSalaire(Date daty,int matricule,int  montant,String libelle,Date datedeb) throws SQLException, GestionExecption{
        Connection c = Connexion.getConnexion();
       try
       {
            String sql="insert into salairedebasefixe(daty,matriculeemploye,montant,libelle,datdeb)values('"+daty+"',"+matricule+","+montant+",'"+libelle+"','"+datedeb+"')";
            Statement s = c.createStatement();
            s.executeUpdate(sql);
//        c.commit();
        c.close();
       }catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, "Probleme insertSalaire"+ ex.getMessage());
       }
        
        return false;
    }
    
}
