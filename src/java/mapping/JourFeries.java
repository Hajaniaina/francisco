/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Bae
 */
public class JourFeries {
  private int idjf;
  private Date dateinsertion;
  private String motif;
  private Time heuredebut;
  private Time heurefin;

    public JourFeries() {
    }

    public JourFeries(int idjf, Date dateinsertion, String motif, Time heuredebut, Time heurefin) {
        this.idjf = idjf;
        this.dateinsertion = dateinsertion;
        this.motif = motif;
        this.heuredebut = heuredebut;
        this.heurefin = heurefin;
    }

    public int getIdjf() {
        return idjf;
    }

    public void setIdjf(int idjf) {
        this.idjf = idjf;
    }

    public Date getDateinsertion() {
        return dateinsertion;
    }

    public void setDateinsertion(Date dateinsertion) {
        this.dateinsertion = dateinsertion;
    }
    /////////STRING TO DATE 
    public void setDateinsertion(String dateinsertion) {
        this.dateinsertion = Date.valueOf(dateinsertion);
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Time getHeuredebut() {
        return heuredebut;
    }

    public void setHeuredebut(Time heuredebut) {
        this.heuredebut = heuredebut;
    }
    /////////STRING TO TIME 
    public void setHeuredebut(String heuredebut) {
        this.heuredebut = Time.valueOf(heuredebut+":00");
    }

    public Time getHeurefin() {
        return heurefin;
    }

    public void setHeurefin(Time heurefin) {
        this.heurefin = heurefin;
    }
    
    /////////Sting to time
    public void setHeurefin(String heurefin) {
        this.heurefin = Time.valueOf(heurefin+":00");
    }
 
}
