package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Land;
import be.vdab.entities.Soort;
import be.vdab.services.LandService;
import be.vdab.services.SoortService;
import be.vdab.services.WijnService;

@WebServlet("/index.htm")
public class WijnenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/wijnen.jsp";
	private LandService landService = new LandService();
	private SoortService soortService = new SoortService();
	private WijnService wijnService = new WijnService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("landen", landService.findAll());
		
		String landID = request.getParameter("landid");
		if (landID != null) {
			Land land = landService.read(Long.parseLong(landID));
			request.setAttribute("land", land);
			request.setAttribute("soorten", soortService.findByLand(land));
		}	
		
		String soortID = request.getParameter("soortid");
		if (soortID != null) {
			Soort soort = soortService.read(Long.parseLong(soortID));
			request.setAttribute("soort", soort);
			request.setAttribute("wijnen", wijnService.findBySoort(soort));
		}	
		
		request.getRequestDispatcher(VIEW).forward(request, response);
	}



}
