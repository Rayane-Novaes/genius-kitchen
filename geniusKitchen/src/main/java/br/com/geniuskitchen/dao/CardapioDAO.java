package br.com.geniuskitchen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.geniuskitchen.dao.dbconnection.DatabaseConnection;
import br.com.geniuskitchen.model.ItemCardapio;
import br.com.geniuskitchen.model.enums.TipoItemCardapio;

public class CardapioDAO {
	private Connection _connection = null;

	public CardapioDAO() {

		_connection = DatabaseConnection.getInstance().getConnection();

	}

	public List<ItemCardapio> buscarItemsDoCardapio() throws SQLException {

		ArrayList<ItemCardapio> itemsCardapio = new ArrayList<ItemCardapio>();
		String sql = "SELECT Nome, Tipo, Preco, URLImagem FROM ItemCardapio;";

		try (PreparedStatement stmt = _connection.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {

			while (resultSet.next()) {

				String nome = resultSet.getString("Nome");
				
				String tipoRS = resultSet.getString("Tipo");
				TipoItemCardapio tipo = TipoItemCardapio.valueOf(tipoRS.toUpperCase());
				
				double preco = resultSet.getDouble("Preco");
				String URLIMagem = resultSet.getString("URLImagem");


				ItemCardapio item = new ItemCardapio(nome, tipo, preco, URLIMagem);
				itemsCardapio.add(item);
			}
		}

		return itemsCardapio;
	}
}
