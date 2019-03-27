package de.unidue.inf.is;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.domain.*;
import de.unidue.inf.is.stores.*;


public final class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Put the user list in request and let freemarker paint it.
		Anzeigen zeig= new Anzeigen();
		request.setAttribute("title", "Anzeige");
		List<Anzeige> anzeige = zeig.getAnzeige();
		List<Anzeige> finalAnzeige = new ArrayList<>();
		for (Anzeige anz: anzeige){
		    if (anz.getStatus().contains("aktiv")) finalAnzeige.add(anz);
        }
		//anzeige kann mehrere kategorie haben
		request.setAttribute("anzeige", finalAnzeige);
        
        request.getRequestDispatcher("/home.ftl").forward(request, response);
    }
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                    IOException {
    	
    	
    	 
    	//request.getRequestDispatcher("/anzeige_erstellen.ftl").forward(request, response);
    	doGet(request, response);

    }
}
