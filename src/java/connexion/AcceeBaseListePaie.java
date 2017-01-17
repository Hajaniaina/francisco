/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AcceeBaseListePaie {
    
     public int[][] getTousLesMontant(int moi,int annee)
    {
        int nombreEmp=new AcceeBase().nombreMAtricule(moi,annee);
        int i=0;
        int[][] nbr=new int[nombreEmp][2];
        try
        {
           
            Connection  c = Connexion.getConnexion();
            String req = "select matriculeemploye,montant from salairedebasefixe  where matriculeemploye not in(select idemp from debauche where dateapplication<'01-"+moi+"-"+annee+"')  order by matriculeemploye";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               nbr[i][0]=rs.getInt(1);
               nbr[i][1]=rs.getInt(2);
               i++;
            }
            c.close();
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Probleme de requette getTousLesMontant:"+ex.getMessage());
            ex.printStackTrace();

        }
        return nbr;
    }
     //get le montant deja payer
     public int[][] getListeDejaPaye(int moi,int annee)
     {
         int taille=0;int i=0;
         try
         {
            Connection  c = Connexion.getConnexion();
            String req = "select idpers,sum(montant) from avance  where moi="+moi+" and annee="+annee+"  and idpers not in(select idemp from debauche where dateapplication<'01-"+moi+"-"+annee+"') and etatsdejavalides=0 group by idpers";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               taille=rs.getRow();
              
            }
           c.close();
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null,"Probleme de requette getListeDejaPaye:"+ex.getMessage());
         }
         int resp[][]=new int[taille][2];
         try
         {
            Connection  c = Connexion.getConnexion();
            String req = "select idpers,sum(montant) from avance  where moi="+moi+" and annee="+annee+"  and  idpers not in(select idemp from debauche where dateapplication<'01-"+moi+"-"+annee+"') group by idpers";
            ResultSet rs = c.createStatement().executeQuery(req);

            while(rs.next()){
               resp[i][0]=rs.getInt(1);
               resp[i][1]=rs.getInt(2);
               i++;
            }
             c.close();
         }
         catch(Exception ex)
         {
              JOptionPane.showMessageDialog(null,"Probleme de requette getListeDejaPaye:"+ex.getMessage());
         }
         return resp;
     }
     
     //getAll from mouvement paie a partier de moi et annee
     public int[][] getListeDeMouvementPaie(int moi,int annee)
     {
         int taille=0,i=0;
         try
         {
                Connection  c = Connexion.getConnexion();
                String req = "select idpers,sum(gains),sum(retenues),moi,annee from mouvementlistepaie  where moi="+moi+" and annee="+annee+" and idpers not in(select idemp from debauche where dateapplication<'01-"+moi+"-"+annee+"') group by idpers,moi,annee";
                ResultSet rs = c.createStatement().executeQuery(req);

                while(rs.next()){
                   taille=rs.getRow();

                }
               c.close();
         }
         catch(Exception ex)
         {
              JOptionPane.showMessageDialog(null,"Probleme de requette getListeDeMouvementPaie:"+ex.getMessage());
         }
         int[][] resultat=new int[taille][5];
         try
         {
            Connection  c = Connexion.getConnexion();
                String req = "select idpers,sum(gains),sum(retenues),moi,annee from mouvementlistepaie  where moi="+moi+" and annee="+annee+"  and idpers not in(select idemp from debauche where dateapplication<'01-"+moi+"-"+annee+"') group by idpers,moi,annee";
            ResultSet rs = c.createStatement().executeQuery(req);
           
            while(rs.next()){
               resultat[i][0]=rs.getInt(1);
               resultat[i][1]=rs.getInt(2);
               resultat[i][2]=rs.getInt(3);
               resultat[i][3]=rs.getInt(4);
               resultat[i][4]=rs.getInt(5);
               i++;
            }
           c.close();
         }catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null,"Probleme de requette getListeDeMouvementPaie:"+ex.getMessage());
         }
         
         return resultat;
     }
     //insert into mouvsalaire//
     public void inesertSalaireDebaseElmntFixe(int matricue)
     {
          int salaire =new AcceeBseFichDePaie().getalaireDeBaseUnEmployer(matricue); 
     }
     
     //get all CodeMAt
     
     public String[]getAllCodeMat(int moi, int annee)
     {
         String[]resp=new String[new AcceeBase().nombreMAtricule(moi,annee)];
         int i=0;
          try
         {
            Connection  c = Connexion.getConnexion();
            String req = "select codematricule from personnel where matricule not in(select idemp from debauche where dateapplication<'01-"+moi+"-"+annee+"')";
            ResultSet rs = c.createStatement().executeQuery(req);
           
            while(rs.next()){
               resp[i]=rs.getString(1);
               i++;
            }
           c.close();
         }catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null,"Probleme de requette inesertSalaireDebaseElmntFixe:"+ex.getMessage());
         }
         
         return resp;
         
     }
     //public void 
}
