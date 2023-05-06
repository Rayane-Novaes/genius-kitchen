/*
 * Esta classe é responsável por controlar a página inicial do sistema Genius Kitchen.
 * Ela é um servlet que recebe requisições GET e busca todos os items do cardápio no banco de dados,
 * para em seguida encaminhar a lista de items para a página home-cardapio.jsp para exibição.
 * Nome do arquivo: HomePageServlet.java
 * Autor: José V. Vieira
 * Data de criação: 05/05/2023
 */
package br.com.geniuskitchen.servlet;

import java.io.IOException;
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

	/**
	 * Método init() que é executado apenas uma vez na criação do objeto. 
	 * Ele cria uma instância da classe CardapioDAO para ser usada posteriormente na requisição GET.
	 */
	@Override
	public void init() throws ServletException {
		_dao = new CardapioDAO();
	}

	/**
	 * Método que recebe requisições do tipo GET para a página inicial do sistema Genius Kitchen.
	 * Ele busca no banco de dados todos os items do cardápio cadastrados, armazena-os em uma lista
	 * e encaminha essa lista para a página home-cardapio.jsp para exibição.
	 * 
	 * @param req objeto HttpServletRequest que contém informações sobre a requisição HTTP feita pelo cliente.
	 * @param resp objeto HttpServletResponse que contém informações sobre a resposta HTTP que será enviada ao cliente.
	 * @throws ServletException se houver algum erro no servlet.
	 * @throws IOException se houver algum erro de entrada/saída.
	 */
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
