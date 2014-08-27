package be.vdab.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.Wijn;
import be.vdab.services.WijnService;


@WebServlet("/mandje.htm")
public class MandjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/mandje.jsp";
	private static final String REDIRECT_URL = "/mandje.htm";
	private WijnService wijnService = new WijnService();

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			@SuppressWarnings("unchecked")
			Map<Long, Integer> wijnNrsInMandje = (Map<Long, Integer>) session.getAttribute("mandje");
			if (wijnNrsInMandje != null) {
				
				Map<Wijn, Integer> wijnenInMandje = new LinkedHashMap<Wijn, Integer>();
				double totaal = 0;
				
				Iterator<Long> it = wijnNrsInMandje.keySet().iterator();
				while (it.hasNext()) { 
					Long wijnNr = it.next(); 
					Wijn wijn = wijnService.read(wijnNr);
					wijnenInMandje.put(wijn, wijnNrsInMandje.get(wijnNr));
					totaal += wijnNrsInMandje.get(wijnNr) * wijn.getPrijs();
				}
				
				request.setAttribute("wijnenInMandje", wijnenInMandje);
				request.setAttribute("totaal", totaal);
			}
		} else {
			request.setAttribute("foutSession", "Mandje niet gevuld.");		
		}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<Long, Integer> wijnNrsInMandje = (Map<Long, Integer>) session.getAttribute("mandje");
		
		if (request.getParameter("wijnid") != null && request.getParameter("aantal") != null) {
			
			if (wijnNrsInMandje == null) {
				wijnNrsInMandje = new LinkedHashMap<Long, Integer>();
			}
			
			try {
				wijnNrsInMandje.put(Long.parseLong(request.getParameter("wijnid")), Integer.parseInt(request.getParameter("aantal")));
				session.setAttribute("mandje", wijnNrsInMandje);
			} catch (NumberFormatException ex) {
				
			}
			
		} 
		
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + REDIRECT_URL));
		
	}

}