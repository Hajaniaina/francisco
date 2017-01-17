/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Fonction.Fonction;
import Exception.GestionExecption;
import connexion.AcceeBase;
import java.sql.SQLException;
import mapping.Personnel;
import java.sql.Time;
import java.sql.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import mapping.Pointage;

/**
 *
 * @author User
 */
public class AllVerification {
    
    //verification matricule//
    
    public void  verifMAtricule(Personnel p) throws SQLException, GestionExecption
    {
        String response="Matricule invalide";
        
        int nbr=new AcceeBase().getNombreMatricule(p);
        if(nbr>1 || nbr<1)
        {
            throw new  GestionExecption(response);
        }
      
    }
    
    //Vrification de nombre de pointage//
    public int countNombreMatriculePointage(Personnel p,Pointage point) throws SQLException
    {
        int resp =new AcceeBase().getNombrePointageUnJourUneAnnee(p,point);
        switch(resp)
        {
            case 1: resp=0;
            break;
            case 2: resp=1;
            break;
            case 3: resp=2;
            break;
            case 4: resp=3;
            break;
            case 5: resp=4;
            break;
            default: resp=-1;
        }
        
        return resp;
    }
    
    //Verification d'heure entre ts mahaz une heure avant la rentree soir//
    
   public boolean testeHeureEntree(Pointage p) throws SQLException
    {
        Personnel pers=new Personnel();
        boolean retour = true;
        long  resp=0;
        pers.setMatricule(p.getMatricule());
        String poste=new AcceeBase().getPosteWhereMatricule(pers);
        pers.settypeTravail(poste);
        pers.setMatricule(p.getMatricule());
        Time[] liste =new AcceeBase().getTimeOneEmploye(pers);
        Time sortie=liste[1];
        Time Entree=p.getHeurepointage();
       // JOptionPane.showMessageDialog(null,"Probleme de requette getTimeOneEmploye:"+pers.gettypeTravail() +"et"+Entree);
        if(pers.gettypeTravail().compareToIgnoreCase("bureau")==0)
        {
             resp=(Integer.parseInt(""+sortie.getTime()) - Integer.parseInt(""+Entree.getTime()))/3600000;
        }
         else
        {
             resp=(Integer.parseInt(""+sortie.getTime())-Integer.parseInt(""+Entree.getTime()))/3600000;
             //JOptionPane.showMessageDialog(null,"Ataov serieu"+Entree);
        }
        
        
        if(resp>=1)
        {
             return retour;
        }
        else
        {
            return false;
        }
    }
   //teste weeek end//
   public boolean testeWeekEnd(Date d)
   {
        GregorianCalendar calendar =new GregorianCalendar();
        calendar.setTime(d);
	int today =calendar.get(calendar.DAY_OF_WEEK);
 
	switch (today) {
	case GregorianCalendar.SUNDAY:
		return true;
	default:
		return false;
	}
   }
   
   //teste meme heure
   
   public void testeMemeHeure(Pointage p, Personnel pesr) throws GestionExecption
   {
       if(new Fonction().testePointageRetourMemeJour(p, pesr)==3)
        {
            throw new GestionExecption("C'est la meme heure");
        }
   }
   //verification date valide
   
   public void testeDateVAlide(Date d) throws GestionExecption
   {
       if(!new AllVerification().testeSidateEtValide(d))
       {
           throw new GestionExecption("Date invalide, la date doit etre egale  a la date d'aujourd'hui");
       }
   }
   
   public void tesTeEntreeTard(Pointage p) throws GestionExecption, SQLException
   {
        if(!new AllVerification().testeHeureEntree(p))
        {
              throw new GestionExecption("Vous ne pouvez plus entrer parce que vous etes en retard une heure avant la rentree");
        }
   }
   
   //tester jour ferier//
   
   public void testerJourFerier(Pointage p) throws GestionExecption
   {
       if(new Fonction().testeJourferier(p.getDatepointage(), p) || new AllVerification().testeWeekEnd(p.getDatepointage()))
        {
            int verif=new Confirmation().verificationFait("Voulez vous faire heure supplementaire?");
            if(verif== JOptionPane.OK_OPTION)
            {

            }
            else
            {
                 throw new GestionExecption("Annuler");
            }
        }
   }
   
   //fonction pour tester si la date est sup de la date d'ajourduit//
    
    public boolean testeSidateEtValide(Date d)
    {
       java.util.Date ajourd=new java.util.Date ();
       if(d.getTime()>ajourd.getTime())
        {
            return false;
        }
       else
       {
           return true;
       }
    }
   
    //teter le ombre entrer et le nombre sortie//
    
    public void verifNombreEntrer(Personnel p,Pointage point)
    {
        int nmb=new AcceeBase().getNombrentrerUneJourner(p, point);
        if(nmb==0)
        {
              new GestionExecption("Vous ne pouvez plus entrer");
        }
    }
    //nombre sortie
    public void verifNombreSortie(Personnel p,Pointage point)
    {
        int nmb=new AcceeBase().getNombreSortieUneJourner(p, point);
        if(nmb==0)
        {
            new GestionExecption("Vous ne pouvez plus sortir");
        }
    }
           
}
