<%-- 
    Document   : enregistrement_paie
    Created on : 17 nov. 2016, 14:34:50
    Author     : Bae
--%>

<%@page import="java.sql.Date"%>
<%@page import="metier.CalculPaie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            CalculPaie cp = new CalculPaie();
            int matr = Integer.parseInt(request.getParameter("employe_paie"));
            cp.calcul_paie(matr);
        
        %>
    </body>
</html>
