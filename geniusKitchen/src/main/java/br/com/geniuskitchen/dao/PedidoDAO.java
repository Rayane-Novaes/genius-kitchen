package br.com.geniuskitchen.dao;

import br.com.geniuskitchen.model.Pedido;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoDAO {

    public void createPedido(Pedido pedido) {

        String SQL = "INSERT INTO PEDIDOS (NAME) VALUES (?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, pedido.getCliente());
            preparedStatement.execute();

            System.out.println("success in insert pedido");

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

            System.out.println("success in update car");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }
    }
}
