<%-- 
    Document   : EnregistrementJF
    Created on : 17 nov. 2016, 10:46:05
    Author     : Bae
--%>

<%@page import="metier.InsertionJF"%>
<%@page import="mapping.JourFeries"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            JourFeries jf = new JourFeries();
            InsertionJF i =new InsertionJF();
            jf.setDateinsertion(request.getParameter("ajout_jf"));
            jf.setHeuredebut(request.getParameter("hdebut"));
            jf.setHeurefin(request.getParameter("hfin"));
            jf.setMotif(request.getParameter("motif"));
            i.insertJourFeries(jf);
            response.sendRedirect("jours_feries.jsp");
        %>
    </body>
</html>
