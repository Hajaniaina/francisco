/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonction;

import Exception.GestionExecption;
import DateTime.DateHeure;
import Insertion.InsertRetenu;
import Insertion.InsertGains;
import Insertion.InsertListePaie;
import Selection.SelectInPersonnel;
import calcul.calculRetardAbsSuppl;
import connexion.AcceeBase;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import mapping.EmploiDuTemps;
import mapping.Personnel;
import mapping.Pointage;
import metier.AllVerification;

/**
 *
 * @author User
 */
public class Fonction {
    
    public Object[][] getAllEploye(int moi,int annee)
    {
        return new AcceeBase().getAllAmploye(moi, annee);
    }
    
    public Object[][] getAllJourFerier(Date annee)
    {
        return new AcceeBase().getAllJourFerier(annee);
    }
    //tester le jour ferier//
    public boolean testeJourferier(Date annee,Pointage p)
    {
        boolean retour=true;
        Date d=p.getDatepointage();
        Object[][]datJF=new Fonction().getAllJourFerier(annee);
        
        for (int i=0;i<datJF.length;i++)
        {
            if(d==datJF[0][i])
            {
                return retour=true;
            }
            else
              return retour= false;
        }
      return retour;
    }
     public boolean testeJourferier2(Date annee,Date d)
    {
        boolean retour=true;
        Object[][]datJF=new Fonction().getAllJourFerier(annee);
        
        for (int i=0;i<datJF.length;i++)
        {
            if(d==datJF[0][i])
            {
                return retour=true;
            }
            else
              return retour= false;
        }
      return retour;
    }
    //public testeAbscence//
    
    //teste de pointage inferieur a dernier pointage memejour,, impossible
    
    public int  testePointageRetourMemeJour(Pointage p,Personnel per)
    {
        
       int  ret=0;
        Date d=p.getDatepointage();
        Date dernierePoint=new Date(0,0,0);
        Time derniereP=new Time(0,0,0);
        Object[]TimeDatedernPoint=new AcceeBase().dernierPointage(per);
        if(TimeDatedernPoint[0]!=null)
        {
             
                 dernierePoint=(Date)TimeDatedernPoint[0];
                 derniereP=(Time)TimeDatedernPoint[1];
        }
        Time[] listeTimeUnEmp=new AcceeBase().getTimeOneEmploye(per);
        //long nbHeures = ((d.getTime() -  dernierePoint.getTime()) /3600000);
         long nbHeures=1;
        long timeointage=((p.getHeurepointage().getTime()-derniereP.getTime()) /3600000);
        if(nbHeures>=48)
        {
            if(TimeDatedernPoint[0]!=null)
            {
               return 1;
            }
            else
            {
                return 2;
            }
           
        }
        if(nbHeures<0)
        {
           return 0;
        }
        if(nbHeures==0)
        {
            if(timeointage==0)
            {
                 return 3;
            }
            if(timeointage<0)
            {
                return 0;
            }
            else 
            {
                return 2;
            }
        }
        else 
        {
           return 2;
        }
      
    }
    
    //return plus de 24 heures
    
    public int plus24Heure(Pointage p,Personnel per) throws SQLException
    {

        Date d=p.getDatepointage();
        Date  totalHeure=new Date(0,0,0);
        long ret=0;
        Time[] listeTimeUnEmp=new AcceeBase().getTimeOneEmploye(per);
        Object[] dernierePoint=new AcceeBase().dernierPointage(per);
        Date dernierPointagr=(Date)dernierePoint[0]; 
       List<Date>listeJourAbs=new Fonction().listeDesDates(dernierPointagr,d); 
        if(new AcceeBase().dernierPointage(per)[0]!=null)
        {
            for(int i =0;i<listeJourAbs.size()-2;i++)
            {
                //JOptionPane.showMessageDialog(null,"Probleme de requette getNombreSortieUneJourner:"+listeJourAbs.get(i));

                if( !new Fonction().testeJourFerierOUWeekend2(listeJourAbs.get(i),p))
                {
                   // int temps=(int) ((int) ((listeTimeUnEmp[1].getTime()-listeTimeUnEmp[0].getTime())/3600000)-((listeTimeUnEmp[3].getTime()-listeTimeUnEmp[2].getTime())/3600000));
                    int temps=(int) (listeTimeUnEmp[1].getTime()-p.getHeurepointage().getTime());
                   // totalHeure=(Date)listeJourAbs.get(i);
                    ret+=temps;
                   //JOptionPane.showMessageDialog(null,"Probleme de requette getNombreSortieUneJourner:"+ret);

                }
            }
        }
        long nbHeures = (ret);

        return Integer.parseInt(""+nbHeures);
    }
    
