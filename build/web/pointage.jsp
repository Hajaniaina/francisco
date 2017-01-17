<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Pointage</title>
  
        <link rel="stylesheet" href="PointageAssets/css/normalize.min.css">
        <link rel='stylesheet prefetch' href='PointageAssets/css/font-awesome.min.css'>
      <link rel="stylesheet" href="PointageAssets/css/style.css"> 
      <script src="PointageAssets/js/date.js"></script>
</head>

<body>
  <div class="logmod">
  <div class="logmod__wrapper">
    <span class="logmod__close">Close</span>
    <div class="logmod__container">
      <ul class="logmod__tabs">
        <li data-tabtar="lgm-2"><a href="#">Automatique</a></li>
        <li data-tabtar="lgm-1"><a href="#">Taper</a></li>
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
          <form  action="EnregistrementPointage.jsp" >
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Date</label>
                <input class="string optional"name="datepointage" maxlength="255" id="user-email" placeholder="Date" type="text" size="50" required/>
              </div>
            </div>
           <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Heure</label>
                <input class="string optional" maxlength="255" name="heure" id="user-email" placeholder="Heure" type="text" size="50" required />
              </div>
            </div>
              <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Matricule</label>
                <input class="string optional" name="saisiMatricule" maxlength="255" id="user-email" placeholder="Matricule" type="text" size="50" required />
              </div>
            </div>
            <div class="simform__actions">
              <input class="sumbit" name="commit" type="submit" value="Valider" />
             
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
          <script src="PointageAssets/js/date.js"></script> 
          <span class="logmod__heading-subtitle">
              <strong>
           
           
           
              </strong>
          </span>
        </div> 
        <div class="logmod__form">
          <form accept-charset="utf-8" action="EnregistrementPointage.jsp" class="simform">
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name"><span id="date_heure2"></span></label>
              </div>
            </div>
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-pw"> <span id="date_heureMinute2"></span></label>
              
               <!--fonction date et heure--->
                  <script type="text/javascript">window.onload = date('date_heure2');</script>
                  <script type="text/javascript">window.onload = heure('date_heureMinute2');</script>
                <!--fin fonction date et heure--->
              </div>
            </div>
             <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-pw">Matricule</label>
                <input class="string optional" name="saisiMatricule" maxlength="255" id="user-pw" placeholder="Matricule" type="text" size="50" required />
                						
              </div>
            </div>
            <div class="simform__actions">
              <input class="sumbit" name="commit" type="submit" value="Valider" />
              <span class="simform__actions-sidetext"></span>
            </div> 
          </form>
        </div> 
        <div class="logmod__alter">
          <div class="logmod__alter-container">
            <a href='Avance/demandeAvance.jsp' class="connect facebook">
              
              <div class="connect__context">
                <span> <strong>Demande d'avance</strong></span>
              </div>
            </a>
            
          </div>
        </div>
          </div>
      </div>
    </div>
  </div>
</div>
  <script src='PointageAssets/js/jquery.min.js'></script>
  <script src="PointageAssets/js/index.js"></script>
</body>
</html>
