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
public class Retenues {
    private int idRetenu;
    private String motif;
    private double duree;
    private Date datesaisie;
    private int employe;
    private String poste;
    double montant;

    public Retenues() {
    }

    public Retenues(int idRetenu, String motif, double duree, Date datesaisie, int employe, String poste) {
        this.idRetenu = idRetenu;
        this.motif = motif;
        this.duree = duree;
        this.datesaisie = datesaisie;
        this.employe = employe;
        this.poste = poste;
    }

    public Retenues(String motif, double montant) {
        this.motif = motif;
        this.montant = montant;
    }
    


    public int getIdRetenu() {
        return idRetenu;
    }

    public void setIdRetenu(int idRetenu) {
        this.idRetenu = idRetenu;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    
}
