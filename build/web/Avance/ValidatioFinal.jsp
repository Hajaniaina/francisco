<%@page import="javax.swing.JOptionPane"%>
<%@page import="Fonction.DemandeAvance"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Validation</title>

    <link rel="stylesheet" href="../PointageAssets/css/normalize.min.css">
    <link rel='stylesheet prefetch' href='../PointageAssets/css/font-awesome.min.css'>
  <link rel="stylesheet" href="../PointageAssets/css/style.css"> 

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="../PointageAssets/js/date.js"></script>
</head>

<%
        String daty=request.getParameter("datesaisie");
        String montan=request.getParameter("montant");
        String matricule=request.getParameter("saisiMatricule");
        int nombreRembou=Integer.parseInt(request.getParameter("nmb"));
        
        
        String []listeDate=new String[nombreRembou];
        int []listeMont=new int[nombreRembou];
        for(int i=0;i<listeDate.length;i++)
        {
            String datyParam="date";
            String param=datyParam.concat(""+(i+1));
            listeDate[i]=request.getParameter(param);

        }
        for(int i=0;i<listeMont.length;i++)
        {
            String montantParam="montant";
            String param=montantParam.concat(""+(i+1));
            listeMont[i]=Integer.parseInt(request.getParameter(param));
        }
        String listPartition=new DemandeAvance().concatenerDeuString(listeDate, listeMont);
 %>

<body>
  <div class="logmod">
  <div class="logmod__wrapper">
    <span class="logmod__close">Close</span>
    <div class="logmod__container">
      <ul class="logmod__tabs">
       
        <li data-tabtar="lgm-1"><a href="#">Demande d'avance</a></li>
      </ul>
      <div class="logmod__tab-wrapper">
      <div class="logmod__tab lgm-1">
       
        <div class="logmod__form">
          <form  action="insertBaseAvance.jsp" >
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Date de saisie</label>
                <input class="string optional" name="datesaisie" maxlength="255" id="user-email" placeholder="Date" value="<%out.print(daty);%>" type="text" size="50" required/>
              </div>
            </div>
           <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Montant</label>
                <input class="string optional" maxlength="255" name="montant" id="user-email" placeholder="Montant" value="<%out.print(montan);%>" type="text" size="50" required />
              </div>
            </div>
              <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Matricule</label>
                <input class="string optional" name="saisiMatricule" maxlength="255" id="user-email" placeholder="Matricule" value="<%out.print(matricule);%>" type="text" size="50" required />
              </div>
            </div>
             <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Nombre reboursement</label>
                <input class="string optional" name="nmb" maxlength="255" id="user-email" placeholder="Nombre de reboursemenr" value="<%out.print(nombreRembou);%>"  type="text" size="50" required />
              </div>
            </div>
              <div class="input full">
                <label class="string optional" for="user-pw">Liste de partition</label><br>
                 <input class="string optional" name="partition" maxlength="255" id="user-email" placeholder="" value="<%out.print(listPartition);%>"  type="hidden" size="50" required />
                 <label class="string optional" for="user-name"><%out.print(listPartition);%></label>                						
              </div>
              
            <div class="simform__actions">
              <input class="sumbit" name="commit" type="submit" value="Valider" />
             
            </div> 
          </form>
        </div> 
        
      </div>
      <div class="logmod__tab lgm-2">
        <div class="logmod__heading">
         
          </span>
        </div> 
        
        <div class="logmod__alter">
          <div class="logmod__alter-container">
            <a href="#" class="connect facebook">
              
              
            </a>
            
          </div>
        </div>
          </div>
      </div>
    </div>
  </div>
</div>
   

  <script src='../PointageAssets/js/jquery.min.js'></script>
  <script src="../PointageAssets/js/index.js"></script>
</body>
</html>
