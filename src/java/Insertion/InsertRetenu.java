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
/**
 *
 * @author Bae
 */
public class InsertRetenu {
    public boolean insertRetenu(String motif,double duree, Date datesaisie,int employe,String poste) throws SQLException, GestionExecption{
        Connection c = Connexion.getConnexion();
        int moi=new DateHeure().getMoi(datesaisie);
        int annee=new DateHeure().getAnnee(datesaisie);
        int jours=new DateHeure().getJour(datesaisie);
        String sql="insert into retenues(motif,duree,datesaisie,employe,poste,jours,moi,annee) values('"+motif+"',"+duree+",'"+datesaisie+"',"+employe+",'"+poste+"',"+jours+","+moi+","+annee+")";
        Statement s = c.createStatement();
        s.executeUpdate(sql);
//        c.commit();
        c.close();
        return false;
    }
}
