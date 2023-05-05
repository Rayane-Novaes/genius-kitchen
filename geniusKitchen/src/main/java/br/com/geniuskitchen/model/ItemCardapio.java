package br.com.geniuskitchen.model;

import java.util.UUID;

import br.com.geniuskitchen.enums.TipoItemCardapio;

public class ItemCardapio {

	private String codigoItemCardapio;
	private String nome;
	private double preco;
	private String urlImage;
	private String palavraChavesBusca;
	TipoItemCardapio tipo;

	public ItemCardapio(String nome, double preco, String urlImage, String palavraChavesBusca, TipoItemCardapio tipo) {
		this.codigoItemCardapio = UUID.randomUUID().toString();
		this.nome = nome;
		this.preco = preco;
		this.urlImage = urlImage;
		this.palavraChavesBusca = palavraChavesBusca;
		this.tipo = tipo;
	}

	public ItemCardapio() {
		this.codigoItemCardapio = UUID.randomUUID().toString();
	}

	public String getCodigoItemCardapio() {
		return codigoItemCardapio;
	}

	public void setCodigoItemCardapio(String codigoItemCardapio) {
		this.codigoItemCardapio = codigoItemCardapio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getPalavraChavesBusca() {
		return palavraChavesBusca;
	}

	public void setPalavraChavesBusca(String palavraChavesBusca) {
		this.palavraChavesBusca = palavraChavesBusca;
	}

	public TipoItemCardapio getTipo() {
		return tipo;
	}

	public void setTipo(TipoItemCardapio tipo) {
		this.tipo = tipo;
	}

}
