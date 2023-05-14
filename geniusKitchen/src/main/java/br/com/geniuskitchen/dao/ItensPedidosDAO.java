package br.com.geniuskitchen.dao;

import br.com.geniuskitchen.model.ItensPedidos;
import br.com.geniuskitchen.model.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ItensPedidosDAO {
    public ItensPedidos buscarItens(String pkPedido) {

        String SQL = "SELECT * FROM ITENS_PEDIDOS WHERE FK_PEDIDO = ?;";
        ItensPedidos item = null;

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, pkPedido);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String id_itens = resultSet.getString("PK_ITENS_PEDIDOS");
                String quantidade = resultSet.getString("QUANTIDADE");
                String idProduto = resultSet.getString("FK_PRODUTO");
                String observacao = resultSet.getString("OBSERVACAO");
                Produto produto = buscarProduto(idProduto);

                item = new ItensPedidos(Integer.parseInt(id_itens), Integer.parseInt(quantidade), produto, observacao);
            }

            System.out.println("Sucesso ao buscar dados");
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection");
        }
        return item;
    }


    public Produto buscarProduto(String idProduto){

        String SQL = "SELECT * FROM PRODUTOS WHERE PK_PRODUTO = ?;";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, idProduto);
            ResultSet resultSet = preparedStatement.executeQuery();

            Produto produto = null;
            while (resultSet.next()) {
                String id = resultSet.getString("PK_PRODUTO");
                String nomeProduto = resultSet.getString("NOME");
                String valor = resultSet.getString("VALOR");
                String categoria = resultSet.getString("CATEGORIA");

                produto = new Produto(id, nomeProduto, categoria, Double.parseDouble(valor));
            }
            System.out.println("Sucesso ao buscar dados");

            connection.close();

            return produto;

        } catch (Exception e) {

            System.out.println("fail in database connection");
            return null;

        }
    }
}
