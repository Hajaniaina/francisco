/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple.Fonction;

import Selection.SelectRetardUnEmpSemaine;
import java.sql.Date;

/**
 *
 * @author User
 */
public class GetRetardParJour {
    
    public Object[][]retardParJour(int Matricule,Date d)
    {
        Object[][]ret=new SelectRetardUnEmpSemaine().getRetUnEmpJour(Matricule, d);
        return ret; 
    }
}
