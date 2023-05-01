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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String produtoId=req.getParameter("id");
		String produtoNome = req.getParameter("nome-produto");
		double produtoPreco = StringParaDoubleComReplaceVirgula(req.getParameter("valor-produto"));

		String produtoCategoria=req.getParameter("categoria-produto");

		ProdutoDAO objProdutoDAO = new ProdutoDAO();
		Produto objProduto = new Produto(produtoId, produtoNome, produtoCategoria, produtoPreco);
		
		if(produtoId.isBlank()) {
			objProdutoDAO.createProduto(objProduto);
		} else {
			objProdutoDAO.updateProduto(objProduto);
		}
		resp.sendRedirect("/listarProdutos");
		
		//httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, resp);
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	private double StringParaDoubleComReplaceVirgula(String preco){
		preco = preco.replace(',', '.');
		return Double.parseDouble(preco);
	}

}
