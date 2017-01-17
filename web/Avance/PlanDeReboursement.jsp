<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
 <%
        String daty=request.getParameter("datesaisie");
        String montan=request.getParameter("montant");
        String matricule=request.getParameter("saisiMatricule");
        int nombreRembou=Integer.parseInt(request.getParameter("nmb"));
 %>
<div class="container">
  <h2>Plan de rembousement</h2>
  <form class="form-inline" action="ValidatioFinal.jsp">
      <input type="hidden" name="datesaisie" class="form-control" id="email" value="<%out.print(daty);%>">
      <input type="hidden" name="montant" class="form-control" id="email" value="<%out.print(montan);%>">
      <input type="hidden" name="saisiMatricule" class="form-control" id="email" value="<%out.print(matricule);%>">
      <input type="hidden" name="nmb" class="form-control" id="email" value="<%out.print(nombreRembou);%>">
  <%for(int i=0;i<nombreRembou;i++){%>
    <div class="form-group">
      <label for="email">Date: <%out.print(i+1);%></label>
      <input type="text" name="date<%out.print(i+1);%>" class="form-control" id="email" placeholder="Date">
    </div>
    <div class="form-group">
      <label for="mont">Montant</label>
      <input type="text" name="montant<%out.print(i+1);%>" class="form-control" id="pwd" placeholder="Montant">
    </div>
    <br>
    <br>
    <br>
  <%}%>
    <button type="submit" class="btn btn-default">Ok</button>
  </form>
</div>

</body>
</html>
