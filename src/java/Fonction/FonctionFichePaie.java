/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonction;

import Exception.GestionExecption;
import Insertion.insertDebauce;
import calcul.CalculIrsa;
import calcul.calculCnaps;
import calcul.calculOstie;
import calcul.calculRetardAbsSuppl;
import calcul.prorata;
import connexion.AcceeBase;
import connexion.AcceeBseFichDePaie;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mapping.FichePaie;
import mapping.Gains;
import mapping.ListePaie;
import mapping.Personnel;
import mapping.Retenues;

/**
 *
 * @author User
 */
public class FonctionFichePaie 
{
   public FichePaie ficheDePaie(Personnel p, int moi, int annee) throws SQLException
   {
       int matricule=p.getMatricule();
       FichePaie reponse=new FichePaie();
       
       Object[]listeEmpl=new AcceeBseFichDePaie().getunAllAmployeApropos(p.getMatricule());
       int[]embauce=new insertDebauce().TesteApartien(p.getMatricule());
       int salaire =new AcceeBseFichDePaie().getalaireDeBaseUnEmployer(p.getMatricule());;
      
       if(embauce[1]==moi && embauce[2]==annee )
       {
           salaire =new prorata().calculProrata(salaire, embauce[0]);
          // JOptionPane.showMessageDialog(null,"Probleme de requette getNombreMatricule:"+salaire +"et "+embauce[0]+"et "+embauce[2]);
       }
       else
       {
           salaire =new AcceeBseFichDePaie().getalaireDeBaseUnEmployer(p.getMatricule());
       }
      
       int avance=new AcceeBseFichDePaie().getAvance(p.getMatricule(), moi, annee);
       
       Object[][]listeGain=new AcceeBseFichDePaie().getGain(p.getMatricule(), moi, annee);
       Object [][]listeRretenu=new AcceeBseFichDePaie().getRetenu(p.getMatricule(), moi, annee);
       Date dateembauceh=new AcceeBseFichDePaie().getDateEmbauche(p.getMatricule());
       int cnaps=new calculCnaps().calculcnaps(salaire);
       int ostie=new calculOstie().calculOstie(salaire);
       double irsa=new CalculIrsa().calculIrsa(salaire);
       
       Gains []listeG=new Gains[listeGain.length];
       Retenues []listeR=new Retenues[listeRretenu.length+3];
       Personnel pers=new Personnel();
       pers.setNom(listeEmpl[0].toString());
       pers.setPoste(listeEmpl[1].toString());
       double sommeGai=0;
       double sommeRetenus=0;
       double netApayer=0;
       
       //ajouter les valeur dans la liste gain et retenues
       
       for(int i=0;i<listeGain.length;i++)
       {
           listeG[i]=new Gains(listeGain[i][1].toString(),Integer.parseInt(listeGain[i][0].toString()));
       }
       for(int i=0;i<listeRretenu.length;i++)
       {
          listeR[i]=new Retenues(listeRretenu[i][1].toString(),Integer.parseInt(listeRretenu[i][0].toString()));
       }
       listeR[listeRretenu.length]=new Retenues("CNAPS",(double)cnaps);
       listeR[listeRretenu.length+1]=new Retenues("OSTIE",(double)ostie);
       listeR[listeRretenu.length+2]=new Retenues("IRSA",(double)irsa);
       for(int i=0;i<listeG.length;i++)
       {
           sommeGai+=listeG[i].getMontant();
       }
       for(int i=0;i<listeR.length;i++)
       {
           sommeRetenus+=listeR[i].getMontant();
       }
       netApayer=sommeGai-sommeRetenus;
       
       //ajout les valeur dans lafiche
  
       //  new GestionExecption("Cet employe n'a lus une fiche de paie pour ce moi car il est deja debauché en:"+embauce[0]+"/"+embauce[1]+"/"+embauce[2]);
    int nb=new VerificationSidembauche().listMatInDeb(p.getMatricule());
   // new GestionExecption(""+embauce[1] +"et"+embauce[2]);
    if(nb>0)
    {
     if(embauce[1]>=moi && embauce[2]==annee )
     {
          reponse=new FichePaie(listeG,listeR,pers,dateembauceh,sommeGai,sommeRetenus,netApayer);
     }
     else
     {
         new GestionExecption("Cet employe n'a lus une fiche de paie pour ce moi car il est deja debauché en:"+embauce[0]+"/"+embauce[1]+"/"+embauce[2]);
     }
    }
    else
    {
          reponse=new FichePaie(listeG,listeR,pers,dateembauceh,sommeGai,sommeRetenus,netApayer);
    }
     
      
      
       return reponse;  
   }
   
}
