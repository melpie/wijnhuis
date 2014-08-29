package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Wijn;
import be.vdab.exceptions.WijnNietGevondenException;
import be.vdab.services.WijnService;

@WebServlet("/toevoegen.htm")
public class ToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/toevoegen.jsp";
	private WijnService wijnService = new WijnService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String wijnID = request.getParameter("wijnid");
			Wijn wijn = wijnService.read(Long.parseLong(wijnID));
			request.setAttribute("wijn", wijn);
		} catch (NumberFormatException ex) {
			request.setAttribute("foutWijnId", "Kies een wijn! Ga terug naar tabblad wijnen.");
		} catch (WijnNietGevondenException ex) {
			request.setAttribute("foutWijnId", "Kies een wijn! Ga terug naar tabblad wijnen.");
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}



}