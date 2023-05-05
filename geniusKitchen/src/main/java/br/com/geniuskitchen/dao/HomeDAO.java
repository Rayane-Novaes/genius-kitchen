package br.com.geniuskitchen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.geniuskitchen.dao.connection.DatabaseConnection;
import br.com.geniuskitchen.enums.TipoItemCardapio;
import br.com.geniuskitchen.model.ItemCardapio;

public class HomeDAO {

	private DatabaseConnection databaseConnection;

	public HomeDAO() {
		this.databaseConnection = DatabaseConnection.getInstance();
	}

	public boolean InserirItemCardapio(ItemCardapio item) {

		String sql = "INSERT INTO Cardapio (CodigoItemCardapio, Nome, Preco, UrlImage, PalavrasChave, Tipo) VALUES (?, ?, ?, ?, ?, ?);";

		return false;
	}

	public ArrayList<ItemCardapio> buscarItemsDoCardapio() {

		String sql = "SELECT CodigoItemCardapio, Nome, Preco, UrlImage, PalavrasChave, Tipo FROM Cardapio;";
		ArrayList<ItemCardapio> items = new ArrayList<ItemCardapio>();
		var connection = databaseConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {

			stmt = connection.prepareStatement(sql);
			result = stmt.executeQuery();

			while (result.next()) {
				ItemCardapio item = new ItemCardapio();

				item.setCodigoItemCardapio(result.getString("CodigoItemCardapio"));
				item.setNome(result.getString("Nome"));
				item.setPreco(result.getDouble("Preco"));
				item.setUrlImage(result.getString("UrlImage"));
				item.setPalavraChavesBusca(result.getString("PalavrasChave"));
				item.setTipo(TipoItemCardapio.valueOf(result.getString("Tipo")));
				items.add(item);
			}

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

		return items;
	}

}
