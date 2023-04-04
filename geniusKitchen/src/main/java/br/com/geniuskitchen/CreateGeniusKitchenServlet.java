package br.com.geniuskitchen;

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
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse resp) throws ServletException, IOException {
		String nomeProduto=httpServletRequest.getParameter("nome-produto");
				String precoProduto=httpServletRequest.getParameter("preco-produto");
		String categoriaProduto=httpServletRequest.getParameter("categoria-produto");
		
		System.out.println(nomeProduto);
		System.out.println(precoProduto);
		System.out.println(categoriaProduto);
		
		//Produto objProduto = new Produto();
		//objProduto.setNome(nomeProduto);
		//objProduto.setPreco(precoProduto);
		//objProduto.setCategoria(categoriaProduto);

		//new ProdutoDao().createProduto(objProduto);
		
		
		
		
		
		httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, resp);
	}		
}
