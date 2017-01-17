/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonction;

import Insertion.insertDebauce;
import calcul.CalculIrsa;
import calcul.calculCnaps;
import calcul.calculOstie;
import calcul.prorata;
import connexion.AcceeBase;
import connexion.AcceeBaseListePaie;
import connexion.AcceeBseFichDePaie;
import edition.Edition;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mapping.ListePaie;

/**
 *
 * @author User
 */
public class FonctionListePaie {
    
     public ListePaie[]getListePaieDesEmploye(int moi, int annee) throws SQLException
     {
        
        int nombreEmp=new AcceeBase().nombreMAtricule(moi,annee);
        Object[][]listeEmp=new AcceeBase().getAllAmploye(moi,annee);
        ListePaie[] reponse=new ListePaie[nombreEmp] ;
        int[][]listeSal=new AcceeBaseListePaie().getTousLesMontant(moi,annee);
        int[][]listeDejaP=new AcceeBaseListePaie().getListeDejaPaye(moi,annee);
       
        
        //IRSA CNAPS OSTIE//
        int[] cnaps=new int[nombreEmp];
        int[] ostie=new int[nombreEmp];
        double[] irsa=new double[nombreEmp];
        //affectation en meme tille//
        double []listedejaPayer=new double[nombreEmp];
        double []listeSalaire=new double[nombreEmp];
        int[][] mouvPaie=new int[nombreEmp][5];
        for(int i=0;i<nombreEmp;i++)
        {
            
            listedejaPayer[i]=0;
            listeSalaire[i]=0;
            mouvPaie[i][0]=0;
            mouvPaie[i][1]=0;
            mouvPaie[i][2]=0;
            mouvPaie[i][3]=moi;
            mouvPaie[i][4]=annee;
            
        }
        //ajouter les vleurs
        //les salaire
        for(int i=0;i<listeSal.length;i++)
        {
            listeSalaire[i]=listeSal[i][1];
            cnaps[i]=new calculCnaps().calculcnaps(listeSal[i][1]);
            ostie[i]=new calculOstie().calculOstie(listeSal[i][1]);
            irsa[i]=new CalculIrsa().calculIrsa(listeSal[i][1]);
           // JOptionPane.showMessageDialog(null,"Ataov serieu"+listeSal[i][1]);
            double somme=cnaps[i]+ostie[i]+irsa[i];
            //en cas de dembauce'
            int[]embauce=new insertDebauce().TesteApartien(listeSal[i][0]);
            int salaire =new AcceeBseFichDePaie().getalaireDeBaseUnEmployer(listeSal[i][0]);;
            if(embauce[1]==moi && embauce[2]==annee )
            {

                salaire =new prorata().calculProrata(salaire, embauce[0]);
               // JOptionPane.showMessageDialog(null,"Probleme de requette getNombreMatricule:"+salaire +"et "+embauce[0]+"et "+embauce[2]);
            }
            else
            {
                salaire =new AcceeBseFichDePaie().getalaireDeBaseUnEmployer(listeSal[i][0]);
            }
            int count=new Edition().countSalaireInElmPaieMoiAnnee(listeSal[i][0], moi, annee);
            if(count==0)
            {
               new Edition().insertEdition(listeSal[i][0],salaire, moi, annee);
            }
            else
            {
                new Edition().updateEdtition(listeSal[i][0],salaire, moi, annee);
            }
        }
        //les deja payer
        for(int i=0;i<listeDejaP.length;i++)
        {
            listedejaPayer[i]=listeDejaP[i][1];
            int count=new Edition().countSalaireInElmPaieMoiAnneeAvance(listeDejaP[i][0], moi, annee);
            if(count==0)
            {
                new Edition().insertEditionAvance(listeDejaP[i][0], listeDejaP[i][1], moi, annee);
            }
            else
            {
                new Edition().updateEdtitionAvance(listeDejaP[i][0], listeDejaP[i][1], moi, annee);
            }
        }
        
        //get laliste
        int [][]listemouvementPaie=new AcceeBaseListePaie().getListeDeMouvementPaie(moi, annee);
        //les mous paie
        for(int i=0;i<listemouvementPaie.length;i++)
        {
          // JOptionPane.showMessageDialog(null,"Probleme de requette getNombreMatricule:"+listemouvementPaie.length);

            mouvPaie[i][0]=listemouvementPaie[i][0];
            mouvPaie[i][1]=listemouvementPaie[i][1];
            mouvPaie[i][2]=listemouvementPaie[i][2];
            mouvPaie[i][3]=listemouvementPaie[i][3];
            mouvPaie[i][4]=listemouvementPaie[i][4];
         
        }
       
        //Alocation//
        for(int i=0;i<nombreEmp;i++)
        {
            double respAayer=new FonctionListePaie().calculResteApayer((double)mouvPaie[i][1], (double)mouvPaie[i][2]+(int) (cnaps[i]+ostie[i]+irsa[i]));
            reponse[i]=new ListePaie(i+1,Integer.parseInt(listeEmp[i][4].toString()),listeEmp[i][0].toString(),listeEmp[i][1].toString(),(double)listeSalaire[i],(double)mouvPaie[i][1],(double)mouvPaie[i][2]+(int) (cnaps[i]+ostie[i]+irsa[i]),respAayer,mouvPaie[i][3],mouvPaie[i][4]);
            //Integer.parseInt(listeEmp[i][4].toString())
        }
        return reponse;
     }
     
     //fonction calcul reste aa payer//
     public double calculResteApayer(double sommeGain,double sommeretenu)
     {
         double resp=0;
         resp=(sommeGain-sommeretenu);
         return resp;
     }
     //getIndice d'un employe dan a liste//
     public int matricul(int matricul,int moi, int annee) throws SQLException
     {
         int ret=0;
          ListePaie []lp=new FonctionListePaie().getListePaieDesEmploye(moi, annee);
          for(int i=0;i<lp.length;i++)
          {
              if(lp[i].getIdpers()==matricul)
              {
                  ret=i;
              }
          }
         return ret;
     }
    
}
