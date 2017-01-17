/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple.Fonction;

import Exception.GestionExecption;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class InnsertModel {
     public boolean insertModel(String lundi,String mardi,String mercredi,String jeudi,String vendredi,String samedi,String  dimanche,String nomModel, int idPers) throws SQLException, GestionExecption{
        Connection c = Connexion.getConnexion();
        if(lundi.compareToIgnoreCase("0")==0)
        {
            lundi="00h00";
        }
        if(mardi.compareToIgnoreCase("0")==0)
        {
            mardi="00h00";
        }
        if(mercredi.compareToIgnoreCase("0")==0)
        {
            mercredi="00h00";
        }
        if(jeudi.compareToIgnoreCase("0")==0)
        {
            jeudi="00h00";
        }
        if(vendredi.compareToIgnoreCase("0")==0)
        {
            vendredi="00h00";
        }
        if(samedi.compareToIgnoreCase("0")==0)
        {
            samedi="00h00";
        }
        if(dimanche.compareToIgnoreCase("0")==0)
        {
            dimanche="00h00";
        }
        String sql="insert into model(lundi,mardi,mercredi,jeudi,vendredi,samedi,dimanche,nommodel,idemploye)values('"+lundi+"','"+mardi+"','"+mercredi+"','"+jeudi+"','"+vendredi+"','"+samedi+"','"+dimanche+"','"+nomModel+"',"+idPers+")";
        Statement s = c.createStatement();
        s.executeUpdate(sql);
        c.close();
        return false;
    }
}
