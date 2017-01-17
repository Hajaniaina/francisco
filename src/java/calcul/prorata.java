/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

import connexion.AcceeBaseCnapsOstie;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class prorata {
    public int calculProrata(int salaire,int nombrejour) throws SQLException
    {
        int nombreJour=30;
        
        int ret=(salaire/30)*nombrejour;
        return ret;
    }
}
