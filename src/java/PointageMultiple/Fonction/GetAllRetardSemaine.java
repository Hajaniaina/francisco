/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple.Fonction;

import Selection.GetAllEmploye;
import Selection.SelectRetardUnEmpSemaine;
import java.sql.Date;

/**
 *
 * @author User
 */
public class GetAllRetardSemaine {
    
    public Object[]listeRetard(int []listeMatricule,Date d)
    {
         GetAllEmploye getAllEmp =new GetAllEmploye();
         Object[][]all=getAllEmp.getAllAmploye();
         Object[]ret=new Object[all.length];
         
         for(int i=0;i<all.length;i++)
         {
             ret[i]=new GetAllRetardSemaine().getRetardUnEmpSemaine(d,listeMatricule[i]);
         }
         
         return ret;
    }
    
    public int  getRetardUnEmpSemaine(Date d,int matricule)
    {
        int ret=0;
        ret=new SelectRetardUnEmpSemaine().getRetUnEmpSem(matricule,d);
        return ret;
    }
}
