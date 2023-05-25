package br.com.geniuskitchen.dao;

import br.com.geniuskitchen.dao.connection.DatabaseConnection;
import br.com.geniuskitchen.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

	private Connection _connection = null;

	public UsuarioDAO() {
		_connection = DatabaseConnection.getInstance().getConnection();
	}

	public Usuario buscarUsuario(Usuario usuarioIn) {

		String sql = "SELECT Username, Password, Tipo FROM Usuario WHERE Username = ? AND Password = ?;";

		Usuario usuario = new Usuario();

		try (PreparedStatement stmt = _connection.prepareStatement(sql)) {

			stmt.setString(1, usuarioIn.getUsername());
			stmt.setString(2, usuarioIn.getPassword());
			
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {

				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String tipo = resultSet.getString("tipo");
				usuario.setUsername(username);
				usuario.setPassword(password);
				usuario.setTipo(tipo);
//				System.out.println("\nUSERNAME: " + username + "\nPASSWORD: " + password + "\nTIPO: " + tipo);
			}			
		} catch (Exception ex) { 
			
			System.err.println(ex.getMessage());
		}		
		return usuario;
	}

}
