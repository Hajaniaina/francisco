/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.sql.Date;

/**
 *
 * @author Bae
 */
public class Gains {
    private int idgain;
    private String motif;
    private double duree;
    private Date datesaisie;
    private int employe;
    private String poste;
    double montant;

    public Gains() {
    }

    public Gains(int idgain, String motif, double duree, Date datesaisie, int employe, String poste) {
        this.idgain = idgain;
        this.motif = motif;
        this.duree = duree;
        this.datesaisie = datesaisie;
        this.employe = employe;
        this.poste = poste;
    }

    public Gains(String motif, double montant) {
        this.motif = motif;
        this.montant = montant;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }



    public int getIdgain() {
        return idgain;
    }

    public void setIdgain(int idgain) {
        this.idgain = idgain;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public Date getDatesaisie() {
        return datesaisie;
    }

    public void setDatesaisie(Date datesaisie) {
        this.datesaisie = datesaisie;
    }

    public int getEmploye() {
        return employe;
    }

    public void setEmploye(int employe) {
        this.employe = employe;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
}
