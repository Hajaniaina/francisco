/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonction;

import mapping.Personnel;
import update.UpdateAvance;

/**
 *
 * @author User
 */
public class DemandeAvance {
    
    public String concatenerDeuString(String[]liste, int[]nombr)
    {
        String ret=liste[0].concat(":").concat(""+nombr[0]).concat(";");
        for(int i=1;i<liste.length;i++)
        {
            ret=ret.concat(liste[i]).concat(":").concat(""+nombr[i]).concat(";");
        }
        return ret;
    }
    //SPLIT
   //fonction split()
	public String[] decoupe(String ligneEntree,String separateur)
	{
		String [] resp=ligneEntree.split(separateur);
		return resp;
	}

	public String[][] SplitDouble(String chaine, String sep1,String sep2)
	{

		String [] coupe=new DemandeAvance().decoupe(chaine, sep1);
		
		String[][]resp=new String[coupe.length][];
	
		for(int i=0;i<coupe.length;i++)
		{
			resp[i]=new DemandeAvance().decoupe(coupe[i], sep2);	
                }
		return resp;
	}
        //calcul 1/3
        public double calculTierSalaire(double salaire)
        {
            return salaire/3;
        }
        
        //Validation de demande d'avance//
        
        
}