    //fonction calculer la duree d'abscence//
    public int calculTempsbs(int tempPourCalculer)
    {
        int temps=tempPourCalculer*8/24;
        return temps;
    }
    //fonction spilter
    public String[] spliter(String txt,String sep)
    {
        String []resp=txt.split(sep);
        return resp;
    }
    
    
    //getHeurTravailSuplementaire wek end ou jourferer//
    public int getHEureSupJfetWeekEnd(Personnel perso, Pointage p) throws SQLException
    {
            Object[] etat=new AcceeBase().getDernierEtatDunEmplWeekJf(perso, p);
            int temps=0;
            String []splitDate=new Fonction().spliter(etat[1].toString(), ":");
            int heure=Integer.parseInt(splitDate[0]);
            int minute=Integer.parseInt(splitDate[1]);
            int seconde=Integer.parseInt(splitDate[2]);
            Time dernierPointageTime=new Time(heure,minute,seconde);
         if(etat[0].toString().compareToIgnoreCase("Entree")==0)
         {
             temps=Math.abs((int) (((double)dernierPointageTime.getTime()- p.getHeurepointage().getTime())/3600000));
             return temps;
         }
         else
         {
             return temps;
         }
    }
    
    //insert abs, jrf,hsp en reternu et gain//
    public void insererGainRetenu(Pointage p,int CountnmbrePointagePresence,String poste,int plus24,double temps ) throws SQLException, GestionExecption
    {
         ///gain et retenue//
        Personnel pers=new Personnel();
        pers.setMatricule(p.getMatricule());
        EmploiDuTemps e = new EmploiDuTemps();
        InsertRetenu ir = new InsertRetenu();
        InsertGains ig = new InsertGains();
        InsertListePaie insP=new InsertListePaie();
        
        //getSalaire de base d'un employe
        double salaireB=new SelectInPersonnel().getSalaire(pers.getMatricule());
        //teste Abscence //
        if(poste.compareToIgnoreCase("bureau")==0){
            if(CountnmbrePointagePresence==1)
            {
                int tempAbs=plus24;
                  //JOptionPane.showMessageDialog(null, tempAbs);
                 tempAbs=Math.abs(tempAbs);
                 ir.insertRetenu("abs",tempAbs,p.getDatepointage(),p.getMatricule(),poste);
                
                  //insertion associe au paie du pointage
                 double abs=new calculRetardAbsSuppl().calculAbs(salaireB, tempAbs);
                 insP.insertListePaie(0, abs, p, pers,"abscence",10);
            } 
            else
            {   
            //teste abscence en week end et jour ferier//
                //if(!new Fonction().testeJourFerierOUWeekend(p.getDatepointage(),p))
                if(true)
                {
                     if(temps<0){
                     temps=Math.abs(temps);
                    ir.insertRetenu("retard",temps,p.getDatepointage(),p.getMatricule(),poste);
                    
                     //insertion associe au paie du pointage
                    double retard=new calculRetardAbsSuppl().calculRetard(salaireB, (int) temps);
                    insP.insertListePaie(0, retard, p, pers,"Retard",20);
                    }
                    else if(temps>0){
                    ig.insertGain("Heure supl",temps,p.getDatepointage(),p.getMatricule(),poste);
                    
                     //insertion associe au paie du pointage
                     double hsp=new calculRetardAbsSuppl().calculSupplementaire(salaireB, (int) temps);
                     insP.insertListePaie(hsp, 0, p, pers,"Heure sup",30);
                    }
                }
                else
                {
                    int heurSup=new Fonction().getHEureSupJfetWeekEnd(pers, p);
                    ig.insertGain("Heure supl",heurSup,p.getDatepointage(),p.getMatricule(),poste);
                    
                    //insertion associe au paie du pointage
                    double hsp=new calculRetardAbsSuppl().calculSupplementaire(salaireB, (int) heurSup);
                    insP.insertListePaie(hsp, 0, p, pers,"Heure sup",30);
                }
            }
        }
        if(poste.compareToIgnoreCase("nuit")==0){
           //double tempsn = ((double)tbureau.getTime() - p.getHeurepointage().getTime())/3600000;
            if(CountnmbrePointagePresence==1)
            {
                int tempAbs=new Fonction().calculTempsbs(plus24);
                ir.insertRetenu("abs",tempAbs,p.getDatepointage(),p.getMatricule(),poste);
                
                //insertion associe au paie du pointage
                double abs=new calculRetardAbsSuppl().calculAbs(salaireB, (int) tempAbs);
                insP.insertListePaie(0, abs, p, pers,"abscence",10);
   
            }
            else
            {
              if(!new Fonction().testeJourferier(p.getDatepointage(), p))
              {
               if(temps<0){
                   temps=Math.abs(temps);
                    ir.insertRetenu("retard",temps,p.getDatepointage(),p.getMatricule(),poste);
                    
                    //insertion associe au paie du pointage
                     double retar=new calculRetardAbsSuppl().calculRetard(salaireB, (int) temps);
                     insP.insertListePaie(0, retar, p, pers,"Retard",20);
                }
                else if(temps>0){
                    //JOptionPane.showMessageDialog(null,"Ataov serieu"+temps);
                    ig.insertGain("Heure supl",temps,p.getDatepointage(),p.getMatricule(),poste);
                    
                    //insertion associe au paie du pointage
                    double hsp=new calculRetardAbsSuppl().calculSupplementaire(salaireB, (int) temps);
                    insP.insertListePaie(hsp, 0, p, pers,"Heure sup",30);
                    
                }
              }
              else
              {
                 int heurSup=new Fonction().getHEureSupJfetWeekEnd(pers, p);
                 ig.insertGain("Heure supl",heurSup,p.getDatepointage(),p.getMatricule(),poste);
                 
                 //insertion associe au paie du pointage
                 double hsp=new calculRetardAbsSuppl().calculSupplementaire(salaireB, (int) temps);
                 insP.insertListePaie(hsp, 0, p, pers,"Heure sup",30);
              }
            }
           
        }
         //throw new GestionExecption("Pointage bien fait");
    }
    //Ra ts mvern tson apres mvoaka//
    public void insertRetenuSiNonRetouravantRentreeNormal(Personnel p,Pointage point) throws SQLException, GestionExecption
    {
         Object[]listeDernierPointage=new AcceeBase().dernierPointage(p);
         Time[] listeTimeUnEmp=new AcceeBase().getTimeOneEmploye(p);
         String poste=new AcceeBase().getPosteWhereMatricule(p);
         InsertRetenu ir = new InsertRetenu();
        Date dernierPointagr=(Date)listeDernierPointage[0]; 
         
         //GET SALAIRE DE BASE
            InsertListePaie insP=new InsertListePaie();
           double salaireB=new SelectInPersonnel().getSalaire(p.getMatricule());
           //==========================//
        if(listeDernierPointage[1]!=null)
        {
                  //&& new Fonction().testeJourFerierOUWeekend((Date)listeDernierPointage[0],point)
                 String []splitDate=new Fonction().spliter(listeDernierPointage[1].toString(), ":");
                 int heure=Integer.parseInt(splitDate[0]);
                 int minute=Integer.parseInt(splitDate[1]);
                 int seconde=Integer.parseInt(splitDate[2]);
                 Time dernierPointageTime=new Time(heure,minute,seconde);
                 if(dernierPointageTime.getTime()<listeTimeUnEmp[1].getTime()&& !new Fonction().testeJourFerierOUWeekend2(dernierPointagr,point) )
                 {
                     if(point.getType().compareToIgnoreCase("simple")==0)
                     {
                         JOptionPane.showMessageDialog(null, "Miditra");
                        double temps=Math.abs((dernierPointageTime.getTime()-listeTimeUnEmp[1].getTime())/3600000);
                       //JOptionPane.showMessageDialog(null, "Vous avez sortir avant l'heure normal la drniere fois, retard:" + new Fonction().testeJourFerierOUWeekend2(dernierPointagr,point)+"et"+dernierPointagr);
                        ir.insertRetenu("retard",temps,(Date)listeDernierPointage[0],p.getMatricule(),poste);

                         //insertion associe au paie du pointage
                        double retar=new calculRetardAbsSuppl().calculRetard(salaireB, (int) temps);
                        insP.insertListePaie(0, retar, point, p,"Retard",20);
                     }
                     
                 }
        }
    }
    
