package br.com.geniuskitchen.dao;

import br.com.geniuskitchen.model.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class ProdutoDAO {
    public boolean createProduto(Produto produto){
        System.out.println("Preço: " + produto.getPreco());

        boolean status = false;

        String sql = "INSERT INTO Produtos (Nome, Categoria, Valor) VALUES (?, ?, ?);";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");

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
