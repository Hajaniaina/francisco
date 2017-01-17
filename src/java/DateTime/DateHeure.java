/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateTime;

import Exception.GestionExecption;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author itu
 */
public class DateHeure {
    
    //fonction pour concaterner date //
    
    public String concatenerDateEtHeure(String a, String b, String c, String sep)
    {
        return a.concat(sep).concat(b).concat(sep).concat(c);
    }
     public String concatenerHeur(String a, String b,String sep)
    {
        return a.concat(sep).concat(b);
    }
    //fonction get date aujourd'huit//
    public String date()
    {
        
        Calendar cal = Calendar.getInstance( );
        int annee=cal.get(Calendar.YEAR);
        int moi=cal.get(Calendar.MONTH)+1;
        int jour=cal.get(Calendar.DAY_OF_MONTH);
        String a=new String(""+annee);
        String b=new String(""+moi);
        String c=new String(""+jour);
     
         
        return new DateHeure().concatenerDateEtHeure(a, b, c, ":");  
    }
    //fonction get heure aujourd'hui
    
    public String heure()
    {
       
        Calendar cal = Calendar.getInstance( );
        int h=cal.get(Calendar.HOUR_OF_DAY);
        int m=cal.get(Calendar.MINUTE);
        int s=cal.get(Calendar.SECOND);
        String a=""+h;
        String b=""+m;
        String c=""+s;
       // JOptionPane.showMessageDialog(null,"Meme ve"+new DateHeure().concatenerDateEtHeure(a,b,"",":"));
        return new DateHeure().concatenerHeur(a,b,":");
    }
    
    //heure contient PM ou AM ou pas de minute
    public String transformeHeureAvecPmEtAm(String heure) throws ParseException
    {
        String ret=null;
        SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm");
        ret=date24Format.format(date12Format.parse(heure));
        return ret;
    }
    
    //get moi et annee a partir d'une date donnee
    
    public int getMoi(Date date) throws GestionExecption
    {
        int moi=0 ;
        try
        {
            GregorianCalendar calendar =new GregorianCalendar();
            calendar.setTime(date);
            moi=calendar.get(Calendar.MONTH);
        }
        catch(Exception ex)
        {
          throw new GestionExecption("Convertion impossible de date");
        }
        return moi+1;
    }
    
    public int getAnnee(Date date) throws GestionExecption
    {
        int annee =0;
        try
        {
            GregorianCalendar calendar =new GregorianCalendar();
            calendar.setTime(date);
            annee=calendar.get(Calendar.YEAR);
        }
        catch(Exception ex)
        {
            throw new GestionExecption("Convertion impossible de date");
        }
        return annee;
    }
    public int getJour(Date date) throws GestionExecption
    {
        int day =0;
        try
        {
            GregorianCalendar calendar =new GregorianCalendar();
            calendar.setTime(date);
            day=calendar.get(Calendar.DAY_OF_WEEK);
        }
        catch(Exception ex)
        {
            throw new GestionExecption("Convertion impossible de date");
        }
        return day+3;
    }
}
