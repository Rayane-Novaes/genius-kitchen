package br.com.geniuskitchen.servlet.dao;

import br.com.geniuskitchen.servlet.model.Produto;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProdutoDAO {
    public boolean createProduto(Produto produto){

        boolean status = false;

        String sql = "INSERT INTO [Produtos] (Nome, Categoria, Preco) VALUES (?, ?, ?);";

        try {

            Connection connection = DriverManager.getConnection("StringConnection");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getCategoria());
            preparedStatement.setDouble(3, produto.getPreco());

            status = preparedStatement.execute();

            connection.close();

        } catch (Exception ex) {
                System.out.println(ex.getMessage());
        } finally {
            return status;
        }

    }

}