package br.com.geniuskitchen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.geniuskitchen.dao.HomeDAO;


@WebServlet("/home-cardapio")
public class HomeServlet extends HttpServlet {
	
	private HomeDAO data = new HomeDAO();
		
	//tomcat7:run
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var itemsCardapio = data.buscarItemsDoCardapio();
		 if(itemsCardapio.size() > 0) {
			 req.setAttribute("ItemsCardapio", itemsCardapio);			 
		 }
		 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/home/home-cardapio.jsp");
		
		dispatcher.forward(req, resp);
	}
}
