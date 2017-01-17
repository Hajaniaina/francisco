<%-- 
    Document   : EnregistrementPointage
    Created on : 17 nov. 2016, 11:17:38
    Author     : Bae
--%>

<%@page import="DateTime.DateHeure"%>
<%@page import="connexion.AcceeBase"%>
<%@page import="Insertion.InsertPointages"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="mapping.Personnel"%>
<%@page import="metier.TestEntreeEtSortieEmploye"%>

<%@page import="mapping.Pointage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enregistrement pointage jsp</title>
    </head>
    <body>
        <%
            try
            {
                Pointage p = new Pointage();
                Personnel pers=new Personnel();
                InsertPointages ip = new InsertPointages();
                int matricul=new AcceeBase().getmatriculeParCodeMatricule(request.getParameter("saisiMatricule"));
                 p.setMatricule(""+matricul);
               
                 if((String)request.getParameter("datepointage")!=null )  
                 {
                      
                      p.setDatepointage(request.getParameter("datepointage"));
                      p.setHeurepointage(request.getParameter("heure"));
                 }
                 
                 else
                 {
                     //JOptionPane.showMessageDialog(null,"tasar"+new DateHeure().date());
                      p.setHeurepointage(new DateHeure().heure());
                      p.setDatepointage(new DateHeure().date());                 
                 }
                p.setType("simple");
                ip.insertionPointage(p);
                String site = new String("pointage.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site); 
            }
            
            catch(Exception ex)
            {
                String rep=ex.getMessage();
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,rep);
                String site = new String("pointage.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site); 
               

            }
            
            
            
            
            
//            response.sendRedirect("pointage.jsp");
        %>
        
    </body>
</html>
