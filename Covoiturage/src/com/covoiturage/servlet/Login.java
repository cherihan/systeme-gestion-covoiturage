package com.covoiturage.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.covoiturage.Compte;
import com.covoiturage.dao.CompteDAO;
import com.covoiturage.dao._RootDAO;

public class Login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			_RootDAO.initialize("com/configuration/hibernate.cfg.xml");
			Compte user = new Compte();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			CompteDAO cdao = new CompteDAO();
			user = cdao.Login(username, password);

			if (user != null) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("Admin.jsp"); // logged-in page
			}

			else
				response.sendRedirect("default.jsp"); // error page
		}

		catch (Throwable theException) {
			System.out.println("Erreur "+theException);
		}
	}
}
