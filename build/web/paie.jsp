<%-- 
    Document   : paie
    Created on : 17 nov. 2016, 09:50:27
    Author     : Bae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=UTF-8" http-equiv="content-type">
        <title>Paie</title>
    </head>
    <body>
        <br><br><br><br><br>
        <div style="text-align: center">
            <h1>BULLETIN DE PAIE</h1>
            <form action="enregistrement_paie.jsp">
                
                <p>Employe : <input name="employe_paie" type="text"> </p>
                <p>Mois : &nbsp; &nbsp;&nbsp;&nbsp; <input name="datesaisie" type="date"></p>
                <p>Annee : &nbsp;&nbsp;&nbsp; <input name="annee_paie" type="text"></p>
                <input name="Valider" type="submit" value="Generer" style="width: 350px; height: 35px;">
            </form>
            
        </div>
        
    </body>
</html>
