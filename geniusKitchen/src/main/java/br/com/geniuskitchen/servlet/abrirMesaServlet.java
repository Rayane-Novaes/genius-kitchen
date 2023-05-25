package br.com.geniuskitchen.servlet;

import br.com.geniuskitchen.dao.ItensPedidosDAO;
import br.com.geniuskitchen.dao.PedidoDAO;
import br.com.geniuskitchen.dao.ProdutoDAO;
import br.com.geniuskitchen.model.ItensPedidos;
import br.com.geniuskitchen.model.Pedido;
import br.com.geniuskitchen.model.Produto;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/nova-mesa")
public class abrirMesaServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Cadastrando novo pedido");

        String nomeCliente = request.getParameter("cliente");
        int mesa = Integer.parseInt(request.getParameter("mesa"));
        int produtoId = Integer.parseInt(request.getParameter("produto"));
        String quantidade = request.getParameter("qtd");
        String observacao = request.getParameter("observacao");

        Pedido pedido = new Pedido(mesa, nomeCliente);
        new PedidoDAO().createPedido(pedido);
        int idPedido = new PedidoDAO().ultimoIDPedido(pedido);
        pedido.setId(idPedido);

        Produto produto = new Produto(produtoId);

        ItensPedidos itensPedidos = new ItensPedidos(Integer.parseInt(quantidade), produto, pedido, observacao);
        new ItensPedidosDAO().createItensPedidos(itensPedidos);

        response.sendRedirect("/garcom/pedidoRealizado.jsp");
    }
}
