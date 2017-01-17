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
public class ParseDate {
    public String parse_String_to_Date(String str_to_date){
        str_to_date=str_to_date.replace('/','-');
        str_to_date=str_to_date.replace('.','-');
        str_to_date=str_to_date.replace(' ','-');
        str_to_date=str_to_date.replace(',','-');
        str_to_date=str_to_date.replace(';','-');
        str_to_date=str_to_date.replace(':','-');
        if(str_to_date.charAt(2)=='-'){
            str_to_date="20"+str_to_date;
        }
        return str_to_date;
    }
}
