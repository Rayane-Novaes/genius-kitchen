package br.com.geniuskitchen.model;

import java.util.UUID;

import br.com.geniuskitchen.enums.TipoItemCardapio;

/**
 * Representa um item do cardápio.
 * @author José Victor Vieira
 * @version 1.0
 * @since 05/05/2023
 */
public class ItemCardapio {

	private String codigoItemCardapio;
	private String nome;
	private TipoItemCardapio tipo;
	private double preco;
	private String URLImagem;
	private String palavrasChavesBusca;

	/**
	 * Cria um novo item do cardápio com um código gerado aleatoriamente. Usar na
	 * criação de um novo item.
	 *
	 * @param nome      O nome do item do cardápio.
	 * @param tipo      O tipo do item do cardápio.
	 * @param preco     O preço do item do cardápio.
	 * @param URLImagemmmmmmm A URL da imagem do item do cardápio.
	 */
	public ItemCardapio(String nome, String tipo, double preco, String URLImagemmmmmmm, String palavrasChaveBusca) {
		this.codigoItemCardapio = UUID.randomUUID().toString().substring(0, 18);
		this.nome = nome;
		this.tipo = TipoItemCardapio.valueOf(tipo);
		this.preco = preco;
		this.URLImagem = URLImagemmmmmmm;
		this.palavrasChavesBusca = palavrasChaveBusca;
	}

	/**
	 * Cria um novo item do cardápio com um código específico. Usar na montagem de
	 * um item.
	 *
	 * @param codigoItemCardapio O código do item do cardápio.
	 * @param nome               O nome do item do cardápio.
	 * @param tipo               O tipo do item do cardápio.
	 * @param preco              O preço do item do cardápio.
	 * @param URLImagemmmmmmm          A URL da imagem do item do cardápio.
	 * @param palavrasChavesBusca 
	 */
	public ItemCardapio(String codigoItemCardapio, String nome, String tipo, double preco, String URLImagem, String palavrasChavesBusca) {
		this.codigoItemCardapio = codigoItemCardapio;
		this.nome = nome;
		this.tipo = TipoItemCardapio.valueOf(tipo);
		this.preco = preco;
		this.URLImagem = URLImagem;
		this.palavrasChavesBusca = palavrasChavesBusca;
	}

	public String getCodigoItemCardapio() {
		return codigoItemCardapio;
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


	public String getURLImagem() {
		return URLImagem;
	}

	public void setURLImagemmmmmm(String URLImagem) {
		this.URLImagem = URLImagem;
	}

	public String getPalavraChavesBusca() {
		return palavrasChavesBusca;
	}

	public void setPalavraChavesBusca(String palavraChavesBusca) {
		this.palavrasChavesBusca = palavraChavesBusca;
	}

	public String getTipo() {
		return tipo.toString();
	}

}
