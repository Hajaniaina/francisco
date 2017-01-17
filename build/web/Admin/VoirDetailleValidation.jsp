<%@page import="Selection.SelectionAvance"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Validation</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    int matricule=Integer.parseInt(request.getParameter("matricule"));
    Object[][]listeAvance=new SelectionAvance().getDetailleAvanceAvance(matricule);
%>
<div class="container">
  <h2>Valider la demande d'avance</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Fonction</th>
        <th>Montant</th>
        <th>Date</th>
        <th>Nombre de payement</th>
       
      </tr>
    </thead>
    <tbody>
        <%for(int i=0;i<listeAvance.length;i++){%>
      <tr>
        <td><%out.print(listeAvance[i][0]);%></td>
        <td><%out.print(listeAvance[i][1]);%></td>
        <td><%out.print(listeAvance[i][2]);%></td>
        <td><%out.print(listeAvance[i][3]);%></td>
        <td><%out.print(listeAvance[i][4]);%></td>
        <%}%>
      </tr> 
    
      
    </tbody>
  </table>
      <a href="ValidationAvance.jsp">Valider</a>
</div>

</body>
</html>

