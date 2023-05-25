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

    public void createPedido(Pedido pedido) {

        String SQL = "INSERT INTO PEDIDOS (mesa, nome_cliente, andamento) VALUES (?, ?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, pedido.getMesa());
            preparedStatement.setString(2, pedido.getCliente());
            preparedStatement.setString(3, "pendente");

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

                String mesa = resultSet.getString("mesa");
                String id =  resultSet.getString("pk_pedido");
                String nome =  resultSet.getString("nome_cliente");

                Pedido pedido = new Pedido(Integer.parseInt(mesa), Integer.parseInt(id), nome);
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

            System.out.println("success in update pedido");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }
    }
    public int ultimoIDPedido (Pedido pedido){
        String SQL = "SELECT PK_PEDIDO FROM PEDIDOS ORDER BY PK_PEDIDO DESC LIMIT 1";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                int id = resultSet.getInt("PK_PEDIDO");
                return id;
            }

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }
        return -1;
    }
}
