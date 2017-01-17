/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple.Fonction;

import Exception.GestionExecption;
import Exception.PremierJourDeLaSemaineException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ListeDateHeureNonNull {
    public Object[][]lsteDateHeureNonNull(Object[]heure,Date semaine) throws ParseException, GestionExecption
    {
        new PremierJourDeLaSemaineException().testePremierJourDeLaSemaine(semaine);
        int taill=0;
        for(int i=0;i<heure.length;i++)
        {
            if(heure[i].toString().compareToIgnoreCase("")!=0 && heure[i].toString().compareToIgnoreCase("0")!=0 && heure[i].toString().compareToIgnoreCase("00h00")!=0 )
            {
                taill=taill+1;
            }
        }
       // JOptionPane.showMessageDialog(null,"Ataov serieu"+taill);
        Object[][]resp=new Object[2][];
        Object[]date = new Object[taill];
        Object[]ora=new Object[taill];
        int k=0;
        for(int i=0;i<7;i++)
        {
             String myDate = ListeDateHeureNonNull.addDays(semaine, i);
             //String h=new String(heure[i].toString());
             if(heure[i].toString().compareToIgnoreCase("")!=0 && heure[i].toString().compareToIgnoreCase("0")!=0 && heure[i].toString().compareToIgnoreCase("00h00")!=0 )
             {
                 date[k]=myDate;
                 ora[k]=heure[i];
                 k++;
             }
             
        }
         resp[0]=date;
         resp[1]=ora;
        return resp;
    }
    
     public static  String addDays(Date date, int days)
    {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        //JOptionPane.showMessageDialog(null,"Ataov serieu"+simpleDateFormat1.format( cal.getTime()));

        return  simpleDateFormat1.format( cal.getTime());
    }
     
     public  String addDaysRet(Date date, int days)
    {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        //JOptionPane.showMessageDialog(null,"Ataov serieu"+simpleDateFormat1.format( cal.getTime()));

        return  simpleDateFormat1.format( cal.getTime());
    }
}
