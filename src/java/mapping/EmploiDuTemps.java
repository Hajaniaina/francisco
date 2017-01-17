/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.sql.Time;

/**
 *
 * @author Bae
 */
public class EmploiDuTemps {
    private int idet;
    private Time hentree;
    private Time hsortie;
    private Time hmaxsortie;
    private Time hmaxentree;
    private String poste;

    public EmploiDuTemps() {
    }

    public EmploiDuTemps(int idet, Time hentree, Time hsortie, Time hmaxsortie, Time hmaxentree,String poste) {
        this.idet = idet;
        this.hentree = hentree;
        this.hsortie = hsortie;
        this.hmaxsortie = hmaxsortie;
        this.hmaxentree = hmaxentree;
        this.poste=poste;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getIdet() {
        return idet;
    }

    public void setIdet(int idet) {
        this.idet = idet;
    }

    public Time getHentree() {
        return hentree;
    }

    public void setHentree(Time hentree) {
        this.hentree = hentree;
    }

    public Time getHsortie() {
        return hsortie;
    }

    public void setHsortie(Time hsortie) {
        this.hsortie = hsortie;
    }

    public Time getHmaxsortie() {
        return hmaxsortie;
    }

    public void setHmaxsortie(Time hmaxsortie) {
        this.hmaxsortie = hmaxsortie;
    }

    public Time getHmaxentree() {
        return hmaxentree;
    }

    public void setHmaxentree(Time hmaxentree) {
        this.hmaxentree = hmaxentree;
    }
}
