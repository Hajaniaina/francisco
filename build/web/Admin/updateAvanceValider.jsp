<%-- 
    Document   : updateAvanceValiderv
    Created on : 19 déc. 2016, 15:10:00
    Author     : User
--%>

<%@page import="update.UpdateAvance"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ValidatioUpdate</title>
    </head>
    <body>
        <h1>Bien accepté</h1>
        <%
            int matricule=Integer.parseInt(request.getParameter("matricule"));
            int numero=Integer.parseInt(request.getParameter("numero"));
            new UpdateAvance().updateAvace(matricule, numero);
        %>
    </body>
</html>
