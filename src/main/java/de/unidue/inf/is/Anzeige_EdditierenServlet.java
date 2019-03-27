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


public final class Anzeige_EdditierenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int anzeige_id;
	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Put the user list in request and let freemarker paint it.
		anzeige_id = Integer.parseInt(request.getParameter("id"));
      
    
        request.getRequestDispatcher("/anzeige_edditieren.ftl").forward(request, response);
    }
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                    IOException {
    	
    	if (request.getParameter("action").equals("anzeige_edditieren")) {
			// Append parameter of request
			float preis = 0;
			String stringpreis = (String) request.getParameter("preis");
			String titel = (String) request.getParameter("titel");
			String beschreibung = (String) request.getParameter("beschreibung");
			String[] kategories = request.getParameterValues("checkedRows");
			String ka=kategories.toString();
			//String kat = request.getParameterValues("checkedRows");
			if (stringpreis != null) {
				preis = Float.parseFloat(stringpreis);
			}
			Anzeige neu_Anz= new Anzeige(titel, beschreibung, preis, anzeige_id, ka);
			//AnzeigeUpdate.updateAnzeige(neu_Anz);
			//response.sendRedirect("/anzeige_edditieren?id=" + anzeige_id);
			response.sendRedirect("home");

		} else
			response.sendRedirect("/anzeige_edditieren?id=" + anzeige_id );
    

	}

	

    
}
