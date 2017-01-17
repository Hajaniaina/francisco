<%-- 
    Document   : ListePaie
    Created on : 10 déc. 2016, 00:16:43
    Author     : User
--%>

<%@page import="java.sql.Time"%>
<%@page import="mapping.Personnel"%>
<%@page import="Selection.GetAllModel"%>
<%@page import="PointageMultiple.ListeRetParJourEtSemaineEmp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="PointageMultiple.Fonction.GetAllRetardSemaine"%>
<%@page import="Selection.GetAllEmploye"%>
<%@page import="connexion.AcceeBaseListePaie"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="mapping.ListePaie"%>
<%@page import="Fonction.FonctionListePaie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../PaieAsets/css/style.css">
        <title>Pointage multiple</title>
         <%
             //Model//
             Object[][] model=new GetAllModel().getModel();
             ListeRetParJourEtSemaineEmp semaimeretEmp=new ListeRetParJourEtSemaineEmp();
             //____fin model-----------//
            GetAllEmploye getAllEmp =new GetAllEmploye();
            Object[][]all=getAllEmp.getAllAmploye();
            int []listMat=new int [all.length];
            Object[]retard=new Object[all.length];
                
               if(request.getParameter("daty")!=null)
               {
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date semaine;
                   
                    java.util.Date date2 = sdf1.parse(request.getParameter("daty"));
                    semaine=new java.sql.Date(date2.getTime());
                   for(int i=0;i<all.length;i++)
                    {
                       
                        listMat[i]=Integer.parseInt(all[i][4].toString());
                    }
                   
                 retard=new GetAllRetardSemaine().listeRetard(listMat,semaine);
               }
               
               //--------------Liste  de retard et Somme Par semaine------------------//
               
                ListeRetParJourEtSemaineEmp []liste=new ListeRetParJourEtSemaineEmp[all.length] ;
                
                //---------aloation---------------//
                Object[]heurePardef=new Object[7];
                Object[]retardPardef=new Object[7];
                for(int i=0;i<7;i++)
                {
                    heurePardef[i]=new Object();
                    retardPardef[i]=new Object();
                    heurePardef[i]="";
                    retardPardef[i]="0";
                }
               
                for(int k=0;k<all.length;k++)
                {
                    liste[k]=new ListeRetParJourEtSemaineEmp(heurePardef,retardPardef,"0");
                }
                //session//
                if(request.getSession().getAttribute("listeRetEtSomme")!=null)
                {
                    liste=(ListeRetParJourEtSemaineEmp[])request.getSession().getAttribute("listeRetEtSomme");
                    //JOptionPane.showMessageDialog(null,"reto ihn   v:"+liste[1].getRet()[6].toString());
                }
                //sesion//
                if(request.getParameter("modelSelected")!=null)
                {
                    Object[]heure=new Object[7];
                    Personnel perso=new Personnel();
                    Object[][]modelSelected=new GetAllModel().modelOnNom(request.getParameter("modelSelected"));
                   // JOptionPane.showMessageDialog(null,"reto ihn   v:"+request.getParameter("modelSelected"));
                    for(int i=0;i<all.length;i++)
                    {
                        heure[0]=modelSelected[i][0];
                        heure[1]=modelSelected[i][1];
                        heure[2]=modelSelected[i][2];
                        heure[3]=modelSelected[i][3];
                        heure[4]=modelSelected[i][4];
                        heure[5]=modelSelected[i][5];
                        heure[6]=modelSelected[i][6];
                        
                        perso.setMatricule(Integer.parseInt(modelSelected[i][8].toString()));
                         
                        Object[][]listeRetUneSemaine=semaimeretEmp.getRetHeurESommeRetSemaine(heure, retardPardef, perso);
                        
                        liste[i]= new ListeRetParJourEtSemaineEmp(listeRetUneSemaine[0],listeRetUneSemaine[1],semaimeretEmp.getSommeRet()); 
                    }
                   
                }
                
                //fin alocation//
               //all[i][1]
                //JOptionPane.showMessageDialog(null,"reto ihn   v:");
       %>
    </head>
    <body>
  <body>
      <form method="" action="">
            <select name="poste">
                <option>Tous
                
            </select>
            
            <input type="submit"  value="ok">
      </form>
    <%
        if(request.getParameter("poste")!=null && request.getParameter("poste").compareToIgnoreCase("Tous")!=0 )
        {
            all=getAllEmp.getAllAmployeOnPoste(request.getParameter("poste"));
        }
    %>
 <div id="wrapper">
  <h1>Pointage Multiple</h1>
 
  <table id="keywords" cellspacing="0" cellpadding="0">
    <thead>
      
      <tr>
        <th><span>Matricule</span></th>
        <th><span>Nom</span></th>
        <th><span>Lundi</span></th>
        <th><span>Mardi</span></th>
        <th><span>Mercredi</span></th>
	<th><span>Jeudi</span></th>
	<th><span>Vendredi</span></th>
	<th><span>Samedi</span></th>
        <th><span>Dmance</span></th>
        <th><span>Retards</span></th>
        
      </tr>
     
    </thead>
    <tbody>
    <form method="" action="TraitementPointageMultiple.jsp">
        <input type="text"  name="semaine" placeholder="Semaine" required="">
        <input type="hidden"  name="size" placeholder="size" value="<%=all.length%>" required="">
     <%for(int i=0;i<all.length;i++){%>
      <tr>
        <td class="lalign"> <input type="text"  name="matricule<%out.print(all[i][5]);%>" placeholder="Matricule" style="width: 120px" value="<%out.print(all[i][5]);%>"></td>
        <td class="lalign"> <input type="text"  name="nom<%out.print(all[i][5]);%>" placeholder="Nom" style="width: 120px" value="<%out.print(all[i][0]);%>"></td>
        
        <td> <input type="text"  name="Lundi<%out.print(all[i][5]);%>" placeholder="Lundi" value="<%out.print(liste[i].getHeureEntree()[0].toString());%>" style="width: 60px">||<input type="text"  name="retartLundi<%out.print(all[i][5]);%>" placeholder="Ret" style="width: 30px" value="<%out.print(liste[i].getRet()[0].toString());%>"></td>
        <td> <input type="text"  name="Mardi<%out.print(all[i][5]);%>" placeholder="Mardi" value="<%out.print(liste[i].getHeureEntree()[1].toString());%>" style="width: 60px">||<input type="text"  name="retartMardi<%out.print(all[i][5]);%>" placeholder="Ret" style="width: 30px" value="<%out.print(liste[i].getRet()[1].toString());%>"></td>
        <td> <input type="text"  name="Mercredi<%out.print(all[i][5]);%>" placeholder="Mercredi"  value="<%out.print(liste[i].getHeureEntree()[2].toString());%>" style="width: 60px">||<input type="text"  name="retartMercredi<%out.print(all[i][5]);%>" placeholder="Ret" style="width: 30px" value="<%out.print(liste[i].getRet()[2].toString());%>"></td>
        <td> <input type="text"  name="Jeudi<%out.print(all[i][5]);%>" placeholder="Jeudi" value="<%out.print(liste[i].getHeureEntree()[3].toString());%>" style="width: 60px">||<input type="text"  name="retartJeudi<%out.print(all[i][5]);%>" placeholder="Ret" style="width: 30px" value="<%out.print(liste[i].getRet()[3].toString());%>"></td>
        <td> <input type="text"  name="Vendredi<%out.print(all[i][5]);%>" placeholder="Vendredi" value="<%out.print(liste[i].getHeureEntree()[4].toString());%>" style="width: 60px">||<input type="text"  name="retartVendredi<%out.print(all[i][5]);%>" placeholder="Ret" style="width: 30px" value="<%out.print(liste[i].getRet()[4].toString());%>"></td>
        <td> <input type="text"  name="Samedi<%out.print(all[i][5]);%>" placeholder="Samedi" value="<%out.print(liste[i].getHeureEntree()[5].toString());%>" style="width: 60px">||<input type="text"  name="retartSamedi<%out.print(all[i][5]);%>" placeholder="Ret" style="width: 30px" value="<%out.print(liste[i].getRet()[5].toString());%>"></td>
        <td> <input type="text"  name="Dmanche<%out.print(all[i][5]);%>" placeholder="Dmanche" value="<%out.print(liste[i].getHeureEntree()[6].toString());%>" style="width: 60px">||<input type="text"  name="retartDimanche<%out.print(all[i][5]);%>" placeholder="Ret" style="width: 30px" value="<%out.print(liste[i].getRet()[6].toString());%>"></td>
        <td> <input type="text"  name="retard<%out.print(all[i][5]);%>" placeholder="Retard" value="<%out.print(Double.parseDouble(liste[i].getSommeRet()));%>" style="width: 60px" value="<%=retard[i]%>"></td>
       </tr>
    <%}%>
    <tr>
        <td><input type="submit"  value="Valider"></td>
        <td><input type="submit" name="model" value="model"></td>
        <td><input type="submit" name="distribuer" value="Distribuer"></td>
    </tr>
    
    </form>
    <form action="csv.jsp">
     <td><input type="submit"  value="Importer CSV"></td>
    
    </form>
   
   
    <form action="">
     
     <td><select style="width: 200px" name="modelSelected" action="AffichagePointageMultiple.jsp">
             <% for(int i=0;i<model.length;i++){%>
                     <option><%=model[i][7]%>
                     
             <%}%>
         </select></td>
         <td><input type="submit"  value="Choisir"></td>
    </form>
    </tbody>
  </table>
 </div> 
</body>
   <script src='PaieAsets/js/jquery.min.js'></script>
<script src='PaieAsets/js/__jquery.tablesorter.min.js'></script>
    <script src="js/index.js"></script>

</body>
</html>
