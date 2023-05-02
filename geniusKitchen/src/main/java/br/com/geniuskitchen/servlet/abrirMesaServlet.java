package br.com.geniuskitchen.servlet;

import br.com.geniuskitchen.dao.PedidoDAO;
import br.com.geniuskitchen.dao.ProdutoDAO;
import br.com.geniuskitchen.model.ItensPedidos;
import br.com.geniuskitchen.model.Pedido;
import br.com.geniuskitchen.model.Produto;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/nova-mesa")
public class abrirMesaServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Cadastrando novo pedido");

        String nomeCliente = request.getParameter("cliente");
        int mesa = Integer.parseInt(request.getParameter("mesa"));
        String produto = request.getParameter("produto");
        String quantidade = request.getParameter("qtd");

        Pedido pedido = new Pedido(mesa, nomeCliente);
        Produto p = new Produto(produto);

        ItensPedidos itensPedidos = new ItensPedidos(pedido, p, Integer.parseInt(quantidade));

        new PedidoDAO().createPedido(pedido, itensPedidos);
//        new ProdutoDAO().createProduto(p);
    }
}
