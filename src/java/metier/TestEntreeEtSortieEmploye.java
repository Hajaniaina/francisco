/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Selection.GetEmploiDuTemp;
import java.sql.Time;
import mapping.EmploiDuTemps;
import mapping.Pointage;

/**
 *
 * @author Bae
 */
public class TestEntreeEtSortieEmploye {
    public void test_horaire(String poste, Pointage p) throws Exception{
        GetEmploiDuTemp ge = new GetEmploiDuTemp();
        EmploiDuTemps edt = new EmploiDuTemps();
        Time t_entree_max = new Time(edt.getHmaxentree().getTime());
        Time t_sortie_max = new Time(edt.getHmaxsortie().getTime());
        String getPoste = p.getPoste();  
        String getEtat = p.getEtat();
        Time t_pointage = new Time(p.getHeurepointage().getTime());
        ///bureau
        if(t_pointage.after(t_entree_max) && getPoste.compareToIgnoreCase("bureau")==0 && getEtat.compareToIgnoreCase("entree")==0 ){
            throw new Exception("Les personnels de bureau doivent entree avant 16h:00min");
        }
        if(t_pointage.after(t_entree_max) && getPoste.compareToIgnoreCase("nuit")==0 && getEtat.compareToIgnoreCase("entree")==0){
            throw new Exception("Les personnels de nuit doivent entree avant 20h:00min");
        }
    }
    
}
