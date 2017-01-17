<%-- 
    Document   : debauche
    Created on : 15 déc. 2016, 14:34:27
    Author     : User
--%>

<%@page import="connexion.AcceeBase"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Insertion.insertDebauce"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
<div class="container">
  <h2>Debaucher employé</h2>
  <form class="form-inline" action="ValidatioFinal.jsp">
            
            <div class="form-group">
                <label for="mont"> Matricule Employe:</label><br>
                <input type="text" name="matricule" class="form-control" id="pwd" placeholder="Matricule">
            </div><br><br>
            <div class="form-group">
                <label for="mont">Daty de saisie:</label><br>
                <input type="text" name="daty" class="form-control" id="pwd" placeholder="Date de saisie">
           </div><br><br>
            <div class="form-group">
                <label for="mont">Daty d'application:</label><br>
                <input type="text" name="datyapp" class="form-control" id="pwd" placeholder="Date d'application">
           </div><br><br>
            <div class="form-group">
                <label for="mont"> Motif:</label><br>
                <input type="text" name="motif" class="form-control" id="pwd" placeholder="Motif">
           </div><br><br>
            <div class="form-group">
                <label for="mont">Remarque:</label><br>
                <input type="text" name="rearq" class="form-control" id="pwd" placeholder="Remarque">
           </div><br><br>
           
            <button type="submit" class="btn btn-default">Ok</button>
  </form>
</div>
      
    </body>
    
    <%
      if(request.getParameter("matricule")!=null&& request.getParameter("datyapp")!=null)
        {
            try
            {
                
                String dateApp=request.getParameter("datyapp");
                String rem=request.getParameter("motif");
                String mot=request.getParameter("rearq");
                 
                
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                String daty1=(String) request.getParameter("daty");
                java.util.Date dateAv = sdf1.parse(daty1);
                java.sql.Date dateAvcm=new java.sql.Date(dateAv.getTime());
                
              
              
                java.util.Date dateapp = sdf1.parse(dateApp);
                java.sql.Date dateApplication=new java.sql.Date(dateapp.getTime());
                int matricule= new AcceeBase().getmatriculeParCodeMatricule(request.getParameter("matricule"));
                
                String []split=dateApp.split("/");
                int jour=Integer.parseInt(split[0]);
                int moi=Integer.parseInt(split[1]);
                int annee=Integer.parseInt(split[2]);
                new insertDebauce().insertDebauche(matricule, dateAvcm, jour,moi,annee,dateApplication,rem,mot);
            }
            catch(Exception ex)
            {
                out.print(ex);
            }

        }%>
</html>
