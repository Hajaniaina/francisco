/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AcceeBseFichDePaie {
    
    public Object[] getunAllAmployeApropos(int maricule) throws SQLException
    {
       Connection  c = Connexion.getConnexion();
       Object[]resp=new Object[3];
       
       try
       {
            String req = "select nom,poste,dateemboche from personnel where matricule="+maricule+"";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
            
             resp[0]=rs.getString(1);
             resp[1]=rs.getString(2);
             resp[2]=rs.getDate(3);
            }
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null,"Probleme de requette getAllAmploye:"+ex.getMessage());
       }
       c.close();
       return resp;
    }
    
    //get salaire de base d'un employer
    
    public int getalaireDeBaseUnEmployer(int matricule)
    {
        int salaire=0;
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select montant from salairedebasefixe where matriculeemploye="+matricule+"";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
               salaire=rs.getInt(1);
            }
             c.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getalaireDeBaseUnEmployer:"+ex.getMessage());
            ex.printStackTrace();
        }
        
        return salaire;
    }
    
    //get retenu d'un employe dans une moi et date donnnee
    public Object[][] getRetenu(int matricule, int moi, int annee)
    {
        int taille=0;
        try
        {
            Connection  c = Connexion.getConnexion();
            String req = "select sum(retenues),libelle from mouvementlistepaie where idpers="+matricule+" and moi="+moi+" and annee="+annee+" and retenues>0 group by libelle";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next())
            {
                taille=rs.getRow();
            }
             c.close();
        }
        catch(Exception ex)
        {
            
        }
        Object[][] resp=new Object[taille][2];
        int i=0;
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select sum(retenues),libelle from mouvementlistepaie where idpers="+matricule+" and moi="+moi+" and annee="+annee+" and retenues >0  group by libelle ";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
               resp[i][0]=rs.getInt(1);
               resp[i][1]=rs.getString(2);
               i++;
            }
             c.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getRetenu:"+ex.getMessage());
            ex.printStackTrace();
        }
        return resp;
    }
    //get gai d'un employe dans un mo et une annee donnee
    public Object[][] getGain(int matricule, int moi, int annee)
    {
        int taille=0;
        try
        {
            Connection  c = Connexion.getConnexion();
            String req = "select sum(gains),libelle from mouvementlistepaie where idpers="+matricule+" and moi="+moi+" and annee="+annee+" and gains>0 group by libelle ";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next())
            {
                taille=rs.getRow();
            }
             c.close();
        }
        catch(Exception ex)
        {
            
        }
        Object[][] resp=new Object[taille][2];
        int i=0;
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select sum(gains),libelle from mouvementlistepaie where idpers="+matricule+" and moi="+moi+" and annee="+annee+" and gains>0 group by libelle ";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
               resp[i][0]=rs.getInt(1);
               resp[i][1]=rs.getString(2);
               i++;
            }
             c.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getGain:"+ex.getMessage());
            ex.printStackTrace();
        }
        return resp;
    }
    
    //get date d'embauche..
    
    public Date getDateEmbauche(int matricule)
    {
        Date ret=new Date(0,0,0);
         int i=0;
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select dateemboche from personnel where matricule="+matricule+"";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
               ret=rs.getDate(1);
               i++;
            }
             c.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getDateEmbauche:"+ex.getMessage());
            ex.printStackTrace();
        }
        return ret;
    }
    
    //get l'avance//
    
    public int getAvance(int matricule, int moi, int annee)
    {
        int salaire=0;
        try
        {
            Connection  c = Connexion.getConnexion();
            String req = "select montant  from avance where idpers="+matricule+" and moi="+moi+" and annee="+annee+"";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next())
            {
                salaire=rs.getInt(1);
            }
             c.close();
        }
        catch(Exception ex)
        {
            
        } 
        return salaire;
    }
    
    //utilisation de elemnt de paie
   
}
