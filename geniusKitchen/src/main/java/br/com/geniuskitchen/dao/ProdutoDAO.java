package br.com.geniuskitchen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.geniuskitchen.model.Produto;

public class ProdutoDAO {

    public boolean createProduto(Produto produto) {
        boolean status = false;
        String sql = "INSERT INTO Produtos (nome, categoria, valor) VALUES (?, ?, ?);";	

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

//            preparedStatement.setString(1, produto.getId());
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getCategoria());
            preparedStatement.setDouble(3, produto.getValor());

            status = preparedStatement.execute();

            connection.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            return status;
        }
    }
    public ArrayList<Produto> buscarProdutos() {
        boolean status = false;
        String sql = "SELECT * FROM Produtos";
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
             while (result.next()) {

                Produto produto = new Produto(result.getString("PK_PRODUTO"),
                        result.getString("NOME"), result.getString("CATEGORIA"),
                        result.getDouble("VALOR"));
                System.out.println(produto);
                produtos.add(produto);
             }

             result.close();
             preparedStatement.close();
             connection.close();


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return produtos;
    }

    public void updateProduto(Produto produto) {
    	String SQL = "UPDATE PRODUTOS SET nome = ?, valor=?, categoria=? where PK_PRODUTO = ?";
        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setDouble(2, produto.getValor());
            
            preparedStatement.setString(3, produto.getCategoria());
            preparedStatement.setString(4, produto.getId());

            preparedStatement.execute();

            System.out.println("success in update product");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }


    }

    public List<Produto> ListarProdutos() {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
        String sql = "SELECT * FROM Produtos";
        List<Produto> listaProdutos = new ArrayList<>();

        // Estabelecer a conexão com o banco de dados
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            System.out.println("Conexão com banco feita com sucesso!");

            while (result.next()) {

                Produto produto = new Produto(result.getString("PK_PRODUTO"),
                        result.getString("NOME"), result.getString("CATEGORIA"),
                        result.getDouble("VALOR"));

                listaProdutos.add(produto);

                //Populando ArrayList
                System.out.println(listaProdutos);

            }
            System.out.println("select realizado com sucessso no banco, lista de produtos encontrada");

            result.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return listaProdutos;
    }
}

