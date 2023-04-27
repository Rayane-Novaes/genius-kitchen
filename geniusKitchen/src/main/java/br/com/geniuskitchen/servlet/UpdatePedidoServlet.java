package br.com.geniuskitchen.servlet;
import br.com.geniuskitchen.dao.PedidoDAO;
import br.com.geniuskitchen.model.Pedido;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

///teste



@WebServlet("/update-pedido-concluido")
public class UpdatePedidoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String pedidoId = req.getParameter("id");
        PedidoDAO pedidoDao = new PedidoDAO();
        Pedido pedido = new Pedido(Integer.parseInt(pedidoId));
        pedidoDao.updatePedido(pedido);
        resp.sendRedirect("/find-mesa");







    }

}
