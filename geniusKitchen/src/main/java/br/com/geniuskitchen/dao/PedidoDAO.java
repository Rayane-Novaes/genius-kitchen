package br.com.geniuskitchen.dao;

import br.com.geniuskitchen.model.ItensPedidos;
import br.com.geniuskitchen.model.Pedido;
import br.com.geniuskitchen.model.Produto;


import javax.servlet.ServletOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoDAO {

    public void createPedido(Pedido pedido, ItensPedidos itensPedidos) {

//        String SQL = "INSERT INTO PEDIDOS (mesa, nome_cliente) VALUES (?, ?)";
        String SQL2 = "INSERT INTO ITENS_PEDIDOS (fk_produto, quantidade) VALUES (?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

//            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//
//            preparedStatement.setInt(1, pedido.getMesa());
//            preparedStatement.setString(2, pedido.getCliente());
//
//            preparedStatement.execute();
//
//            System.out.println("success in insert pedido");

            PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2);
//            preparedStatement2.setInt(1, Integer.parseInt(String.valueOf(itensPedidos.getProduto());
            preparedStatement2.setInt(1,itensPedidos.getId());
            preparedStatement2.setInt(2, itensPedidos.getQuantidade());

            preparedStatement2.execute();

            System.out.println("success in insert itens_pedidos");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }
    public List<Pedido> findMesa() {

        String SQL = "SELECT pk_pedido, mesa FROM PEDIDOS WHERE andamento = 'preparado'";


        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pedido> pedidos = new ArrayList<>();


            while (resultSet.next()) {

                String mesa = resultSet.getString("mesa");
                String id =  resultSet.getString("pk_pedido");

                Pedido pedido = new Pedido(Integer.parseInt(mesa), Integer.parseInt(id));
                System.out.println(mesa);
                pedidos.add(pedido);

            }

            System.out.println("success in select * mesa");

            connection.close();

            return pedidos;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();

        }

    }

    public void updatePedido(Pedido pedido){
        String SQL = "UPDATE PEDIDOS SET ANDAMENTO = ? WHERE pk_pedido = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, "concluido");
            preparedStatement.setString(2, Integer.toString(pedido.getId()));
            preparedStatement.execute();

            System.out.println("success in update pedido");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }
    }
}
