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

        String SQL = "INSERT INTO pedido (NAME) VALUES (?)";

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

        String SQL = "SELECT mesa FROM PEDIDOS WHERE andamento = 'preparado'";


        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pedido> pedidos = new ArrayList<>();


            while (resultSet.next()) {

                String mesa = resultSet.getString("mesa");

                Pedido pedido = new Pedido(Integer.parseInt(mesa));
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
}
