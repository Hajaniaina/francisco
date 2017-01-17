<%-- 
    Document   : ListePaie
    Created on : 10 déc. 2016, 00:16:43
    Author     : User
--%>

<%@page import="PointageMultiple.Fonction.Concatenner"%>
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
        <link rel="stylesheet" href="../PaieAsets/css/style.css">
        <title>Nouvel Employé</title>
    </head>
    <body>
  <body>
      
 <div id="wrapper">
    
  <h1>Nouvel Employé</h1>
  
  <%
      String concat="";
      String nouvNom=request.getParameter("nouvNom");
      if(request.getParameter("entreMatin")!=null && request.getParameter("sortieMidi")!=null && request.getParameter("entreeMidi")!=null&& request.getParameter("sortieSoir")!=null )
      {
          String[]liste=new String[4];
          
          liste[0]=request.getParameter("entreMatin");
          liste[1]=request.getParameter("sortieMidi");
          liste[2]=request.getParameter("entreeMidi");
          liste[3]=request.getParameter("sortieSoir");
          
          concat=new Concatenner().concatenner(liste);
      }
  %>
  <div id='user-apropos'style='margin-left: 435px;'>
  <h2>NOM:  <%=nouvNom%></h2><hr><br>
  <form action="TraitementNouvelEmploye.jsp" method="">
      
      <input type="hidden"  name="nom" placeholder="Nom" value="haja" style="width: 200px">
         <h4> Type de travail:</h4><br>
         <select name="typeTravail">
             <option>bureau
             <option>nuit
         </select><br>
        <h4> Poste:</h4><br>
         <input type="text"  name="poste" placeholder="Poste" style="width: 200px"><br>
        <h4> Sexe:</h4><br>
         <select name="sexe">
             <option value="M">Masculin
             <option value="F">Feminin
         </select><br>
         <h4>Matricule:</h4><br>
         <input type="text"  name="matricule" placeholder="Matricule" style="width: 200px"><br>
         <h4>Date d'embauche:</h4><br>
         <input type="text"  name="dateEmbauche" placeholder="Date Embauche" style="width: 200px"><br>
         <h4>Salaire de base: </h4><br>
         <input type="text"  name="salaire" placeholder="Salaire" style="width: 200px"><br>
         <h4>Emploi du temps </h4><br>
          <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Saisir Emploi du temps</button><br>
         <input class="string optional" name="partitionEmp" maxlength="255" id="user-email" placeholder="" value="<%=concat%>"  type="hidden" size="50" required />
         <label class="string optional" for="user-name"><%=concat%></label><br><hr>
         <input type="submit" value='Ok'>
         
          
         
  </form>
  </div>
 </div> 
         
         <!--Modal-->
  <div class="container">
 
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content" style="">
          <form method="" action=''>
              <h4>Entree matin</h4><br>
               <input type="text"  name="entreMatin" placeholder="Entree Matin" style="width: 200px"><br>
               <h4>Sortie Midi</h4><br>
               <input type="text"  name="sortieMidi" placeholder="Sortie Midi" style="width: 200px"><br>
               <h4>Entree Midi</h4><br>
               <input type="text"  name="entreeMidi" placeholder="Entree Midi" style="width: 200px"><br>
               <h4>Sortie  soir</h4><br>
               <input type="text"  name="sortieSoir" placeholder="Sortie Soir" style="width: 200px"><br>
               
               <input type="submit" value='Ok'>
          </form>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
</body>
  <script src='../PaieAsets/js/jquery.min.js'></script>
<script src='../PaieAsets/js/__jquery.tablesorter.min.js'></script>
 <!--Bootstrap-->
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="js/index.js"></script>

</body>
</html>
