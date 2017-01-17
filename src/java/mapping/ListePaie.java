/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import Exception.GestionExecption;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Bae
 */
public class ListePaie {
    private int idpaie;
    private int idpers;
    double salairedebase;
    String nomPer;
    String poste;
    private double sommeGains;
    private double sommeRetenues;
    private double resteApayer;
    private  double dejaPayer;
    private int moi;
    int annee;

    public ListePaie() {
    }

    public ListePaie( double sommeGain, double sommeRetenu,double resteApa, int mois,int annees) {
        this.sommeGains = sommeGains;
        this.sommeRetenues = sommeRetenues;
        this.resteApayer=resteApa;
        this.moi=mois;
        this.annee=annees;
    }

    public ListePaie(int idPaie,int idpers,String  nomPer,String poste, double salairedebase, double sommeGains, double sommeRetenues, double resteApayer, int moi, int annee) {
         this.idpaie = idPaie;
        this.idpers = idpers;
        this.salairedebase = salairedebase;
        this.sommeGains = sommeGains;
        this.sommeRetenues = sommeRetenues;
        this.resteApayer = resteApayer;
        this.moi = moi;
        this.annee = annee;
        this.nomPer=nomPer;
        this.poste=poste;
        this.dejaPayer=dejaPayer;
    }
    

    public int getIdpaie() {
        return idpaie;
    }

    public void setIdpaie(int idpaie) {
        this.idpaie = idpaie;
    }

    public int getIdpers() {
        return idpers;
    }

    public void setIdpers(int idpers) {
        this.idpers = idpers;
    }

    public double getSommeGains() {
        return sommeGains;
    }

    public void setSommeGains(double sommeGains) {
        this.sommeGains = sommeGains;
    }

    public double getSommeRetenues() {
        return sommeRetenues;
    }

    public void setSommeRetenues(double sommeRetenues) {
        this.sommeRetenues = sommeRetenues;
    }

    public int getMoin() {
        return moi;
    }

    public void setMoi(String moi) {
       int mo=12;
      
       if(moi==null)
        {
            moi="12";
        }

        try
        {
             mo=Integer.parseInt(""+moi);
        }
        catch(Exception ex)
        {
             new GestionExecption("Moi invalide");
        }
        if(mo>12 || mo<1)
        {
            new GestionExecption("Moi invalide");
        }
        this.moi = mo;
    }
    public int getAnnee()
    {
        return annee;
    }
    
    public void setAnnee(String annee)
    {
        int an=2016;
      
         if(annee==null)
         {
             annee="2016";
         }
        try
        {
            an=Integer.parseInt(""+annee);
        }
        catch(Exception ex)
        {
             new GestionExecption("Annee invalide");
        }
        if(an<0 ||annee.length()<4 )
        {
           new GestionExecption("Annee invalide");
        }
        this.annee=an;
    }
    
    

    public double getResteApayer() {
        return resteApayer;
    }

    public void setResteApayer(double resteApayer) {
        this.resteApayer = resteApayer;
    }
    
    public double getSalairedebase() {
        return salairedebase;
    }

    public void setSalairedebase(double salairedebase) {
        this.salairedebase = salairedebase;
    }

    public String getNomPer() {
        return nomPer;
    }

    public void setNomPer(String nomPer) {
        this.nomPer = nomPer;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getDejaPayer() {
        return dejaPayer;
    }

    public void setDejaPayer(double dejaPayer) {
        this.dejaPayer = dejaPayer;
    }
    
    
    
    
}
