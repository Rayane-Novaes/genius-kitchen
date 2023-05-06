package br.com.geniuskitchen.model;

import java.util.UUID;

import br.com.geniuskitchen.model.enums.TipoItemCardapio;

/**
 * Representa um item do cardápio.
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
	 * @param uRLImagem A URL da imagem do item do cardápio.
	 */
	public ItemCardapio(String nome, String tipo, double preco, String uRLImagem, String palavrasChaveBusca) {
		this.codigoItemCardapio = UUID.randomUUID().toString().substring(0, 18);
		this.nome = nome;
		this.tipo = TipoItemCardapio.valueOf(tipo);
		this.preco = preco;
		this.URLImagem = uRLImagem;
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
	 * @param uRLImagem          A URL da imagem do item do cardápio.
	 * @param palavrasChavesBusca 
	 */
	public ItemCardapio(String codigoItemCardapio, String nome, String tipo, double preco, String uRLImagem, String palavrasChavesBusca) {
		this.codigoItemCardapio = codigoItemCardapio;
		this.nome = nome;
		this.tipo = TipoItemCardapio.valueOf(tipo);
		this.preco = preco;
		this.URLImagem = uRLImagem;
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

	public String getPalavrasChavesBusca() {
		return palavrasChavesBusca;
	}

	public void setPalavrasChavesBusca(String palavrasChavesBusca) {
		this.palavrasChavesBusca = palavrasChavesBusca;
	}
}
