/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple;

import connexion.AcceeBase;
import java.sql.Time;
import javax.swing.JOptionPane;
import mapping.Personnel;
import parser.ParseTime;

/**
 *
 * @author User
 */
public class ListeRetParJourEtSemaineEmp {

   
    Object []heureEntree;
    Object[] ret;
    String sommeRet;

    public ListeRetParJourEtSemaineEmp(Object[] heureEntree, Object[] ret, String sommeRet) {
        this.heureEntree = heureEntree;
        this.ret = ret;
        this.sommeRet = sommeRet;
    }

    public ListeRetParJourEtSemaineEmp() {
    }

    public Object[] getHeureEntree() {
        return heureEntree;
    }

    public void setHeureEntree(Object[] heureEntree) {
        this.heureEntree = heureEntree;
    }

    public Object[] getRet() {
        return ret;
    }

    public void setRet(Object[] ret) {
        this.ret = ret;
    }

    public String getSommeRet() {
        return sommeRet;
    }

    public void setSommeRet(String sommeRet) {
        this.sommeRet = sommeRet;
    }
    
    
    
     
    
            
    
    //convert retart  en miliseconde
    public double convertRetarEnMilliseconde(String ret)
    {
        String[]spitRet=new String[2];
        double timeConvertRet=0;
        String concqtRet=ret.concat(",0");
        for(int i=0;i<2;i++)
        {
            spitRet[i]=new String();
            
        }
       
        spitRet  =concqtRet.split(",");
        timeConvertRet=new Time(Integer.parseInt(spitRet[0]),Integer.parseInt(spitRet[1]),0).getTime();
        //JOptionPane.showMessageDialog(null,"mtocy  v:"+new Time(Integer.parseInt(spitRet[0]),Integer.parseInt(spitRet[1]),0));
        return timeConvertRet;
    }
    //convert heure en milisecode
    public double convertHeureEnMilliseconde(String heure)
    {
        if(heure=="")
        {
            heure="00h00";
        }
        String convrtTime=ParseTime.parse_String_to_Time(heure);
        double heurepointage =Time.valueOf(convrtTime).getTime();
        return heurepointage;
    }
    
    //Time en milliseconde//
    public double timeEnmillisecode(Time t)
    {
        return t.getTime();
    }
    //Get heure  entree d'un emp//
    
    public Time[]getHeureEntreeNormalUnEmploye(Personnel perso)
    {
        Time[] listeTimeUnEmp=new AcceeBase().getTimeOneEmploye(perso);
        return listeTimeUnEmp;
    }
    //convert resultat en heure//
    public String heure(double millisecodeHeure)
    { 
        double ajout=this.convertRetarEnMilliseconde("9");
        String time=""+((millisecodeHeure+ajout)/3600000);
        String ret=ParseTime.parse_String_to_Time(time);
        return ret;
    }
    //convert resultat en retard//
    public int  retard(double millisecondeRet)
    {   double ret=millisecondeRet/3600000;
      if(ret>0)
      {
          return (int) (millisecondeRet/3600000);
      }
      else
      {
          return 0;
      }
        
    }
    //Liste ret Par jour et entree par jour et somme par smaine d'un employe
    
