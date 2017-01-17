/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple;

/**
 *
 * @author User
 */
public class SemainePointage {
    SemaineUnEmploye[]liste;

    public SemainePointage() {
    }

    public SemainePointage(SemaineUnEmploye[] liste) {
        this.liste = liste;
    }

    public SemaineUnEmploye[] getListe() {
        return liste;
    }

    public void setListe(SemaineUnEmploye[] liste) {
        this.liste = liste;
    }
    
}
