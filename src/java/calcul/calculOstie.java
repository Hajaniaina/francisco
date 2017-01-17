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
public class calculOstie {
    
    public int calculOstie(int salaire) throws SQLException
    {
        int ostie=new AcceeBaseCnapsOstie().getOstieCnaps("ostie");
        int ret=salaire* ostie/100;
        return ret;
    }
    
}
