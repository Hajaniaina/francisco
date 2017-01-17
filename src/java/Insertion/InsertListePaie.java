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
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mapping.Personnel;
import mapping.Pointage;

/**
 *
 * @author Bae
 */
public class InsertListePaie {
    public void insertListePaie( double gains, double retenues,Pointage p,Personnel pers,String libelle, int etat) throws SQLException, GestionExecption {
        Connection c = Connexion.getConnexion();
        
        int idpers=pers.getMatricule();
        int moi=new DateHeure().getMoi(p.getDatepointage());
        int annee=new DateHeure().getAnnee(p.getDatepointage());
        int jours=new DateHeure().getJour(p.getDatepointage());
        try
        {
           String sql = "insert into mouvementlistepaie(idpers,gains,retenues,moi,annee,jours,etat,libelle) "
                + "values("+idpers+","+gains+","+retenues+","+moi+","+annee+","+jours+","+etat+",'"+libelle+"')";
        Statement s = c.createStatement();
        s.executeUpdate(sql);
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme insertListePaie"+ ex);
        }
        
//        c.commit();
//        c.close();
      
    }
}
