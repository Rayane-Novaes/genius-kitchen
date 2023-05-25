package br.com.geniuskitchen.dao;

import br.com.geniuskitchen.model.ItensPedidos;
import br.com.geniuskitchen.model.Pedido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ItensPedidosDAO {

    public void createItensPedidos( ItensPedidos itensPedidos) {

        String SQL = "INSERT INTO ITENS_PEDIDOS (QUANTIDADE,FK_PRODUTO, FK_PEDIDO, OBSERVACAO) VALUES (?, ?, ?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, itensPedidos.getQuantidade());
            preparedStatement.setInt(2, Integer.parseInt(itensPedidos.getProduto().getId()));
            preparedStatement.setInt(3, itensPedidos.getPedido().getId());
            preparedStatement.setString(4, itensPedidos.getObservacao());

            preparedStatement.execute();

            System.out.println("success in insert ITENS_PEDIDOS");

            connection.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("fail in database connection");

        }

    }
}
