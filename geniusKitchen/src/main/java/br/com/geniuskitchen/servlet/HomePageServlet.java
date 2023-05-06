package br.com.geniuskitchen.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.geniuskitchen.dao.CardapioDAO;
import br.com.geniuskitchen.model.ItemCardapio;

@WebServlet("/inicio")
public class HomePageServlet extends HttpServlet {
	
	private CardapioDAO _dao;
	
	@Override
	public void init() throws ServletException {
		_dao = new CardapioDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("\nGET - Inicio");
		List<ItemCardapio> listaItems = new ArrayList<>();

		listaItems = _dao.buscarItemsDoCardapio();

		req.setAttribute("listaItems", listaItems);
		RequestDispatcher dispatcher = req.getRequestDispatcher("home/home-cardapio.jsp");
		dispatcher.forward(req, resp);
	}
}