    //liset date entre deux dates donnee
    
    public static  List<Date>  listeDesDates (Date DateDebut, Date DateFin)
    {
        GregorianCalendar cal = new GregorianCalendar();
      
        if( DateDebut==null)
        {
           DateDebut=DateFin;
        }
        cal.setTime(DateDebut); 
        Vector dates = new Vector();
        int i=0;
        String s = DateDebut.toString();
        String e = DateFin.toString();
        LocalDate start = LocalDate.parse(s);
        LocalDate end = LocalDate.parse(e);
        List<Date> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            start = start.plusDays(1);
            Date convert=Date.valueOf(start);
            dates.add(convert);
            //start = start.plusDays(1);
        }    
        
        return dates;
  }
    
    //fonction permoter//
    
    public String  permuter(String [] chaine)
    {
        int enleve=Integer.parseInt(chaine[0])-2000;
        String temps=new String(""+enleve);
        int length=chaine.length;
        chaine[0]=chaine[length-1];
        chaine[length-1]=temps;
        String ret;
        return ret=new DateHeure().concatenerDateEtHeure(chaine[0],chaine[1],chaine[length-1],"-");
    }
    
    //function tester si jour ferier ou week end//
    
    public boolean testeJourFerierOUWeekend(Date d, Pointage p)
    {
       boolean jf= new Fonction().testeJourferier(p.getDatepointage(), p);
       boolean we=new AllVerification().testeWeekEnd(p.getDatepointage());
       if(jf && we)
       {
           return true;
       }
       if((!jf && we) ||(jf && !we))
       {
           return true;
       }
       else
       {
           return false;
       }
    }
    //-------------------------------------------------//
    public boolean testeJourFerierOUWeekend2(Date d, Pointage p)
    {
       boolean jf= new Fonction().testeJourferier2(d, d);
       boolean we=new AllVerification().testeWeekEnd(d);
       if(jf && we)
       {
           return true;
       }
       if((!jf && we) ||(jf && !we))
       {
           return true;
       }
       else
       {
           return false;
       }
    }
}
