/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple.Fonction;

import Fonction.DemandeAvance;

/**
 *
 * @author User
 */
public class Split {
    public String[] decoupe(String ligneEntree,String separateur)
	{
		String [] resp=ligneEntree.split(separateur);
		return resp;
	}

	public String[][] SplitDouble(String chaine, String sep1,String sep2)
	{

		String [] coupe=new Split().decoupe(chaine, sep1);
		
		String[][]resp=new String[coupe.length][];
	
		for(int i=0;i<coupe.length;i++)
		{
			resp[i]=new DemandeAvance().decoupe(coupe[i], sep2);	
                }
		return resp;
	}
    
}
