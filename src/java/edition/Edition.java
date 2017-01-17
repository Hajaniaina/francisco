/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edition;

import DateTime.DateHeure;
import connexion.AcceeBseFichDePaie;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mapping.Personnel;

/**
 *
 * @author User
 */
public class Edition {
    public void insertEdition(int matricule,int salaire,int moi, int annee)
    {
        Connection c = Connexion.getConnexion();
        try
        {
           String sql = "insert into mouvementlistepaie(idpers,gains,retenues,moi,annee,jours,etat,libelle) "
                + "values("+matricule+","+salaire+",0,"+moi+","+annee+","+0+","+100+",'Salaire de base')";
        Statement s = c.createStatement();
        s.executeUpdate(sql);
         c.close();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme insertEdition"+ ex);
        } 
    }
    
    public void updateEdtition(int matricule,int salaire,int moi, int annee)
    {
        Connection c = Connexion.getConnexion();
        try
        {
        String sql = "update  mouvementlistepaie set gains ="+salaire+" where moi="+moi+" and annee="+annee+" and etat=100 and idpers="+matricule+" ";
        Statement s = c.createStatement();
        s.executeUpdate(sql);
         c.close();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme updateEdtition"+ ex);
        }
        
    }
        //tester s'ilexiste deja dans element paie
        public int countSalaireInElmPaieMoiAnnee(int matr, int moi, int annee) throws SQLException
        {
            int resp=0;
             Connection  c = Connexion.getConnexion();
        String req = "select idpers from mouvementlistepaie where moi= "+moi+" and annee="+annee+" and idpers="+matr+" and etat=100";
        ResultSet rs = c.createStatement().executeQuery(req);
       
        while(rs.next()){
            resp =rs.getRow();
        }
         c.close();
            return resp;
        }
        
        //avance
        
         public void insertEditionAvance(int matricule,int montant,int moi, int annee)
        {
            Connection c = Connexion.getConnexion();
            try
            {
               String sql = "insert into mouvementlistepaie(idpers,gains,retenues,moi,annee,jours,etat,libelle) "
                    + "values("+matricule+",0,"+montant+","+moi+","+annee+","+0+","+200+",'Avance')";
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Probleme insertEditionAvance"+ ex);
            } 
         }
    
            public void updateEdtitionAvance(int matricule,int montant,int moi, int annee)
            {
                Connection c = Connexion.getConnexion();
                try
                {
                 String sql = "update  mouvementlistepaie set retenues ="+montant+" where moi="+moi+" and annee="+annee+" and etat=200 and idpers="+matricule+" ";
                Statement s = c.createStatement();
                s.executeUpdate(sql);
                 c.close();
                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Probleme updateEdtitionAvance"+ ex);
                }
            }
                //tester s'ilexiste deja dans element paie
        public int countSalaireInElmPaieMoiAnneeAvance(int matr, int moi, int annee) throws SQLException
        {
            int resp=0;
             Connection  c = Connexion.getConnexion();
        String req = "select idpers from mouvementlistepaie where moi= "+moi+" and annee="+annee+" and idpers="+matr+" and etat=200";
        ResultSet rs = c.createStatement().executeQuery(req);
       
        while(rs.next()){
            resp =rs.getRow();
        }
            c.close();
            return resp;
        }
        
    }

