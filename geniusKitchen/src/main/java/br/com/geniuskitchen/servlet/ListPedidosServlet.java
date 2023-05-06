package br.com.geniuskitchen.servlet;


import br.com.geniuskitchen.dao.PedidoDAO;
import br.com.geniuskitchen.model.Pedido;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/exibir-pendente")
public class ListPedidosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Pedido> pendente = new PedidoDAO().exibirPendente();

        req.setAttribute("pendente", pendente);

        req.getRequestDispatcher("cozinheiro/tela03adminCozinheiroPedidos.jsp").forward(req, resp);

    }
}
