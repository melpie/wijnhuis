package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Land;
import be.vdab.entities.Soort;
import be.vdab.entities.Wijn;
import be.vdab.services.LandService;
import be.vdab.services.SoortService;
import be.vdab.services.WijnService;

@WebServlet("/toevoegen.htm")
public class ToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/toevoegen.jsp";
	private LandService landService = new LandService();
	private SoortService soortService = new SoortService();
	private WijnService wijnService = new WijnService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String landID = request.getParameter("landid");
		Land land = landService.read(Long.parseLong(landID));
		request.setAttribute("land", land);
		
		String soortID = request.getParameter("soortid");
		Soort soort = soortService.read(Long.parseLong(soortID));
		request.setAttribute("soort", soort);
		
		String wijnID = request.getParameter("wijnid");
		Wijn wijn = wijnService.read(Long.parseLong(wijnID));
		request.setAttribute("wijn", wijn);
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}



}