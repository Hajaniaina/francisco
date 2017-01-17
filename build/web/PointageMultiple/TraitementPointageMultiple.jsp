<%-- 
    Document   : TraitementPointageMultiple
    Created on : 10 janv. 2017, 20:24:07
    Author     : User
--%>

<%@page import="Selection.SelectRetardUnEmpSemaine"%>
<%@page import="PointageMultiple.Fonction.InnsertModel"%>
<%@page import="PointageMultiple.ListeRetParJourEtSemaineEmp"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Exception.GestionExecption"%>
<%@page import="PointageMultiple.Fonction.ListeDateHeureNonNull"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="PointageMultiple.Fonction.ComparaisonEMpoye"%>
<%@page import="PointageMultiple.EmployeListe"%>
<%@page import="PointageMultiple.Fonction.IsertPointageMultple"%>
<%@page import="PointageMultiple.SemainePointage"%>
<%@page import="mapping.Personnel"%>
<%@page import="connexion.AcceeBase"%>
<%@page import="PointageMultiple.SemaineUnEmploye"%>
<%@page import="Selection.GetAllEmploye"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>traitement</title>
    </head>
    <body>
        <h1>Bien Fait</h1>
        <%
             GetAllEmploye getAllEmp =new GetAllEmploye();
             Object[][]all=getAllEmp.getAllAmploye();
             String[]listeNom=new String[all.length];
             Personnel p=new Personnel();
             Object[]date=new Object[7];
             Object[]heure=new Object[7];
             Object[]retard=new Object[7];
             int mat=0;
             String Matricule="";
             String semaine="";
             int size=Integer.parseInt(request.getParameter("size"));
             SemaineUnEmploye[]semEmp=new SemaineUnEmploye[all.length];
             //----------------liste ret une semeine---------------------//
             ListeRetParJourEtSemaineEmp []listeRet=new ListeRetParJourEtSemaineEmp[size];
             ListeRetParJourEtSemaineEmp semaimeretEmp=new ListeRetParJourEtSemaineEmp();
             //JOptionPane.showMessageDialog(null,"size"+size);
             for(int i=0;i<size;i++)
             {
              try{
                Matricule=request.getParameter("matricule"+all[i][5]);
                
                String nom=request.getParameter("nom"+all[i][5]);
                mat=new AcceeBase().getmatriculeParCodeMatricule(Matricule);
               //JOptionPane.showMessageDialog(null,"Matricule:"+Matricule+"Manome"+mat);
                p.setMatricule(mat);
                 //date 
                semaine=(String)request.getParameter("semaine");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date sem = sdf1.parse(semaine);
                java.sql.Date semai=new java.sql.Date(sem.getTime());
                for(int k=0;k<7;k++)
                {
                    heure[k]=new Object();
                    retard[k]=new Object();
                    retard[k]="0,0";
                    heure[k]="";
                    //JOptionPane.showMessageDialog(null,"Matricule:"+Matricule+"Manome"+retard[k]);
                }
                 
                 //heure
                 if(request.getParameter("Lundi"+all[i][5])!="" && request.getParameter("Lundi"+all[i][5])!="0")
                 {
                     heure[0]=request.getParameter("Lundi"+all[i][5]);
                 }
                 if(request.getParameter("Mardi"+all[i][5])!="" && request.getParameter("Mardi"+all[i][5])!="0")
                 {
                     heure[1]=request.getParameter("Mardi"+all[i][5]);
                 }
                 if(request.getParameter("Mercredi"+all[i][5])!="" && request.getParameter("Mercredi"+all[i][5])!="0")
                 {
                      heure[2]=request.getParameter("Mercredi"+all[i][5]);
                 }
                 if(request.getParameter("Jeudi"+all[i][5])!="" && request.getParameter("Jeudi"+all[i][5])!="0")
                 {
                      heure[3]=request.getParameter("Jeudi"+all[i][5]);
                 }
                 if(request.getParameter("Vendredi"+all[i][5])!=""  && request.getParameter("Vendredi"+all[i][5])!="0")
                 {
                      heure[4]=request.getParameter("Vendredi"+all[i][5]);
                 }
                 if(request.getParameter("Samedi"+all[i][5])!=""  && request.getParameter("Samedi"+all[i][5])!="0")
                 {
                      heure[5]=request.getParameter("Samedi"+all[i][5]);
                 }
                 if(request.getParameter("Dmanche"+all[i][5])!=""  && request.getParameter("Dmanche"+all[i][5])!="0")
                 {
                      heure[6]=request.getParameter("Dmanche"+all[i][5]);
                 }
                
                 //----------------------retard---------------------//
                 if(request.getParameter("retartLundi"+all[i][5])!="" && request.getParameter("retartLundi"+all[i][5])!="0"  && request.getParameter("retartLundi"+all[i][5]).compareToIgnoreCase("0.0")!=0)
                 {
                     
                     retard[0]=request.getParameter("retartLundi"+all[i][5]);
                 }
                 if(request.getParameter("retartMardi"+all[i][5])!=""  && request.getParameter("retartMardi"+all[i][5])!="0" && request.getParameter("retartMardi"+all[i][5]).compareToIgnoreCase("0.0")!=0)
                 {
                     retard[1]=request.getParameter("retartMardi"+all[i][5]);
                 }
                 if(request.getParameter("retartMercredi"+all[i][5])!=""  && request.getParameter("retartMercredi"+all[i][5])!="0" && request.getParameter("retartMercredi"+all[i][5]).compareToIgnoreCase("0.0")!=0)
                 {
                      retard[2]=request.getParameter("retartMercredi"+all[i][5]);
                 }
                 if(request.getParameter("retartJeudi"+all[i][5])!=""  && request.getParameter("retartJeudi"+all[i][5])!="0" &&  request.getParameter("retartJeudi"+all[i][5]).compareToIgnoreCase("0.0")!=0)
                 {
                      retard[3]=request.getParameter("retartJeudi"+all[i][5]);
                 }
                 if(request.getParameter("retartVendredi"+all[i][5])!=""   && request.getParameter("retartVendredi"+all[i][5])!="0" && request.getParameter("retartVendredi"+all[i][5]).compareToIgnoreCase("0.0")!=0)
                 {
                      retard[4]=request.getParameter("retartVendredi"+all[i][5]);
                 }
                 if(request.getParameter("retartSamedi"+all[i][5])!=""   && request.getParameter("retartSamedi"+all[i][5])!="0" && request.getParameter("retartSamedi"+all[i][5]).compareToIgnoreCase("0.0")!=0)
                 {
                      retard[5]=request.getParameter("retartSamedi"+all[i][5]);
                 }
                 if(request.getParameter("retartDimanche"+all[i][5])!=""   && request.getParameter("retartDimanche"+all[i][5])!="0" && request.getParameter("retartDimanche"+all[i][5]).compareToIgnoreCase("0.0")!=0)
                 {
                      retard[6]=request.getParameter("retartDimanche"+all[i][5]);
                 }
                 //--------------------------------------------------------//
                //--------------------------Retart Par jour-------------------//
                      // JOptionPane.showMessageDialog(null,"input"+retard[6]+"et:"+retSomm);
                       Personnel perso=new Personnel();
                       perso.setMatricule(mat);
                       
                       Object[][]listeRetUneSemaine=semaimeretEmp.getRetHeurESommeRetSemaine(heure, retard, perso);
                       listeRet[i]= new ListeRetParJourEtSemaineEmp(listeRetUneSemaine[0],listeRetUneSemaine[1],semaimeretEmp.getSommeRet());
                      
                    //--------------------------fin retard par jour---------------//
                    
                    Object[][]listeDateHeureNonNull=new ListeDateHeureNonNull().lsteDateHeureNonNull(listeRetUneSemaine[0], semai);
                   // out.print(date[i]);
                    EmployeListe n=new  EmployeListe(nom);
                    listeNom[i]=n.getNom();
                    SemaineUnEmploye listePointSemaine=new SemaineUnEmploye(listeDateHeureNonNull[0],listeDateHeureNonNull[1],p);
                   // out.print(listeDateHeureNonNull[1]);
                    semEmp[i]=listePointSemaine;
                  
                    
                    //--------------model----------------------------//
                    //JOptionPane.showMessageDialog(null,"retard2:"+request.getParameter("model"));
                    if(request.getParameter("model")!=null)
                    {
                        new InnsertModel().insertModel(heure[0].toString(), heure[1].toString(), heure[2].toString(), heure[3].toString(), heure[4].toString(), heure[5].toString(), heure[6].toString(),"Model semiane:"+semaine , mat);
                    }
                    //-----------------fin model-------------------//
              }catch(Exception ex)
              {
                 //String site = new String("AffichagePointageMultiple.jsp");
                 // response.setStatus(response.SC_MOVED_TEMPORARILY);
                  //response.setHeader("Location", site); 
              }
                 
           }
             
             //------------------fin boucle for--------------//
             //----------------session de la liset de retEntreeUesemaineEmpl-------------//
              session.setAttribute("listeRetEtSomme", listeRet);
             
             //--------------------------------------------------------------------------//
             String []m=new String[all.length];
             for(int i=0;i<all.length;i++)
             {
                  m[i]=request.getParameter("matricule"+all[i][5]);
             }
             
             ComparaisonEMpoye nEmp=new  ComparaisonEMpoye();
             SemainePointage semPoint=new SemainePointage(semEmp);
              if(request.getParameter("model")==null)
              {
                 new IsertPointageMultple().insertPointagePultiple(semPoint,m);
              }
             String site2 = new String("AffichagePointageMultiple.jsp?daty="+semaine);
             response.setStatus(response.SC_MOVED_TEMPORARILY);
             response.setHeader("Location", site2); 
              
             try
             {
                nEmp.compareEmp(listeNom); 
              }
             catch(Exception ex)
             {
                String rep=ex.getMessage();
                ex.printStackTrace();
               // JOptionPane.showMessageDialog(null,rep);
                String site = new String("NouvelleEmploye.jsp?nouvNom="+nEmp.getNomNouv()+"");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site); 
             }//
          %>
    </body>
</html>
