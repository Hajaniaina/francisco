/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple;

import java.sql.Date;
import mapping.Personnel;

/**
 *
 * @author User
 */
public class SemaineUnEmploye {
    Object[]date;
    Object[]heure;
    Personnel p;
    Date semaine;
    

    public SemaineUnEmploye(Object[] date, Object[] heure, Personnel p) {
        this.date = date;
        this.heure = heure;
        this.p = p;
    }

    public SemaineUnEmploye(Object[] date, Object[] heure, Personnel p, Date semaine) {
        this.date = date;
        this.heure = heure;
        this.p = p;
        this.semaine = semaine;
    }
    
    

    public Object[] getDate() {
        return date;
    }

    public void setDate(Object[] date) {
        this.date = date;
    }

    public Object[] getHeure() {
        return heure;
    }

    public void setHeure(Object[] heure) {
        this.heure = heure;
    }

    public Personnel getP() {
        return p;
    }

    public void setP(Personnel p) {
        this.p = p;
    }

    public Date getSemaine() {
        return semaine;
    }

    public void setSemaine(Date semaine) {
        this.semaine = semaine;
    }
    
    
}
