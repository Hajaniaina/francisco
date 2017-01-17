/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple.Fonction;

import Exception.GestionExecption;
import Selection.GetAllEmploye;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ComparaisonEMpoye {
    public String nomNouv;

    public ComparaisonEMpoye(String nomNouv) {
        this.nomNouv = nomNouv;
    }

    public ComparaisonEMpoye() {
    }

    
    public String getNomNouv() {
        return nomNouv;
    }

    public void setNomNouv(String nomNouv) {
        this.nomNouv = nomNouv;
    }
    
    public void compareEmp(String []listeNom) throws GestionExecption
    {
        GetAllEmploye getAllEmp =new GetAllEmploye();
        Object[][]all=getAllEmp.getAllAmploye();
        for(int i=0;i<all.length;i++)
        {
            if(all[i][0].toString().compareToIgnoreCase(listeNom[i])!=0)
            {
                nomNouv=listeNom[i];
                throw new GestionExecption("Nouvel employé detecté");
            } 
        }
        //return false;
    }
}
