package br.com.geniuskitchen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("\nGET - Login");
		RequestDispatcher dispatcher = req.getRequestDispatcher("login/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("\nPOST - Login");
		System.out.println("Nome: " + req.getParameter("nome"));
		System.out.println("E-mail: " + req.getParameter("email"));
		System.out.println("Senha: " + req.getParameter("senha"));
		super.doPost(req, resp);
	}
	
}
