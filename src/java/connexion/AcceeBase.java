/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import mapping.Personnel;
import java.sql.Time;
import javax.swing.JOptionPane;
import mapping.Pointage;

/**
 *
 * @author User
 */
public class AcceeBase {
    public int getNombreMatricule(Personnel p) throws SQLException
    {
         int nbr=0;
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select count(matricule) from personnel where matricule= "+p.getMatricule();
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               nbr=rs.getInt(1);
            }
             c.close();
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getNombreMatricule:"+ex.getMessage());
            ex.printStackTrace();

        }
        return nbr;
    }
    
    //get id a partir de codematricule//
    
    public int getmatriculeParCodeMatricule(String code)
    {
        int nbr=0;
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select matricule from personnel where codematricule= '"+code+"'";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               nbr=rs.getInt(1);
            }
             c.close();
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getNombreMatricule:"+ex.getMessage());
            ex.printStackTrace();

        }
        return nbr;
    }
    
    public int getNombrePointageUnJourUneAnnee(Personnel p,Pointage point) throws SQLException
    {
        int nbr=0;
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select count(personnel.matricule) from pointage join personnel on pointage.matricule=personnel.matricule where personnel.matricule= "+p.getMatricule()+" and datepointage='"+point.getDatepointage()+"'";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
               nbr=rs.getInt(1);
            }
             c.close();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"Probleme de requette getNombrePointageUnJourUneAnnee:"+ex.getMessage());
           ex.printStackTrace();
        }
            return nbr+1;
    }
    
    //getDernier etat/ sotie ou entree//
    public Object[] getDernierEtatDunEmpl(Personnel p,Pointage point) throws SQLException
    {
        Object[]  rep=new Object[2];
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select etat,heurepointage from pointage join personnel on pointage.matricule=personnel.matricule where personnel.matricule= "+p.getMatricule()+" and datepointage='"+point.getDatepointage()+"' order by heurepointage DESC limit 1 ";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
               rep[0]=rs.getString(1);
               rep[1]=rs.getTime(2);
            }
             c.close();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"Probleme de requette getNombrePointageUnJourUneAnnee:"+ex.getMessage());
           ex.printStackTrace();
        }
            return rep;
    }
    //Derniere etat entree Weekk end ou Jour Ferier:heure et etat sortie ou entree pour la calcul de heure sup//
    public Object[] getDernierEtatDunEmplWeekJf(Personnel p,Pointage point) throws SQLException
    {
        Object[]  rep=new Object[2];
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select etat,heurepointage from pointage join personnel on pointage.matricule=personnel.matricule where personnel.matricule= "+p.getMatricule()+" and datepointage='"+point.getDatepointage()+"' and etat='Entree' order by heurepointage DESC limit 1 ";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
               rep[0]=rs.getString(1);
               rep[1]=rs.getTime(2);
            }
             c.close();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"Probleme de requette getNombrePointageUnJourUneAnnee:"+ex.getMessage());
           ex.printStackTrace();
        }
            return rep;
    }
    
    
    //fonction pour avoir le poste d'un employer//
    public String getPosteWhereMatricule(Personnel p) throws SQLException
    {
        String rep="";
        try
        {
         Connection  c = Connexion.getConnexion();
            String req = "select typetravail from personnel  where matricule= "+p.getMatricule();
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
               rep=rs.getString(1);
            }
             c.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getPosteWhereMatricule:"+ex.getMessage());
            ex.printStackTrace();
        }
        return rep;
    }
    
    //getHeure Tous un Emp dans emploi du temps//
    public Time[] getTimeOneEmploye(Personnel p)
    {
        int i=0;
        Time[] listeHeur=new Time[4];
        try
        {
            Connection  c = Connexion.getConnexion();
           String req = "select hentree,hsortie,midisortie,midientree  from emploidutemps  where matricule= "+p.getMatricule()+"";
           ResultSet rs = c.createStatement().executeQuery(req);
           while(rs.next()){
              listeHeur[0]=rs.getTime(1);
              listeHeur[1]=rs.getTime(2);
              listeHeur[2]=rs.getTime(3);
              listeHeur[3]=rs.getTime(4);
             
           }
            c.close();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"Probleme de requette getTimeOneEmploye:"+ex.getMessage());

        }
        return listeHeur;
    }
    
    //fonction getAllJourFerier//
    
    public Object[][]getAllJourFerier(Date annne)
    {
        int taille=0,i=0;
        Connection  c = Connexion.getConnexion();
        try
        {
           
           
            String req = "select count(idjf) from jourferies";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               taille=rs.getInt(1);
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette countIdJF:"+ex.getMessage());

        }
       Object[][]resp=new Object[3][taille];
       
       try
       {
            String req = "select dateinsertion,heuredebut,heurefin from jourferies where dateinsertion='"+annne+"' ";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
              resp[0][i]=rs.getDate(1);
              resp[1][i]=rs.getTime(2);
              resp[2][i]=rs.getTime(3);
              i++;
            }
             c.close();
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null,"Probleme de requette getAllJourFerier:"+ex.getMessage());
       }
       return resp;
    }
    
    //fonction get All Employe//
    
    public Object[][] getAllAmploye(int moi, int annee)
    {
        int taille=0,i=0;
        Connection  c = Connexion.getConnexion();
        try
        {
           
           
            String req = "select nom,poste,dateemboche,sexe,matricule from personnel where matricule not in(select idemp from debauche where dateapplication<'01-"+moi+"-"+annee+"')";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               taille=rs.getRow();
            }
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette countIdPersonnel:"+ex.getMessage());

        }
       Object[][]resp=new Object[taille][5];
       
       try
       {
            String req = "select nom,poste,dateemboche,sexe,matricule from personnel where matricule not in(select idemp from debauche where dateapplication<'01-"+moi+"-"+annee+"')";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
            
             resp[i][0]=rs.getString(1);
             resp[i][1]=rs.getString(2);
             resp[i][2]=rs.getDate(3);
             resp[i][3]=rs.getString(4);
             resp[i][4]=rs.getInt(5);
              i++;
            }
             c.close();
       }
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(null,"Probleme de requette getAllAmploye:"+ex.getMessage());
       }
       return resp;
    }
    
    //fonction getDernierPointage (date heure)//
    
    public Object[] dernierPointage(Personnel p)
    {
        Object []resp= new Object[2];
        Connection  c = Connexion.getConnexion();
        try
        {
            String req = "select datepointage,heurepointage from pointage where matricule="+p.getMatricule()+" order by heurepointage desc limit 1";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
              resp[0]=rs.getDate(1);
              resp[1]=rs.getTime(2);
            }
             c.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette dernierPointage:"+ex.getMessage());
        }
        return resp;
    }
    
    //get la date abs entre deux date//
    
    public Object[] getDateEntredeuxEntreeAbs(Personnel p,Pointage poi) throws SQLException
    {
        int taille=0,i=0;
        Date dernierePointage=poi.getDatepointage();
        if((Date)new AcceeBase().dernierPointage(p)[0]!=null)
        {
            dernierePointage =(Date)new AcceeBase().dernierPointage(p)[0]; 
        }
      
        Connection  c = Connexion.getConnexion();
        String reqTaille = "select datepointage from pointage where matricule="+poi.getMatricule()+" and datepointage<'"+poi.getDatepointage()+"' and datepointage>'"+dernierePointage+"' ";
        ResultSet rs = c.createStatement().executeQuery(reqTaille);

        while(rs.next()){
         taille=rs.getRow();
        }
        Object []resp= new Object[taille];
       
        try
        {
            
            String req = "select datepointage from pointage where matricule="+p.getMatricule()+" and datepointage<'"+poi.getDatepointage()+"' and datepointage>'"+dernierePointage+"' ";
            ResultSet rs2 = c.createStatement().executeQuery(req);

            while(rs2.next()){
              resp[i]=rs2.getDate(1);
              i++;
             }
             c.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getDateEntredeuxEntree:"+ex.getMessage());
        }
        
        return resp;
        
    }
   //get nombre matricule
    
    public int nombreMAtricule(int moi, int annee)
    {
         int taille=0,i=0;
        Connection  c = Connexion.getConnexion();
        try
        {
           String req = "select nom,poste,dateemboche,sexe,matricule from personnel where matricule not in(select idemp from debauche where dateapplication<'01-"+moi+"-"+annee+"')";
           ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               taille=rs.getRow();
            }
             c.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getListePaieDesEmploye:"+ex.getMessage());

        }
        return taille;
    }
    //compterle entrer et le sortie dans une journer
    public int getNombrentrerUneJourner(Personnel p,Pointage point)
    {
        int nombre = 0;
        
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select coun(etat)  from pointage join personnel on pointage.matricule=personnel.matricule where personnel.matricule= "+p.getMatricule()+" and datepointage='"+point.getDatepointage()+"' and etat='Entree'";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
            nombre=rs.getInt(1);
            }
             c.close();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"Probleme de requette getNombrentrerEtSortieUneJourner:"+ex.getMessage());
           ex.printStackTrace();
        }
           
        return nombre;
    }
    //ssortie//
     public int getNombreSortieUneJourner(Personnel p,Pointage point)
    {
        int nombre = 0;
        
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select coun(etat)  from pointage join personnel on pointage.matricule=personnel.matricule where personnel.matricule= "+p.getMatricule()+" and datepointage='"+point.getDatepointage()+"' and etat='Sortie'";
            ResultSet rs = c.createStatement().executeQuery(req);
            while(rs.next()){
            nombre=rs.getInt(1);
            }
             c.close();
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null,"Probleme de requette getNombreSortieUneJourner:"+ex.getMessage());
           ex.printStackTrace();
        }
           
        return nombre;
    }
}
