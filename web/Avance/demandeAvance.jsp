<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Avance</title>
  
        <link rel="stylesheet" href="../PointageAssets/css/normalize.min.css">
        <link rel='stylesheet prefetch' href='../PointageAssets/css/font-awesome.min.css'>
      <link rel="stylesheet" href="../PointageAssets/css/style.css"> 
      
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <script src="../PointageAssets/js/date.js"></script>
</head>

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
        <div class="logmod__heading">
            <span class="logmod__heading-subtitle"> <strong>
                 <span id="date_heure1"></span>
                <span id="date_heureMinute1"></span>
            <script type="text/javascript">window.onload = date('date_heure1');</script>
            <script type="text/javascript">window.onload = heure('date_heureMinute1');</script>
             </strong></span>
        </div>
        <div class="logmod__form">
          <form  action="PlanDeReboursement.jsp" >
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Date de saisie</label>
                <input class="string optional"name="datesaisie" maxlength="255" id="user-email" placeholder="Date" type="text" size="50" required/>
              </div>
            </div>
           <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Montant</label>
                <input class="string optional" maxlength="255" name="montant" id="user-email" placeholder="Montant" type="text" size="50" required />
              </div>
            </div>
              <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Matricule</label>
                <input class="string optional" name="saisiMatricule" maxlength="255" id="user-email" placeholder="Matricule" type="text" size="50" required />
              </div>
            </div>
             <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Nombre reboursement</label>
                <input class="string optional" name="nmb" maxlength="255" id="user-email" placeholder="Nombre de reboursemenr" type="text" size="50" required />
              </div>
            </div>
              
            <div class="simform__actions">
              <input class="sumbit" name="commit" type="submit" value="Plannifier le reboursement" />
             
            </div> 
          </form>
        </div> 
        <div class="logmod__alter">
          <div class="logmod__alter-container">
            <a href="#" class="connect facebook">
              
              <div class="connect__context">
                <span> <strong>Demande d'avance</strong></span>
              </div>
            </a>
           
            </a>
          </div>
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
