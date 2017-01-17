/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple.Fonction;

import Exception.GestionExecption;
import Insertion.InsertPointages;
import PointageMultiple.SemainePointage;
import Selection.GetAllEmploye;
import connexion.AcceeBase;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import mapping.Personnel;
import mapping.Pointage;

/**
 *
 * @author User
 */
public class IsertPointageMultple {
    
    public void insertPointagePultiple(SemainePointage liste,String[]codeMatr) throws ParseException, SQLException, GestionExecption
    {
        GetAllEmploye getAllEmp =new GetAllEmploye();
        Object[][]all=getAllEmp.getAllAmploye();
        
        for(int i=0;i<all.length;i++)
        {
            //JOptionPane.showMessageDialog(null,"legth:"+liste.getListe()[1].getHeure()[0]);
            Object []heure=liste.getListe()[i].getHeure();
            Object [] date=liste.getListe()[i].getDate();
            Personnel p=liste.getListe()[i].getP();
             int   mat=new AcceeBase().getmatriculeParCodeMatricule(codeMatr[i]);
            Pointage poitage=new Pointage();
            for(int j=0;j<heure.length;j++)
            {
               // JOptionPane.showMessageDialog(null,"legth:"+heure.length);
                poitage.setDatepointage(date[j].toString());
                poitage.setHeurepointage(heure[j].toString());
                poitage.setMatricule(""+mat);
                poitage.setType("Multiple");
                
                new InsertPointages().insertionPointage(poitage);
            }
        }
        
    }
} 
