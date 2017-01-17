<%-- 
    Document   : insertBaseAvance
    Created on : 17 déc. 2016, 17:08:32
    Author     : User
--%>

<%@page import="Insertion.InsertDemandeAvance"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
    </head>
    <body>
        <h1>Bien inserée</h1>
        <%
            String daty=request.getParameter("datesaisie");
            String partition=request.getParameter("partition");
            String matricule=request.getParameter("saisiMatricule");
            int montTotal=Integer.parseInt(request.getParameter("montant"));
            int nombre=Integer.parseInt(request.getParameter("nmb"));
            new InsertDemandeAvance().boucleIsertDemande(matricule, partition, daty,montTotal,nombre);
        %>
    </body>
</html>
