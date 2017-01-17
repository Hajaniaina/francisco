<%-- 
    Document   : TraitementNouvelEmploye
    Created on : 10 janv. 2017, 23:51:31
    Author     : User
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Insertion.InsertEmploiDuTemps"%>
<%@page import="java.sql.Time"%>
<%@page import="PointageMultiple.Fonction.Split"%>
<%@page import="connexion.AcceeBase"%>
<%@page import="Insertion.InsertSalaire"%>
<%@page import="Insertion.InsertPersonnel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DateTime.DateHeure"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouvel employé</title>
    </head>
    <body>
        <h1>Bien fait</h1>
        
        <%
            String nom=request.getParameter("nom");
            String typeTravail=request.getParameter("typeTravail");
            String poste=request.getParameter("poste");
            String sexe=request.getParameter("sexe");
            String matricule=request.getParameter("matricule");
            String dateEmbauche=request.getParameter("dateEmbauche");
            String salaire=request.getParameter("salaire");
            String partitionEmp=request.getParameter("partitionEmp");
            
            //Emploi du teps
            String [][]tabEmploiDuTemps=new Split().SplitDouble(partitionEmp, ";", "h");
            Time Ematin=new Time(Integer.parseInt(tabEmploiDuTemps[0][0]),Integer.parseInt(tabEmploiDuTemps[0][1]),0);
            Time Smidi=new Time(Integer.parseInt(tabEmploiDuTemps[1][0]),Integer.parseInt(tabEmploiDuTemps[1][1]),0);
            Time Emidi=new Time(Integer.parseInt(tabEmploiDuTemps[2][0]),Integer.parseInt(tabEmploiDuTemps[2][1]),0);
            Time Ssoir=new Time(Integer.parseInt(tabEmploiDuTemps[3][0]),Integer.parseInt(tabEmploiDuTemps[3][1]),0);
            //date actuelle
            String actuel=new DateHeure().date();

             SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
             java.sql.Date atuelDate;
             java.sql.Date embauche;
             
             java.util.Date date = sdf1.parse("12/01/2017");
             java.util.Date date2 = sdf1.parse(dateEmbauche);
             
             atuelDate=new java.sql.Date(date.getTime());
             embauche=new java.sql.Date(date2.getTime());
             
             
             new InsertPersonnel().insertSalaire(nom, poste, typeTravail, sexe, matricule, embauche);
             int   mat=new AcceeBase().getmatriculeParCodeMatricule(matricule);
             JOptionPane.showMessageDialog(null, "ilay matricule:"+mat);
             new InsertEmploiDuTemps().insertEmploiDuTemps(Ematin, Smidi, Emidi, Ssoir, mat,poste);
             new InsertSalaire().insertSalaire(atuelDate, mat, Integer.parseInt(salaire), "SALAIRE", atuelDate);
             
            //Redirection//
                String site = new String("AffichagePointageMultiple.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
        %>
    </body>
</html>
