<%-- 
    Document   : csv
    Created on : 13 janv. 2017, 10:22:03
    Author     : User
--%>

<%@page import="csv.InsertCsv"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mety</h1>
        <%
            try{
                String path="C:\\Users\\User\\Desktop\\emp.csv";
                new InsertCsv().insertCsvToBase(path);
            }
            catch(Exception ex)
            {
                 String site = new String("AffichagePointageMultiple.jsp");
                 response.setStatus(response.SC_MOVED_TEMPORARILY);
                 response.setHeader("Location", site); 
            }
        %>
    </body>
</html>
