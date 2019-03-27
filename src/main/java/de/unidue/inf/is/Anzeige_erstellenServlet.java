package de.unidue.inf.is;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.domain.*;
import de.unidue.inf.is.stores.*;
import de.unidue.inf.is.utils.DBUtil;


public final class Anzeige_erstellenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Put the user list in request and let freemarker paint it.
		//anzeige_id = Integer.parseInt(request.getParameter("id"));

        request.getRequestDispatcher("/anzeige_erstellen.ftl").forward(request, response);
    }
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                    IOException {
    	String ersteller= DBUtil.getBenutzer();
    	//int id= 1;
    	String titel = request.getParameter("titel");
    	//String kategorie=request.getParameter("kategorie");
        String[] kategories = request.getParameterValues("kategorie");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < kategories.length; i++) {
			String string = kategories[i];
			sb.append(string);
    		sb.append("");
		}
        	
        	String finalKat=sb.toString();
        	System.out.println("DEbugerr");
        	System.out.println(finalKat);
        	System.out.println("DEbugerr");
    	String preisX=request.getParameter("preis");
    	float preis=Integer.parseInt(preisX);
    	String text=request.getParameter("beschreibung");
    	//System.out.println(titel);
    	
    	//Anzeige Anz =new Anzeige();
    	//String d= Anz.getDate_ajout();
    	//String s=Anz.getStatus();
    	String s="aktiv";
    	
    	AnzeigeStore anzeigeStore= new AnzeigeStore();
    	Anzeige ajout_Anzeige= new Anzeige(titel,text,preis,ersteller,s);
    	anzeigeStore.addAnzeige(ajout_Anzeige);
    	//Anzeige saved = anzeigeStore.addAnzeige(ajout_Anzeige);
    	//int anzeige_id=saved.getId();
    	//AnzeigeUpdate.insertHatKategorie(finalKat, anzeige_id);
    	
    	anzeigeStore.complete();
    	anzeigeStore.close();
    	
    	response.sendRedirect("home");
    	 
    	//request.getRequestDispatcher("/anzeige_erstellen.ftl").forward(request, response);
    	//doGet(request, response);

    }
}
