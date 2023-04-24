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

@WebServlet("/find-mesa")
public class ListMesaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Pedido> pedidos = new PedidoDAO().findMesa();

        req.setAttribute("pedidos", pedidos);

        req.getRequestDispatcher("concluidos.jsp").forward(req, resp);


    }
}
