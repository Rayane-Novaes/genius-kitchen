package br.com.geniuskitchen.servlet;

import br.com.geniuskitchen.dao.PedidoDAO;
import br.com.geniuskitchen.model.Pedido;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-pedido-preparado")
public class UpdatePendenteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String pedidoId = req.getParameter("id");
        PedidoDAO pedidoDao = new PedidoDAO();
        Pedido pedido = new Pedido(Integer.parseInt(pedidoId));
        pedidoDao.updatePendente(pedido);
        resp.sendRedirect("/exibir-pendente");

    }

}
