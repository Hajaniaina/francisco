/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insertion;

import connexion.AcceeBase;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import javax.swing.JOptionPane;
import mapping.Personnel;
import mapping.Pointage;
import metier.AllVerification;
import metier.Confirmation;
import Fonction.Fonction;
import Exception.GestionExecption;

/**
 *
 * @author Bae
 */
public class InsertPointages {
    public boolean insertionPointage(Pointage p) throws SQLException, GestionExecption, ParseException{
            Personnel perso=new Personnel();
            perso.setMatricule(p.getMatricule());
            String poste=new AcceeBase().getPosteWhereMatricule(perso);
            perso.settypeTravail(poste);
           
        //verification de nmbre de pointage//
            int nombrePointageUnJour=new AllVerification().countNombreMatriculePointage(perso,p);
           // new AllVerification().verifMAtricule(perso);
           // new AllVerification().testeMemeHeure(p, perso);
           // new AllVerification().testeDateVAlide(p.getDatepointage());
            double temps =0,tempsnuit=0;
            //JOptionPane.showMessageDialog(null,"Ataov serieu"+new Fonction().testePointageRetourMemeJour(p, perso));
            
            Time tbureau = new Time(8,0,0);
            String Etat="Entree";
            
            Time[] listeTimeUnEmp=new AcceeBase().getTimeOneEmploye(perso);
            // temps=(listeTimeUnEmp[0].getTime()-p.getHeurepointage().getTime())/3600000;
           // JOptionPane.showMessageDialog(null,"Ataov serieu"+temps);
             
             if(nombrePointageUnJour==0)
             {
                 //verifier le pointage dernier hiere si <heure de rentree//
                 //new AllVerification().tesTeEntreeTard(p);
                 //new AllVerification().testerJourFerier(p);
                 //verification si a derniere sortie d'hiere est inf a sortie normal//
                 new Fonction().insertRetenuSiNonRetouravantRentreeNormal(perso, p);
                 temps=(listeTimeUnEmp[0].getTime()-p.getHeurepointage().getTime())/3600000;
                 //pointer la premiere foie entre 12h et 14h
                 if(p.getHeurepointage().getTime()>listeTimeUnEmp[2].getTime())
                 {
                    double decalage=(p.getHeurepointage().getTime()-listeTimeUnEmp[2].getTime())/3600000;
                    temps=temps+(decalage);
                 }
                 if(p.getHeurepointage().getTime()>listeTimeUnEmp[3].getTime())
                 {
                     double decalage=(p.getHeurepointage().getTime()-(listeTimeUnEmp[3].getTime()-listeTimeUnEmp[2].getTime()))/3600000;
                     temps=temps-(decalage);
                 }
           

                
             }
             else
             {
                 Object[] etat=new AcceeBase().getDernierEtatDunEmpl(perso, p);
                 String []splitDate=new Fonction().spliter(etat[1].toString(), ":");
                 int heure=Integer.parseInt(splitDate[0]);
                 int minute=Integer.parseInt(splitDate[1]);
                 int seconde=Integer.parseInt(splitDate[2]);
                 Time dernierPointageTime=new Time(heure,minute,seconde);
                
                 if(etat[0].toString().compareToIgnoreCase("Entree")==0)
                 {
                     Etat="Sortie";
                 }
                 
                 //entree sortie  entre 8h et 12h
                 if(p.getHeurepointage().getTime()<listeTimeUnEmp[2].getTime() && p.getHeurepointage().getTime()>listeTimeUnEmp[0].getTime())
                 {
                    
                     if(etat[0].toString().compareToIgnoreCase("Entree")==0)
                     {
                            int verif=new Confirmation().verificationFait("Voulez vous vraiment  sortir?" );
                            if(verif== JOptionPane.OK_OPTION)
                            {
                               // tbureau=listeTimeUnEmp[1];
                            }
                            else
                            {
                                throw new GestionExecption("Annuler");
                            } 
                     }
                     else
                     {
                          temps=((double)dernierPointageTime.getTime()- p.getHeurepointage().getTime())/3600000;
                     }
                 }
                     //entree entre 14h et 17h
                     
                 if(p.getHeurepointage().getTime()<listeTimeUnEmp[1].getTime() && p.getHeurepointage().getTime()>listeTimeUnEmp[3].getTime() )
                 {
                     if(etat[0].toString().compareToIgnoreCase("Entree")==0)
                     {
                            int verif=new Confirmation().verificationFait("Voulez vous vraiment  sortir?");
                            if(verif== JOptionPane.OK_OPTION)
                            {
                                if(dernierPointageTime.getTime()<listeTimeUnEmp[2].getTime())
                                {
                                    temps=(listeTimeUnEmp[3].getTime()-listeTimeUnEmp[2].getTime())/3600000; 
                                }
                            }
                            else
                            {
                                throw new GestionExecption("Annuler");
                            } 
                     }
                     else
                     {
                         //calculer decalage//
                         double decalage=(listeTimeUnEmp[3].getTime()-p.getHeurepointage().getTime())/3600000;
                         temps=((double)dernierPointageTime.getTime()- p.getHeurepointage().getTime())/3600000;
                         temps=temps+decalage;
                     }
                 }
                 //nuit pause et rentree
                 if(p.getHeurepointage().getTime()<listeTimeUnEmp[1].getTime() && poste.compareToIgnoreCase("nuit")==0 )
                 {
                     if(etat[0].toString().compareToIgnoreCase("Entree")==0)
                     {
                            int verif=new Confirmation().verificationFait("Voulez vous vraiment  sortir?");
                            if(verif== JOptionPane.OK_OPTION)
                            {
                                if(dernierPointageTime.getTime()<listeTimeUnEmp[2].getTime())
                                {
                                    temps=(listeTimeUnEmp[3].getTime()-listeTimeUnEmp[2].getTime())/3600000; 
                                }
                            }
                            else
                            {
                                throw new GestionExecption("Annuler");
                            } 
                     }
                     else
                     {
                         //calculer decalage//
                         //double decalage=(listeTimeUnEmp[3].getTime()-p.getHeurepointage().getTime())/3600000;
                         temps=((double)dernierPointageTime.getTime()- p.getHeurepointage().getTime())/3600000;
                         temps=temps;
                     }
                 }
                 //entre 12h et 14h
                 if(p.getHeurepointage().getTime()>listeTimeUnEmp[2].getTime() && p.getHeurepointage().getTime()<listeTimeUnEmp[3].getTime())
                 {
                     //la derniere entree inf a 12h
                    
                    if(etat[0].toString().compareToIgnoreCase("Entree")!=0)
                    {
                         double decalage=(dernierPointageTime.getTime()-(listeTimeUnEmp[2].getTime()))/3600000;
                         temps=(double)(listeTimeUnEmp[3].getTime()-p.getHeurepointage().getTime())/3600000;
                         temps=temps+decalage;
                    }
                    else
                    {
                          temps=((double)p.getHeurepointage().getTime()- listeTimeUnEmp[2].getTime())/3600000;
                    }
                 }
                 //superieur a 17h
                 if(p.getHeurepointage().getTime()>listeTimeUnEmp[1].getTime() && p.getHeurepointage().getTime()<new Time(20,0,0).getTime())
                 {
                     if(etat[0].toString().compareToIgnoreCase("Entree")==0)
                     {
                         // temps=(p.getHeurepointage().getTime()-dernierPointageTime.getTime())/3600000;
                         temps=(p.getHeurepointage().getTime()-listeTimeUnEmp[1].getTime())/3600000;
                     }
                     else
                     {
                         
                     } 
                 }
                 //inferieur a 8h
                 if(p.getHeurepointage().getTime()<listeTimeUnEmp[0].getTime()&& p.getHeurepointage().getTime()>new Time(5,0,0).getTime())
                 {
                     if(etat[0].toString().compareToIgnoreCase("Entree")!=0)
                     {
                        temps=(listeTimeUnEmp[0].getTime()-p.getHeurepointage().getTime())/3600000;
                     }
                 }
                 //travail de la nuit//
                 if((p.getHeurepointage().getTime()>new Time(20,0,0).getTime()&& poste.compareToIgnoreCase("nuit")!=0) || (p.getHeurepointage().getTime()<new Time(5,0,0).getTime() && poste.compareToIgnoreCase("nuit")!=0))
                 {
                     if(etat[0].toString().compareToIgnoreCase("Entree")!=0)
                     {
                        int verif=new Confirmation().verificationFait("Travail de la nuit");
                          if(verif== JOptionPane.OK_OPTION)
                          {
                              if(etat[0].toString().compareToIgnoreCase("Entree")==0){
                                    
                               }
                          }
                        else
                        {
                            throw new GestionExecption("Annulez?");
                        }
                     }
                     else
                     {
                         temps=Math.abs((p.getHeurepointage().getTime()-(double)dernierPointageTime.getTime())/3600000);
                     }
                           
                 }
                 //gardien
                 if((p.getHeurepointage().getTime()>new Time(5,0,0).getTime()&&poste.compareToIgnoreCase("nuit")==0 && p.getHeurepointage().getTime()<new Time(17,0,0).getTime()))
                 { 
                     if(etat[0].toString().compareToIgnoreCase("Entree")!=0)
                     {
                            int verif=new Confirmation().verificationFait("Travail du jour");
                            if(verif== JOptionPane.OK_OPTION)
                            {
                                if(etat[0].toString().compareToIgnoreCase("Entree")==0){
                                }
                                else
                                {
                                    
                                }
                            }
                            else
                            {
                                throw new GestionExecption("Annulez?");
                            }
                     }
                     else
                     {
                         temps=Math.abs((p.getHeurepointage().getTime()-(double)dernierPointageTime.getTime())/3600000);
                     }
                 }
                 //tomber a l'heure normle
                 if(p.getHeurepointage().getTime()==listeTimeUnEmp[0].getTime() || p.getHeurepointage().getTime()==listeTimeUnEmp[3].getTime())
                 {//s'il entre en 8 ou 14
                     if(etat[0].toString().compareToIgnoreCase("Entree")!=0){
                          temps=0;
                     }
                     else
                     {
                         temps=dernierPointageTime.getTime()-p.getHeurepointage().getTime();
                     }
                 }
                 if(p.getHeurepointage().getTime()==listeTimeUnEmp[1].getTime()||p.getHeurepointage().getTime()==listeTimeUnEmp[2].getTime())
                 {//s'il sort en 12h ou 17 h
                    if(etat[0].toString().compareToIgnoreCase("Entree")==0){
                          temps=0;
                          if(p.getHeurepointage().getTime()==listeTimeUnEmp[1].getTime() && dernierPointageTime.getTime()<listeTimeUnEmp[2].getTime())
                          {
                              temps=(listeTimeUnEmp[3].getTime()-listeTimeUnEmp[2].getTime())/3600000;
                          }
                    } 
                    else
                    {
                        temps=dernierPointageTime.getTime()-p.getHeurepointage().getTime();
                    }
                 }
             }
            //===================================// 
        Connection c = Connexion.getConnexion();
        //teste vaidation//
        //JOptionPane.showMessageDialog(null,"Ty alo o"+temps);
        int CountnmbrePointagePresence=new Fonction().testePointageRetourMemeJour(p, perso);
        //JOptionPane.showMessageDialog(null,"tafavoak"); 
        int plus24=new Fonction().plus24Heure(p, perso);
        if(CountnmbrePointagePresence!=0 && CountnmbrePointagePresence!=3)
        {
            try
            {
                    PreparedStatement ps = c.prepareStatement("insert into pointage(poste,matricule,datepointage,heurepointage,etat) values(?,?,?,?,?)");
                    ps.setString(1,poste);
                    ps.setInt(2, p.getMatricule());
                    ps.setDate(3, p.getDatepointage());
                    ps.setTime(4, p.getHeurepointage());
                    ps.setString(5,Etat);
                    ps.executeUpdate();    
            }       
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Probleme d,insertion de pointage"+ex.getMessage());
            }
        }
        else  if(new Fonction().testePointageRetourMemeJour(p, perso)==0)
        {
            //throw new GestionExecption("Pointage invalide, vous avez deja pointe a une heure supperieur a cette date ou heure");
        }
        //JOptionPane.showMessageDialog(null,"Probleme de requette getNombreSortieUneJourner:"+temps);
        //insertGainRetenu//
        new Fonction().insererGainRetenu(p, CountnmbrePointagePresence, poste, plus24, temps);
        //==========================//
       //insert to listePaie//
       
        return false;
    }
}
