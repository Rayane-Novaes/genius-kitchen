package br.com.geniuskitchen.servlet;

import br.com.geniuskitchen.dao.ProdutoDAO;
import br.com.geniuskitchen.model.Produto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastrar-produto")
public class CreateGeniusKitchenServlet extends HttpServlet{
	/**
	 * 
	 */

	@Override
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse resp) throws ServletException, IOException {

		String nomeProduto=httpServletRequest.getParameter("nome-produto");

		String precoProduto=httpServletRequest.getParameter("preco-produto");

		String categoriaProduto=httpServletRequest.getParameter("categoria-produto");

		
		Produto produto = new Produto(nomeProduto, categoriaProduto, precoProduto);

		new ProdutoDAO().createProduto(produto);
		
		httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
