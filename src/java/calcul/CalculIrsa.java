/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bae
 */
public class CalculIrsa {
    public double calculIrsa(int salaire) throws SQLException{
        double irsa = 0;
        int cnaps=new calculCnaps().calculcnaps(salaire);
        int ostie=new calculOstie().calculOstie(salaire);
        int sommeCnapOstie=cnaps+ostie;
        if(salaire-sommeCnapOstie<= 250000){
            irsa = 2000;
        }else if(salaire-sommeCnapOstie > 250000){
            irsa = ((salaire-sommeCnapOstie - 250000)*0.20);
        }
        return irsa;
    }
}
