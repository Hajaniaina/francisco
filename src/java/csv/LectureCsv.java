/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import PointageMultiple.SemaineUnEmploye;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import mapping.Personnel;

/**
 *
 * @author User
 */
public class LectureCsv {
    
    String[]listeMatr;
    public SemaineUnEmploye[]DateHeureEmpInCsv(String chemin)
    {
       Object[][]ret=new Object[3][];
       String path="C:\\Users\\User\\Desktop\\csv.csv";
       String ligne="";
       Object[][]resp=new Object[2][];
       Personnel pers=new Personnel();
       int k=0,taille=0;
       
       SemaineUnEmploye[]semEmp=new SemaineUnEmploye[0];
         try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedReader brLeght = new BufferedReader(new FileReader(path));
            while((ligne =brLeght.readLine())!=null)
            {
                taille=taille+1;
            }
            listeMatr=new String[taille];
            String[]listeMatricule=new String[taille];
            semEmp=new SemaineUnEmploye[taille];
            
            while((ligne =br.readLine())!=null){
                
                String[] empDateHeure = ligne.split("=");
                String[] dateHeure = empDateHeure[1].split(";"); 
                
                //=====================//
                Object[]date = new Object[dateHeure.length];
                Object[]ora=new Object[dateHeure.length];
                String[] heuresEtHeure=new String[dateHeure.length];
                for(int i=0;i<dateHeure.length;i++){
                    heuresEtHeure = dateHeure[i].split(",");
                    date[i]=heuresEtHeure[0];
                    ora[i]=heuresEtHeure[1];
                }
              
              listeMatr[k]=empDateHeure[0];
              pers.setCodeMatricule(listeMatricule[k]);
              SemaineUnEmploye listePointSemaine=new SemaineUnEmploye(date,ora,pers);  
              semEmp[k]=listePointSemaine;
              k++;
             
            }
        }catch(Exception exc){
            exc.printStackTrace();
        }
         return semEmp;
    }

    public String[] getListeMatr() {
        return listeMatr;
    }

    public void setListeMatr(String[] listeMatr) {
        this.listeMatr = listeMatr;
    }
    
    
    }


