package org.apache.jsp.PointageMultiple;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Time;
import mapping.Personnel;
import Selection.GetAllModel;
import PointageMultiple.ListeRetParJourEtSemaineEmp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import PointageMultiple.Fonction.GetAllRetardSemaine;
import Selection.GetAllEmploye;
import connexion.AcceeBaseListePaie;
import javax.swing.JOptionPane;
import mapping.ListePaie;
import Fonction.FonctionListePaie;

public final class AffichagePointageMultiple_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../PaieAsets/css/style.css\">\n");
      out.write("        <title>Pointage multiple</title>\n");
      out.write("         ");

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
       
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("  <body>\n");
      out.write("      <form method=\"\" action=\"\">\n");
      out.write("            <select name=\"poste\">\n");
      out.write("                <option>Tous\n");
      out.write("                \n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\"  value=\"ok\">\n");
      out.write("      </form>\n");
      out.write("    ");

        if(request.getParameter("poste")!=null && request.getParameter("poste").compareToIgnoreCase("Tous")!=0 )
        {
            all=getAllEmp.getAllAmployeOnPoste(request.getParameter("poste"));
        }
    
      out.write("\n");
      out.write(" <div id=\"wrapper\">\n");
      out.write("  <h1>Pointage Multiple</h1>\n");
      out.write(" \n");
      out.write("  <table id=\"keywords\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("    <thead>\n");
      out.write("      \n");
      out.write("      <tr>\n");
      out.write("        <th><span>Matricule</span></th>\n");
      out.write("        <th><span>Nom</span></th>\n");
      out.write("        <th><span>Lundi</span></th>\n");
      out.write("        <th><span>Mardi</span></th>\n");
      out.write("        <th><span>Mercredi</span></th>\n");
      out.write("\t<th><span>Jeudi</span></th>\n");
      out.write("\t<th><span>Vendredi</span></th>\n");
      out.write("\t<th><span>Samedi</span></th>\n");
      out.write("        <th><span>Dmance</span></th>\n");
      out.write("        <th><span>Retards</span></th>\n");
      out.write("        \n");
      out.write("      </tr>\n");
      out.write("     \n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("    <form method=\"\" action=\"TraitementPointageMultiple.jsp\">\n");
      out.write("        <input type=\"text\"  name=\"semaine\" placeholder=\"Semaine\" required=\"\">\n");
      out.write("        <input type=\"hidden\"  name=\"size\" placeholder=\"size\" value=\"");
      out.print(all.length);
      out.write("\" required=\"\">\n");
      out.write("     ");
for(int i=0;i<all.length;i++){
      out.write("\n");
      out.write("      <tr>\n");
      out.write("        <td class=\"lalign\"> <input type=\"text\"  name=\"matricule");
out.print(all[i][5]);
      out.write("\" placeholder=\"Matricule\" style=\"width: 120px\" value=\"");
out.print(all[i][5]);
      out.write("\"></td>\n");
      out.write("        <td class=\"lalign\"> <input type=\"text\"  name=\"nom");
out.print(all[i][5]);
      out.write("\" placeholder=\"Nom\" style=\"width: 120px\" value=\"");
out.print(all[i][0]);
      out.write("\"></td>\n");
      out.write("        \n");
      out.write("        <td> <input type=\"text\"  name=\"Lundi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Lundi\" value=\"");
out.print(liste[i].getHeureEntree()[0].toString());
      out.write("\" style=\"width: 60px\">||<input type=\"text\"  name=\"retartLundi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Ret\" style=\"width: 30px\" value=\"");
out.print(liste[i].getRet()[0].toString());
      out.write("\"></td>\n");
      out.write("        <td> <input type=\"text\"  name=\"Mardi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Mardi\" value=\"");
out.print(liste[i].getHeureEntree()[1].toString());
      out.write("\" style=\"width: 60px\">||<input type=\"text\"  name=\"retartMardi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Ret\" style=\"width: 30px\" value=\"");
out.print(liste[i].getRet()[1].toString());
      out.write("\"></td>\n");
      out.write("        <td> <input type=\"text\"  name=\"Mercredi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Mercredi\"  value=\"");
out.print(liste[i].getHeureEntree()[2].toString());
      out.write("\" style=\"width: 60px\">||<input type=\"text\"  name=\"retartMercredi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Ret\" style=\"width: 30px\" value=\"");
out.print(liste[i].getRet()[2].toString());
      out.write("\"></td>\n");
      out.write("        <td> <input type=\"text\"  name=\"Jeudi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Jeudi\" value=\"");
out.print(liste[i].getHeureEntree()[3].toString());
      out.write("\" style=\"width: 60px\">||<input type=\"text\"  name=\"retartJeudi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Ret\" style=\"width: 30px\" value=\"");
out.print(liste[i].getRet()[3].toString());
      out.write("\"></td>\n");
      out.write("        <td> <input type=\"text\"  name=\"Vendredi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Vendredi\" value=\"");
out.print(liste[i].getHeureEntree()[4].toString());
      out.write("\" style=\"width: 60px\">||<input type=\"text\"  name=\"retartVendredi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Ret\" style=\"width: 30px\" value=\"");
out.print(liste[i].getRet()[4].toString());
      out.write("\"></td>\n");
      out.write("        <td> <input type=\"text\"  name=\"Samedi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Samedi\" value=\"");
out.print(liste[i].getHeureEntree()[5].toString());
      out.write("\" style=\"width: 60px\">||<input type=\"text\"  name=\"retartSamedi");
out.print(all[i][5]);
      out.write("\" placeholder=\"Ret\" style=\"width: 30px\" value=\"");
out.print(liste[i].getRet()[5].toString());
      out.write("\"></td>\n");
      out.write("        <td> <input type=\"text\"  name=\"Dmanche");
out.print(all[i][5]);
      out.write("\" placeholder=\"Dmanche\" value=\"");
out.print(liste[i].getHeureEntree()[6].toString());
      out.write("\" style=\"width: 60px\">||<input type=\"text\"  name=\"retartDimanche");
out.print(all[i][5]);
      out.write("\" placeholder=\"Ret\" style=\"width: 30px\" value=\"");
out.print(liste[i].getRet()[6].toString());
      out.write("\"></td>\n");
      out.write("        <td> <input type=\"text\"  name=\"retard");
out.print(all[i][5]);
      out.write("\" placeholder=\"Retard\" value=\"");
out.print(Double.parseDouble(liste[i].getSommeRet()));
      out.write("\" style=\"width: 60px\" value=\"");
      out.print(retard[i]);
      out.write("\"></td>\n");
      out.write("       </tr>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td><input type=\"submit\"  value=\"Valider\"></td>\n");
      out.write("        <td><input type=\"submit\" name=\"model\" value=\"model\"></td>\n");
      out.write("        <td><input type=\"submit\" name=\"distribuer\" value=\"Distribuer\"></td>\n");
      out.write("    </tr>\n");
      out.write("    \n");
      out.write("    </form>\n");
      out.write("    <form action=\"csv.jsp\">\n");
      out.write("     <td><input type=\"submit\"  value=\"Importer CSV\"></td>\n");
      out.write("    \n");
      out.write("    </form>\n");
      out.write("   \n");
      out.write("   \n");
      out.write("    <form action=\"\">\n");
      out.write("     \n");
      out.write("     <td><select style=\"width: 200px\" name=\"modelSelected\" action=\"AffichagePointageMultiple.jsp\">\n");
      out.write("             ");
 for(int i=0;i<model.length;i++){
      out.write("\n");
      out.write("                     <option>");
      out.print(model[i][7]);
      out.write("\n");
      out.write("                     \n");
      out.write("             ");
}
      out.write("\n");
      out.write("         </select></td>\n");
      out.write("         <td><input type=\"submit\"  value=\"Choisir\"></td>\n");
      out.write("    </form>\n");
      out.write("    </tbody>\n");
      out.write("  </table>\n");
      out.write(" </div> \n");
      out.write("</body>\n");
      out.write("   <script src='PaieAsets/js/jquery.min.js'></script>\n");
      out.write("<script src='PaieAsets/js/__jquery.tablesorter.min.js'></script>\n");
      out.write("    <script src=\"js/index.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
