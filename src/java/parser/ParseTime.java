/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Bae
 */
public class ParseTime {
    public static String parse_String_to_Time(String str_to_time){
        str_to_time=str_to_time.replace('h',':');
        str_to_time=str_to_time.replace('H',':');
        str_to_time=str_to_time.replace('m',':');
        str_to_time=str_to_time.replace('M',':');
        str_to_time=str_to_time.replace('s',' ');
        str_to_time=str_to_time.replace('S',' ');
        str_to_time=str_to_time.replace('-',':');
        str_to_time=str_to_time.replace('.',':');
        str_to_time=str_to_time.replace(' ',':');
        str_to_time=str_to_time.replace('/',':');
        String ante_meridian=str_to_time.substring(str_to_time.length()-2);
        //comparaison si la lettre apres l heure est p: ou a:
        if(ante_meridian.compareToIgnoreCase("p:")==0 || ante_meridian.compareToIgnoreCase("a:")==0){
            String h=String.valueOf(str_to_time.charAt(0));
            if(str_to_time.charAt(1)!=':'){
                h=str_to_time.substring(0,1);
            }
            if(ante_meridian.compareToIgnoreCase("p:")==0){
                Integer h_to_integer=new Integer(h);
                int i=h_to_integer; 
                i=i+12;
                if(i==24){
                    i=0;
                }else if(i>24){
                    i=i-12;
                }
                h_to_integer=new Integer(i);
                h=h_to_integer.toString();
                if(str_to_time.charAt(1)!=':'){
                    str_to_time=h+str_to_time.substring(2);
                }else{
                    str_to_time=h+str_to_time.substring(1);
                }
            }
            str_to_time=str_to_time.substring(0,str_to_time.length()-2);
        }
        if(str_to_time.charAt(str_to_time.length()-1)==':'){
            str_to_time=str_to_time.substring(0,str_to_time.length()-1);
        }
        if(str_to_time.length()<=5){
            str_to_time=str_to_time+":00";
        }
        return str_to_time;
    }
}
