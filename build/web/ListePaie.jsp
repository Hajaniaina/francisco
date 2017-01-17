<%-- 
    Document   : ListePaie
    Created on : 10 déc. 2016, 00:16:43
    Author     : User
--%>

<%@page import="connexion.AcceeBaseListePaie"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="mapping.ListePaie"%>
<%@page import="Fonction.FonctionListePaie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="PaieAsets/css/style.css">
        <title>Liste employes</title>
    </head>
    <body>
  <body>
      <form method="" action="ListePaie.jsp">
            <input type="text"  name="moi" placeholder="Moi">
            <input type="text"  name="annee" placeholder="Annee">
             
            <input type="submit"  value="ok">
      </form>
 <div id="wrapper">
  <h1>Listes des employés</h1>
  <%
       FonctionListePaie listeP=new FonctionListePaie();
       ListePaie lp=new ListePaie();
       String annee=(String)request.getParameter("annee");
       String moi=(String)request.getParameter("moi");
      
       lp.setAnnee(annee);
       lp.setMoi(moi);
       ListePaie[]listEmpPaie=listeP.getListePaieDesEmploye(lp.getMoin(), lp.getAnnee());
  %>
  <table id="keywords" cellspacing="0" cellpadding="0">
    <thead>
      
      <tr>
        <th><span>Nom</span></th>
        <th><span>Poste</span></th>
        <th><span>Salaire</span></th>
        <th><span>Gains</span></th>
        <th><span>Retenues</span></th>
	<th><span>Reste</span></th>
	<th><span>Moi</span></th>
	<th><span>Année</span></th>
        <th><span>Debauche</span></th>
        <th><span>edit</span></th>
      </tr>
     
    </thead>
    <tbody>
     <%for(int i=0;i<listEmpPaie.length;i++){%>
      <tr>
        <td class="lalign"><%out.print(listEmpPaie[i].getNomPer());%></td>
        <td class="lalign"><%out.print(listEmpPaie[i].getPoste());%></td>
        <td><%out.print(listEmpPaie[i].getSalairedebase());%></td>
        <td><%out.print(listEmpPaie[i].getSommeGains());%></td>
        <td><%out.print(listEmpPaie[i].getSommeRetenues());%></td>
        <td><%out.print(listEmpPaie[i].getResteApayer());%></td>
        <td><%out.print(listEmpPaie[i].getMoin());%></td>
         <td><%out.print(listEmpPaie[i].getAnnee());%></td>
         <td><a href="debauche.jsp?matricule=<%out.print(listEmpPaie[i].getIdpaie());%>&moi=<%out.print(listEmpPaie[i].getMoin());%>&annee=<%out.print(listEmpPaie[i].getAnnee());%>">Debaucher</td>
         <td><a href="edition.jsp?matricule=<%out.print(listEmpPaie[i].getIdpaie());%>&moi=<%out.print(listEmpPaie[i].getMoin());%>&annee=<%out.print(listEmpPaie[i].getAnnee());%>">edition</td>

        
      </tr>
    <%}%>
    </tbody>
  </table>
 </div> 
</body>
   <script src='PaieAsets/js/jquery.min.js'></script>
<script src='PaieAsets/js/__jquery.tablesorter.min.js'></script>
    <script src="js/index.js"></script>

</body>
</html>
