package br.com.geniuskitchen.model;

import java.util.UUID;

import br.com.geniuskitchen.model.enums.Tipo;

public class Funcionario {
	
	private String codigoFuncionario;
	private String nome;
	private String email ;
	private String senha;
	public Tipo tipo;

	public static Funcionario Create(String nome, String email, String senha, Tipo tipo) {
		
		return new Funcionario() {{
			this.setCodigoFuncionario(UUID.randomUUID().toString());
			this.setNome(nome);
			this.setEmail(email);
			this.setSenha(senha);
			this.tipo = tipo;
		}};
	}
	
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
}


