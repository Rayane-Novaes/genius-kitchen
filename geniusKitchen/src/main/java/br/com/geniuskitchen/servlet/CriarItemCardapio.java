package br.com.geniuskitchen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.geniuskitchen.dao.CardapioDAO;
import br.com.geniuskitchen.model.ItemCardapio;

@WebServlet("/criar-item-cardapio")
public class CriarItemCardapio extends HttpServlet {
	
	private CardapioDAO _dao;
	
	@Override
	public void init() throws ServletException {
		
		_dao = new CardapioDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("home/criar-item-cardapio.jsp");
		
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.err.println("\nPOST - Criar item cardapio.");
		
		String mensagem = "";		
	    String nome = req.getParameter("nome");
	    double preco = Double.parseDouble(req.getParameter("preco"));
	    String urlImagem = req.getParameter("URLImagem");
	    String tipo = req.getParameter("tipo");
	    String palavrasChave = req.getParameter("palavrasChave");
	    
	    ItemCardapio item = new ItemCardapio(nome, tipo, preco, urlImagem, palavrasChave);
	    
	    boolean resultado = _dao.inserirItem(item);
	    
	    if(resultado) mensagem = String.format("O item %s, foi inserido com sucesso. Seu código é: %s", item.getNome(), item.getCodigoItemCardapio());
	    else mensagem = String.format("Não foi possível inserir o item %s, tente novamente mais tarde.<br>Se o problema persistir, contate um administrador do sistema!<br>", item.getNome());
	    
		RequestDispatcher dispatcher = req.getRequestDispatcher("home/criar-item-cardapio.jsp");
		req.setAttribute("mensagem", mensagem);
		dispatcher.forward(req, resp);
	}
}
