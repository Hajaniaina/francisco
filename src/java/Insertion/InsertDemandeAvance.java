/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insertion;

import Exception.GestionExecption;
import Fonction.DemandeAvance;
import Selection.SelectInPersonnel;
import connexion.AcceeBase;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author User
 */
public class InsertDemandeAvance {
     public void  insertDemnadeDavance(int matricule, int montant,int moi, int annee,Date saisie,Date Remboursement, int etat,int nombre,int numero) throws SQLException {
        Connection c = Connexion.getConnexion();
       
        PreparedStatement ps = c.prepareStatement("insert into avance (idpers,montant,moi,annee,datesaisie,daterembourse,etatsdejavalides,nombre,numero)values(?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,matricule);
            ps.setInt(2, montant);
            ps.setInt(3, moi);
            ps.setInt(4, annee);
            ps.setDate(5, saisie);
            ps.setDate(6, Remboursement);
            ps.setInt(7, etat);
            ps.setInt(8, nombre);
            ps.setInt(9, numero+1);
            ps.executeUpdate();
            c.close();
    }
   //bouclage d'insert//
     public void boucleIsertDemande(String codeMatricule,String PartitionDateMontant,String datesaisie,int montantTotal,int nombre) throws ParseException, SQLException,GestionExecption
     {
                 //convertir le string en date
         
                  int numero=0;
                  Connection c = Connexion.getConnexion();
                    try{
                       int matricule= new AcceeBase().getmatriculeParCodeMatricule(codeMatricule);
                         String req = "select numero  from avance where idpers= "+matricule+"";
                        ResultSet rs = c.createStatement().executeQuery(req);

                    while(rs.next()){
                        numero = rs.getInt(1);
                    }

                    }catch(Exception ex)
                    {

                    }
                 SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                 java.util.Date date = sdf1.parse(datesaisie);
                 java.sql.Date dateSais=new java.sql.Date(date.getTime());//
                 //Matricule
                 String[][]listeDateEtMontant=new DemandeAvance().SplitDouble(PartitionDateMontant, ";", ":");
                 int matricule= new AcceeBase().getmatriculeParCodeMatricule(codeMatricule);
                 double salairedebase=new SelectInPersonnel().getSalaire(matricule);
                 int somme=0;
                 for(int i=0;i<listeDateEtMontant.length;i++)
                 {
                     somme+=Integer.parseInt(listeDateEtMontant[i][1]);
                 }
                 if(somme!=montantTotal)
                 {
                     new GestionExecption("Le montant total est la partition doiventt etre egaux");
                 }
                
                 for(int i=0;i<listeDateEtMontant.length;i++)
                 {
                     //montant
                     double tiereSalaire=new DemandeAvance().calculTierSalaire(salairedebase);
                     int montant=Integer.parseInt(listeDateEtMontant[i][1]);
                     if(montant>tiereSalaire)
                     {
                         new GestionExecption("Le remboursement par moi ne doit pas depaser le 1/3 de votre salaire de base");
                     }
                     String[]moiAnnee=listeDateEtMontant[i][0].split("/");
                     int moi=Integer.parseInt(moiAnnee[1]);
                     int annee=Integer.parseInt(moiAnnee[2]);
                     String dateRemb=listeDateEtMontant[i][0];
                     
                     java.util.Date dateRembourse=sdf1.parse(dateRemb);
                     java.sql.Date dRemb=new java.sql.Date(dateRembourse.getTime());
                     new InsertDemandeAvance().insertDemnadeDavance(matricule, montant, moi, annee, dateSais, dRemb, 1,nombre,numero);  
                 }
                 c.close();
      }
}
