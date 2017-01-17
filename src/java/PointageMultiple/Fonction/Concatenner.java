/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple.Fonction;

/**
 *
 * @author User
 */
public class Concatenner {
   public String concatenner(String []liste)
   {
       String lis=liste[0].concat(";");
       for(int i=1;i<liste.length;i++)
       {
           lis=lis.concat(liste[i]).concat(";");
       }
       return lis;
   }
}
