package br.com.geniuskitchen.dao;

import br.com.geniuskitchen.model.ItensPedidos;
import br.com.geniuskitchen.model.Pedido;
import br.com.geniuskitchen.dao.ItensPedidosDAO;


import java.sql.*;
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


    public List<Pedido> exibirPendente() {

        String SQL = "SELECT PK_PEDIDO, MESA, NOME_CLIENTE FROM PEDIDOS WHERE andamento = 'pendente'";


        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pedido> pedidos = new ArrayList<>();


            while (resultSet.next()) {

                String id =  resultSet.getString("pk_pedido");
                String mesa = resultSet.getString("mesa");
                String nome =  resultSet.getString("nome_cliente");

                ItensPedidosDAO itens = new ItensPedidosDAO();
                ItensPedidos item = itens.buscarItens(id);

                Pedido pedido = new Pedido(Integer.parseInt(id),Integer.parseInt(mesa), nome, item);

                System.out.println(mesa);
                pedidos.add(pedido);

            }

            System.out.println("select realizado com sucesso, pedidos encontrados.");

            connection.close();

            return pedidos;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();

        }

    }


    public void updatePendente(Pedido pedido){
        String SQL = "UPDATE PEDIDOS SET ANDAMENTO = ? WHERE pk_pedido = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, "preparado");
            preparedStatement.setString(2, Integer.toString(pedido.getId()));
            preparedStatement.execute();

            System.out.println("success in update status");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

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
