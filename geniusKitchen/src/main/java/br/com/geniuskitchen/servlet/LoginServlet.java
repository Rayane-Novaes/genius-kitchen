package br.com.geniuskitchen.servlet;

import br.com.geniuskitchen.model.Login;
import br.com.geniuskitchen.dao.LoginDAO;
import br.com.geniuskitchen.model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Login user = new Login(username, password);

		boolean isValidUser;
		isValidUser = new LoginDAO().verifyCredentials(user);

		if (isValidUser) {

			req.getSession().setAttribute("username", username);

			resp.sendRedirect("find-all-cars");

		} else {

			req.setAttribute("message", "Invalid credentials!");

			req.getRequestDispatcher("login.jsp").forward(req, resp);

		}

	}


}