    public Object[][] getRetHeurESommeRetSemaine(Object[]heureEntreeSemaine,Object[]retartSemaine,Personnel p)
    {
        Object[][] ret=new Object[2][7];
        double sommeRetour=0;
        Time[]entreeNormal=this.getHeureEntreeNormalUnEmploye(p);
        
        
        try{
        for(int i=0;i<7;i++)
        {
            //____________________________________________//
              double r=Double.parseDouble(""+this.convertRetarEnMilliseconde(retartSemaine[i].toString()));
              double h =Double.parseDouble(""+this.convertHeureEnMilliseconde(heureEntreeSemaine[i].toString()));
        //_____________________________________________//
            //JOptionPane.showMessageDialog(null,"Matricule:"+retartSemaine[i].toString());
            if(heureEntreeSemaine[i].toString().compareToIgnoreCase("")==0 && retartSemaine[i].toString().compareToIgnoreCase("0,0")!=0 )
            {
                double heure=this.convertRetarEnMilliseconde(retartSemaine[i].toString())+this.timeEnmillisecode(entreeNormal[0]);
                ret[0][i]=this.heure(heure);
                ret[1][i]=retartSemaine[i];
                //JOptionPane.showMessageDialog(null,"Matricule:");
                        
            }
           
            if(retartSemaine[i].toString().compareToIgnoreCase("0,0")==0 && heureEntreeSemaine[i].toString().compareToIgnoreCase("")!=0)
            {
                double retard=this.convertHeureEnMilliseconde(heureEntreeSemaine[i].toString())-this.timeEnmillisecode(entreeNormal[0]);
                ret[0][i]=heureEntreeSemaine[i];
                ret[1][i]=this.retard(retard); 
            }
            if(heureEntreeSemaine[i].toString().compareToIgnoreCase("")==0 && retartSemaine[i].toString().compareToIgnoreCase("0,0")==0 )
            {
                ret[0][i]=""+0;
                ret[1][i]=""+0; 
                
            }
             if(heureEntreeSemaine[i].toString().compareToIgnoreCase("")!=0 && retartSemaine[i].toString().compareToIgnoreCase("0,0")!=0)
            {
                ret[0][i]=heureEntreeSemaine[i];
                ret[1][i]= retartSemaine[i];
            }
             if (heureEntreeSemaine[i].toString().compareToIgnoreCase("0")==0 && retartSemaine[i].toString().compareToIgnoreCase("0")==0)
             {
                ret[0][i]=heureEntreeSemaine[i];
                ret[1][i]= retartSemaine[i];
                
             }
            
            if(heureEntreeSemaine[i].toString().compareToIgnoreCase("0")==0 && retartSemaine[i].toString().compareToIgnoreCase("0")!=0 )
            {
                double heure=this.convertRetarEnMilliseconde(retartSemaine[i].toString())+this.timeEnmillisecode(entreeNormal[0]);
                ret[0][i]=this.heure(heure);
                ret[1][i]=retartSemaine[i];
               
            }
            if(heureEntreeSemaine[i].toString().compareToIgnoreCase("00h00")==0 && retartSemaine[i].toString().compareToIgnoreCase("0.0")!=0 )
            {
                double heure=this.convertRetarEnMilliseconde(retartSemaine[i].toString())+this.timeEnmillisecode(entreeNormal[0]);
                ret[0][i]=this.heure(heure);
                ret[1][i]=retartSemaine[i];
               
            }
            if(retartSemaine[i].toString().compareToIgnoreCase("0.0")==0 && heureEntreeSemaine[i].toString().compareToIgnoreCase("0")!=0)
            {
                double retard=this.convertHeureEnMilliseconde(heureEntreeSemaine[i].toString())-this.timeEnmillisecode(entreeNormal[0]);
                ret[0][i]=heureEntreeSemaine[i];
                ret[1][i]=this.retard(retard); 
            }
            
            if(retartSemaine[i].toString().compareToIgnoreCase("0")==0 && heureEntreeSemaine[i].toString().compareToIgnoreCase("0")!=0)
            {
                double retard=this.convertHeureEnMilliseconde(heureEntreeSemaine[i].toString())-this.timeEnmillisecode(entreeNormal[0]);
                ret[0][i]=heureEntreeSemaine[i];
                ret[1][i]=this.retard(retard); 
            }
            if(retartSemaine[i].toString().compareToIgnoreCase("0,0")==0 && heureEntreeSemaine[i].toString().compareToIgnoreCase("0")!=0)
            {
                double retard=this.convertHeureEnMilliseconde(heureEntreeSemaine[i].toString())-this.timeEnmillisecode(entreeNormal[0]);
                ret[0][i]=heureEntreeSemaine[i];
                ret[1][i]=this.retard(retard); 
            }
             //JOptionPane.showMessageDialog(null,"Matricule v:"+r +"et:"+h);
            if(-r>=0 && h>0)
            {
               
                double retard=this.convertHeureEnMilliseconde(heureEntreeSemaine[i].toString())-this.timeEnmillisecode(entreeNormal[0]);
                double heure=this.convertRetarEnMilliseconde(retartSemaine[i].toString())+this.timeEnmillisecode(entreeNormal[0]);
                ret[0][i]=this.heure(heure);
                //ret[0][i]=heureEntreeSemaine[i].toString();
               // ret[1][i]=this.retard(retard); 
               ret[1][i]=retartSemaine[i].toString();
            }
            if(r>=0 && h>0)
            {
               
                double retard=this.convertHeureEnMilliseconde(heureEntreeSemaine[i].toString())-this.timeEnmillisecode(entreeNormal[0]);
                double heure=this.convertRetarEnMilliseconde(retartSemaine[i].toString())+this.timeEnmillisecode(entreeNormal[0]);
                ret[0][i]=this.heure(heure);
                //ret[0][i]=heureEntreeSemaine[i].toString();
                //ret[1][i]=this.retard(retard); 
                ret[1][i]=retartSemaine[i].toString();
            }
            sommeRetour+=Double.parseDouble(ret[1][i].toString());
            this.sommeRet=""+sommeRetour;
        }
        
       
        
        }
        catch(Exception ex)
        {
            
        }
         //JOptionPane.showMessageDialog(null,"Matricule v:"+this.getSommeRet());
        return ret;
    }
    
    //partager la somme de retard par semaine en jour
    
    public Object[]heurePartager(int sommeNormal, int sommeAjouter)
    {
        Object []ret=new Object[7];
        
        for(int i=0;i<7;i++)
        {
            int parJ=sommeAjouter/7;
            ret[i]=parJ;
        }
        return ret;
    }
    
}
