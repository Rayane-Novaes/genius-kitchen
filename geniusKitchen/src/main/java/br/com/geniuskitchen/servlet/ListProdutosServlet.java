package br.com.geniuskitchen.servlet;

import br.com.geniuskitchen.dao.ProdutoDAO;
import br.com.geniuskitchen.model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/abrirMesa")
public class ListProdutosServlet extends HttpServlet {
    ProdutoDAO dataProduto;
    public void init() throws ServletException {
        dataProduto=new ProdutoDAO();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> produtos = new ProdutoDAO().buscarProdutos();

        req.setAttribute("produtos", produtos);
        req.getRequestDispatcher("/garcom/abrirMesa.jsp").forward(req, resp);

    }
}
