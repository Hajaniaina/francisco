/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

import connexion.AcceeBaseCnapsOstie;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class calculCnaps {
    
    public int calculcnaps(int salaire) throws SQLException
    {
        int cnaps=new AcceeBaseCnapsOstie().getOstieCnaps("cnaps");
        int ret=salaire* cnaps/100;
        return ret;
    }
    
}
