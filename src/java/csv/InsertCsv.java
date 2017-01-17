/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import Exception.GestionExecption;
import PointageMultiple.Fonction.IsertPointageMultple;
import PointageMultiple.SemainePointage;
import PointageMultiple.SemaineUnEmploye;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class InsertCsv {
    
    public void insertCsvToBase(String path) throws ParseException, SQLException, GestionExecption
    {
       LectureCsv Lcsv= new LectureCsv();
        SemaineUnEmploye[]Semp=Lcsv.DateHeureEmpInCsv(path);
        SemainePointage semPoint=new SemainePointage(Semp);
        String []listeMatr=new String[Semp.length];
        for(int i=0;i<Semp.length;i++)
        listeMatr=Lcsv.getListeMatr();
        new IsertPointageMultple().insertPointagePultiple(semPoint,listeMatr);
    }
}
