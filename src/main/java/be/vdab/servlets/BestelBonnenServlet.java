package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.BestelBonService;

@WebServlet("/bestelbonnen.htm")
public class BestelBonnenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/bestelbonnen.jsp";
	private BestelBonService bestelBonService = new BestelBonService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bestelbonnen", bestelBonService.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}