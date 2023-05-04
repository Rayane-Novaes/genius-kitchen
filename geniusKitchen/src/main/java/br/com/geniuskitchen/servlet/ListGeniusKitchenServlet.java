package br.com.geniuskitchen.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.geniuskitchen.dao.ProdutoDAO;
import br.com.geniuskitchen.model.Produto;


@WebServlet("/listarProdutos")
public class ListGeniusKitchenServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> produtos = new ProdutoDAO().buscarProdutos();
        
        req.setAttribute("produtos", produtos);
        req.getRequestDispatcher("/cozinheiro/tela04CadastroDeProduto.jsp").forward(req, resp);
        
    }

}
