package br.com.geniuskitchen.model;

import br.com.geniuskitchen.model.enums.TipoItemCardapio;

public class ItemCardapio {
	
	private String nome;
	private TipoItemCardapio tipo;
	private double preco;
	private String URLImagem;
	
	
	
	public ItemCardapio(String nome, TipoItemCardapio tipo, double preco, String uRLImagem) {
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		URLImagem = uRLImagem;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo.toString().toUpperCase();
	}
	public void setTipo(TipoItemCardapio tipo) {
		this.tipo = tipo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getURLImagem() {
		return URLImagem;
	}
	public void setURLImagem(String uRLImagem) {
		URLImagem = uRLImagem;
	}
	
	

}
