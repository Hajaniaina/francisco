<%-- 
    Document   : ListePaie
    Created on : 10 déc. 2016, 00:16:43
    Author     : User
--%>

<%@page import="Exception.GestionExecption"%>
<%@page import="mapping.FichePaie"%>
<%@page import="mapping.Personnel"%>
<%@page import="Fonction.FonctionFichePaie"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="mapping.ListePaie"%>
<%@page import="Fonction.FonctionListePaie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="PaieAsets/css/style.css">
        <title>Fiche de paie</title>
    </head>
    <body>
  <body>
      
 <div id="wrapper">
     <p><a href="ListePaie.jsp">Retour</a></p>
  <h1>Fiche de paie</h1>
  
  <%
      FichePaie uneFiche=new FichePaie();
      try
      {
            FonctionFichePaie fiche=new FonctionFichePaie();
             Personnel pers=new Personnel();
             String matricule=request.getParameter("matricule");
             String moi=request.getParameter("moi");
             String annee=request.getParameter("annee");
             pers.setMatricule(Integer.parseInt(matricule));
             int m=Integer.parseInt(moi);
             int ann=Integer.parseInt(annee);
             
             uneFiche=fiche.ficheDePaie(pers,m,ann);
      }catch(Exception ex)
      {
         new GestionExecption();
      }
            
  %>
  <div id='user-apropos'style='margin-left: 435px;'>
  <h2>NOM:   <% out.print(uneFiche.getPerso().getNom());%></h2>
  <h2>FONCTION:   <% out.print(uneFiche.getPerso().getPoste());%></h2>
  <h2>DATE D'EMBAUCHE:   <% out.print(uneFiche.getDateEnbauche());%></h2>
  </div>
  <table id="keywords" cellspacing="0" cellpadding="0">
    <thead>
      
      <tr>
        <th><span>Description</span></th>
        <th><span>Gains</span></th>
        <th><span>Retenues</span></th>
       
      </tr>
     
    </thead>
    <tbody>
       <%for(int i=0;i<uneFiche.getListeGain().length;i++ ){%>
      <tr>  
          <td class="lalign"><strong><%out.print(uneFiche.getListeGain()[i].getMotif());%></strong></td>
             <td><%out.print(uneFiche.getListeGain()[i].getMontant());%></td>
            <td><%out.print(0);%></td>
      </tr>
      <%}%>
      <%for(int i=0;i<uneFiche.getLsteRetenu().length;i++ ){%>
      <tr>   
             <td class="lalign"><strong><%out.print(uneFiche.getLsteRetenu()[i].getMotif());%></strong></td>
             <td><%out.print(0);%></td>
             <td><%out.print(uneFiche.getLsteRetenu()[i].getMontant());%></td>
      </tr>
      <%}%>
      <br><hr>
      <tr> 
             <td class="lalign"><h2><strong><%out.print("Somme:");%></h2></strong></td>
             <td><strong><%out.print(uneFiche.getSommeGai());%></strong></td>
             <td><strong><%out.print(uneFiche.getSommeRetenus());%></strong></td>
      </tr>
      
       <tr>   
             <td class="lalign"><h1><%out.print("NAP");%></h1></td>
             <td><%out.print("");%></td>
             <td><h2><%out.print(uneFiche.getNetApayer());%></h2></td>
      </tr>
      <tr>   
             <td class="lalign"><h1><%out.print("");%></h1></td>
             <td><%out.print("");%></td>
             <td><h2><a href="">Payer</a></h2></td>
      </tr>
      
    
    </tbody>
  </table>
      <a href=''><h2>Imprimer</h2></a>
 </div> 
</body>
  <script src='PaieAsets/js/jquery.min.js'></script>
<script src='PaieAsets/js/__jquery.tablesorter.min.js'></script>

    <script src="js/index.js"></script>

</body>
</html>
