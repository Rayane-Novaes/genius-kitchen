package br.com.geniuskitchen.dao;

import br.com.geniuskitchen.model.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public boolean createProduto(Produto produto){
        boolean status = false;
        String sql = "INSERT INTO Produtos (Cod_Produto, Nome, Categoria, Preco) VALUES (?, ?, ?, ?);";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getCod_Produto());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(3, produto.getCategoria());
            preparedStatement.setDouble(4, produto.getPreco());

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
        String sql = "SELECT * FROM Produtos;";
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
             while (result.next()) {

                Produto produto = new Produto(result.getString("Cod_Produto"),
                        result.getString("Nome"), result.getString("Categoria"),
                        result.getDouble("Preco"));
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


}
