<%-- 
    Document   : index
    Created on : 17 nov. 2016, 08:59:10
    Author     : Bae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta content="text/html; charset=UTF-8" http-equiv="content-type">
    <title></title>
  </head>
  <body> <br>
    <br>
    <h1 style="text-align: center;">ACCUEIL - GESTION RESSOURCES HUMAINES</h1><br>
    <br>
    <br>
    <div style="text-align: center;">
      <a href="jours_feries.jsp" target="_blank">
          <input type="button" name="jours_feriers" value="GESTIONS DES JOURS FERIES" style="width: 250px; height: 50px;">
      </a>
    </div><br>
    <div style="text-align: center;">
        <a href="pointage.jsp" target="_blank">
            <input type="button" name="pointage" value="GESTION POINTAGES" style="width: 250px; height: 50px;">
        </a>
    </div><br>
    <div style="text-align: center;">
        <a href="ListePaie.jsp" target="_blank">
        <input type="button" name="paie" value="BULETTIN DE PAIE" style="width: 250px; height: 50px;">
        </a>
    </div><br>
    <div style="text-align: center;">
        <a href='Avance/demandeAvance.jsp'>
        <input type="button" name="jours_feriers" value="DEMANDE D'AVANCE" style="width: 250px; height: 50px;">
        </a>
    </div><br>
    <div style="text-align: center;">
        <input type="button" name="jours_feriers" value="GRAPHE" style="width: 250px; height: 50px;">
    </div><br>
  </body>
</html>
