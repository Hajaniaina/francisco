/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

/**
 *
 * @author Bae
 */
public class Personnel {
    private int matricule;
    private String nom;
     private String typeTravail;
    private double salairedebase;
    public String codeMatricule;
    String poste;

    public Personnel() {
    }

    public Personnel(int matricule, String nom, double salairedebase) {
        this.matricule = matricule;
        this.nom = nom;
        this.salairedebase = salairedebase;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getcodeMatricule() {
        return codeMatricule;
    }

    public void setcodeMatricule(String codeMatricule) {
        this.codeMatricule = codeMatricule;
    }
    
     public String gettypeTravail() {
        return typeTravail;
    }

    public void settypeTravail(String newtypeTravail) {
        this.typeTravail = newtypeTravail;
    }

    public double getSalairedebase() {
        return salairedebase;
    }

    public void setSalairedebase(double salairedebase) {
        this.salairedebase = salairedebase;
    } 

    public String getTypeTravail() {
        return typeTravail;
    }

    public void setTypeTravail(String typeTravail) {
        this.typeTravail = typeTravail;
    }

    public String getCodeMatricule() {
        return codeMatricule;
    }

    public void setCodeMatricule(String codeMatricule) {
        this.codeMatricule = codeMatricule;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
    
}
