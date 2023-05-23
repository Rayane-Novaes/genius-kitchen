package br.com.geniuskitchen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.geniuskitchen.dao.connection.DatabaseConnection;
import br.com.geniuskitchen.model.ItemCardapio;

/**
 * Classe responsável pela interação com o banco de dados em relação aos itens do cardápio.
 * @author José Victor Vieira
 * @version 1.0
 * @since 05/05/2023
 */
public class CardapioDAO {

    private Connection _connection = null;

    /**
     * Cria uma nova instância da classe CardapioDAO e obtém a conexão com o banco de dados.
     */
    public CardapioDAO() {
        _connection = DatabaseConnection.getInstance().getConnection();
    }

    /**
     * Busca todos os items do cardápio no banco de dados.
     *
     * @return uma lista contendo todos os items do cardápio.
     */
    public List<ItemCardapio> buscarItemsDoCardapio() {

        ArrayList<ItemCardapio> itemsCardapio = new ArrayList<ItemCardapio>();
        String sql = "SELECT codigo_item_cardapio, nome, tipo, preco, url_imagem, palavras_chave FROM item_cardapio;";

        try (PreparedStatement stmt = _connection.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {

                String codigoItem = resultSet.getString("codigo_item_cardapio");
                String nome = resultSet.getString("nome");
                String tipo = resultSet.getString("tipo");
                double preco = resultSet.getDouble("preco");
                String URLIMagem = resultSet.getString("url_imagem");
                String palavrasChavesBusca = resultSet.getString("palavras_chave");

                ItemCardapio item = new ItemCardapio(codigoItem, nome, tipo, preco, URLIMagem, palavrasChavesBusca);
                itemsCardapio.add(item);
            }

        } catch (Exception ex) {

            System.err.println(ex.getMessage());
        }

        return itemsCardapio;
    }

    /**
     * Insere um novo item no cardápio.
     *
     * @param item o item do cardápio a ser inserido.
     * @return true se a inserção foi bem-sucedida, false caso contrário.
     * 
     */
    public boolean inserirItem(ItemCardapio item) {

        String sql = "INSERT INTO item_cardapio (codigo_item_cardapio, nome, tipo, preco, url_imagem, palavras_chave) VALUES (?, ?, ?, ?, ?, ?);";
        String codigoItemCardapio = item.getCodigoItemCardapio();
        String urlImagem = item.getURLImagem();
        String nome = item.getNome();
        String tipo = item.getTipo().toString();
        String palavrasChave = item.getPalavraChavesBusca();
        double preco = item.getPreco();
        var status = false;

        try (PreparedStatement stmt = _connection.prepareStatement(sql)) {

            stmt.setString(1, codigoItemCardapio);
            stmt.setString(2, nome);
            stmt.setString(3, tipo);
            stmt.setDouble(4, preco);
            stmt.setString(5, urlImagem);
            stmt.setString(6, palavrasChave);
            
            status = stmt.executeUpdate() > 0;

        } catch (Exception ex) {

            System.err.println("\nITEM SALVO: " + status + "\n" + ex.getMessage());
            return status;
        }

        System.err.println("\nITEM SALVO: " + status);

        return status;
    }
}