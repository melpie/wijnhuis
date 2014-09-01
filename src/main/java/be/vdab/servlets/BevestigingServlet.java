package be.vdab.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.BestelBon;
import be.vdab.entities.BestelBonLijn;
import be.vdab.entities.Wijn;
import be.vdab.services.BestellingService;
import be.vdab.services.WijnService;

@WebServlet("/bevestiging.htm")
public class BevestigingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/bevestiging.jsp";
	private BestellingService bestellingService = new BestellingService();   
	private WijnService wijnService = new WijnService();   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		if (session != null) {
			String naam = request.getParameter("naam");
			String straat = request.getParameter("straat");
			String huisnummer = request.getParameter("huisnummer");
			String postcode = request.getParameter("postcode");
			String gemeente = request.getParameter("gemeente");
			int bestelwijze;
			try {
				bestelwijze = Integer.parseInt(request.getParameter("bestelwijze"));
			} catch (NumberFormatException ex) {
				// default
				bestelwijze = 0;
			}
			
			BestelBon bestelBon = new BestelBon(new Date(),naam,straat,huisnummer,postcode,gemeente,bestelwijze);
				
			@SuppressWarnings("unchecked")
			Map<Long, Integer> wijnNrsInMandje = (Map<Long, Integer>) session.getAttribute("mandje");
			Set<BestelBonLijn> bestelBonLijnen = new LinkedHashSet<BestelBonLijn>();
			if (wijnNrsInMandje != null) {
				Iterator<Long> it = wijnNrsInMandje.keySet().iterator();
				while (it.hasNext()) { 
					Long wijnNr = it.next(); 
					Wijn wijn = wijnService.read(wijnNr);
					bestelBonLijnen.add(new BestelBonLijn(wijnNrsInMandje.get(wijnNr),wijn,bestelBon));
				}
			}
			
			bestellingService.doeBestelling(bestelBonLijnen, bestelBon);
			request.setAttribute("bestelBon", bestelBon);
			session.invalidate();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);
	
	}

}
