<%-- 
    Document   : ListePaie
    Created on : 10 déc. 2016, 00:16:43
    Author     : User
--%>

<%@page import="Exception.GestionExecption"%>
<%@page import="connexion.AcceeBaseListePaie"%>
<%@page import="connexion.AcceeBase"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="mapping.ListePaie"%>
<%@page import="Fonction.FonctionListePaie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="PaieAsets/css/style.css">
        <title>Edition de paie</title>
    </head>
    <body>
  <%
       FonctionListePaie listeP=new FonctionListePaie();
       ListePaie lp=new ListePaie();
       String annee;
       String moi;
       int matricule=0;
       if(request.getParameter("emp")!=null && request.getParameter("anneess")!=null )
       {
          matricule= new AcceeBase().getmatriculeParCodeMatricule(request.getParameter("emp"));
          annee=(String)request.getParameter("anneess");
          moi=(String)request.getParameter("moiss");
          
          matricule=new FonctionListePaie().matricul(matricule, Integer.parseInt(moi), Integer.parseInt(annee))+1;
         

       }
       else 
       {
           matricule=Integer.parseInt(request.getParameter("matricule"));
           annee=(String)request.getParameter("annee");
           moi=(String)request.getParameter("moi");
       }
      
       lp.setAnnee(annee);
       lp.setMoi(moi);
       ListePaie[]listEmpPaie=listeP.getListePaieDesEmploye(lp.getMoin(), lp.getAnnee());
  %>
      <form method="" action="edition.jsp">
            <input type="text"  name="moiss" placeholder="Moi">
            <input type="text"  name="anneess" placeholder="Annee">
             
             <select name="emp">
                 <%  String []liset=new AcceeBaseListePaie().getAllCodeMat(lp.getMoin(),lp.getAnnee());
                     for(int i=0;i<liset.length;i++){%>
                              <option><% out.print(liset[i]); %></option>
                        <%}%>
             </select>
            <input type="submit"  value="ok">
      </form>
 <div id="wrapper">
  <h1>Edition de paie</h1>
  
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
        <th><span>Fiche</span></th>
        
      </tr>
     
    </thead>
    <tbody>
    
      <tr>
        <td class="lalign"><%out.print(listEmpPaie[matricule-1].getNomPer());%></td>
        <td class="lalign"><%out.print(listEmpPaie[matricule-1].getPoste());%></td>
        <td><%out.print(listEmpPaie[matricule-1].getSalairedebase());%></td>
        <td><%out.print(listEmpPaie[matricule-1].getSommeGains());%></td>
        <td><%out.print(listEmpPaie[matricule-1].getSommeRetenues());%></td>
        <td><%out.print(listEmpPaie[matricule-1].getResteApayer());%></td>
        <td><%out.print(listEmpPaie[matricule-1].getMoin());%></td>
         <td><%out.print(listEmpPaie[matricule-1].getAnnee());%></td>
         
         <td><a href="FichePaie.jsp?matricule=<%out.print(listEmpPaie[matricule-1].getIdpers());;%>&moi=<%out.print(listEmpPaie[matricule-1].getMoin());%>&annee=<%out.print(listEmpPaie[matricule-1].getAnnee());%>">Voir</td>
         
      </tr>
  
    </tbody>
  </table>
 </div> 
</body>
   <script src='PaieAsets/js/jquery.min.js'></script>
<script src='PaieAsets/js/__jquery.tablesorter.min.js'></script>
    <script src="js/index.js"></script>

</body>
</html>
