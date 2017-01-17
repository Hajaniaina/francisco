/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.sql.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class PremierJourDeLaSemaineException {
    
    public void testePremierJourDeLaSemaine(Date premerDateSEmaine) throws GestionExecption
    {
        boolean testeLundi =new PremierJourDeLaSemaineException().connaitreLundi(premerDateSEmaine);
       if(!testeLundi)
       {
            throw new GestionExecption("La date n'est pas le premier jour de la semaine");
       }
    }
    
    public boolean connaitreLundi(Date d)
    {
        GregorianCalendar calendar =new GregorianCalendar();
        calendar.setTime(d);
	int today =calendar.get(calendar.DAY_OF_WEEK);
        //JOptionPane.showMessageDialog(null, today);
	switch (today) {
	case 7:
		return true;
	default:
		return false;
	}
    }
}
