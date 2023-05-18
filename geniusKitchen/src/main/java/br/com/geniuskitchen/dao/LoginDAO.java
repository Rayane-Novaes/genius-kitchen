package br.com.geniuskitchen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.geniuskitchen.model.Funcionario;

public class LoginDAO {
	
	private Connection _connection = null;
	
	public LoginDAO() {
		
		
		
	}
	
	public boolean InserirFuncionario(Funcionario funcionario) throws SQLException {
		boolean status = false;
		String sql = "INSERT INTO [Funcionario] (CodigoFuncionario, Nome, Email, Senha, Tipo) VALUES (?, ?, ?, ?, ?);";
		
		PreparedStatement stmt = _connection.prepareStatement(sql);
		
		System.out.println("Código: " + funcionario.getCodigoFuncionario() + "\nNome: " + funcionario.getNome() + "\nE-mail: " + funcionario.getEmail()
		+ "\nSenha: " + funcionario.getSenha());
		
        stmt.setString(1, funcionario.getCodigoFuncionario());
        stmt.setString(2, funcionario.getNome());
        stmt.setString(3, funcionario.getEmail());
        stmt.setString(4, funcionario.getSenha());
        
        
        int linhasAfetadas = stmt.executeUpdate();
        
        if(linhasAfetadas > 0) status = true;
        
		return status;
	}

}