/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.sql.Date;

/**
 *
 * @author User
 */
public class FichePaie {
    Gains[]listeGain;
    Retenues[]lsteRetenu;
    Personnel perso;
    Date dateEnbauche;
    double sommeGai;
    double sommeRetenus;
    double netApayer;
    
    public FichePaie(Gains[]lg, Retenues[]lret, Personnel per,double sommG, double sommeret,double netApayer)
    {
        this.listeGain=lg;
        this.lsteRetenu=lret;
        this.perso=per;
        this.sommeGai=sommG;
        this.sommeRetenus=sommeret;
        this.netApayer=netApayer;
    }
    
     public FichePaie(Gains[] listeGain, Retenues[] lsteRetenu, Personnel perso, Date dateEnbauche, double sommeGai, double sommeRetenus,double netApayer) {
        this.listeGain = listeGain;
        this.lsteRetenu = lsteRetenu;
        this.perso = perso;
        this.dateEnbauche = dateEnbauche;
        this.sommeGai = sommeGai;
        this.sommeRetenus = sommeRetenus;
        this.netApayer=netApayer;
    }

    public FichePaie() {
    }

    public Gains[] getListeGain() {
        return listeGain;
    }

    public void setListeGain(Gains[] listeGain) {
        this.listeGain = listeGain;
    }

    public Retenues[] getLsteRetenu() {
        return lsteRetenu;
    }

    public void setLsteRetenu(Retenues[] lsteRetenu) {
        this.lsteRetenu = lsteRetenu;
    }

    public Personnel getPerso() {
        return perso;
    }

    public void setPerso(Personnel perso) {
        this.perso = perso;
    }

    public double getSommeGai() {
        return sommeGai;
    }

    public void setSommeGai(double sommeGai) {
        this.sommeGai = sommeGai;
    }

    public double getSommeRetenus() {
        return sommeRetenus;
    }

    public void setSommeRetenus(double sommeRetenus) {
        this.sommeRetenus = sommeRetenus;
    }

    public double getNetApayer() {
        return netApayer;
    }

    public void setNetApayer(double netApayer) {
        this.netApayer = netApayer;
    }

    public Date getDateEnbauche() {
        return dateEnbauche;
    }

    public void setDateEnbauche(Date dateEnbauche) {
        this.dateEnbauche = dateEnbauche;
    }
    
    
}
