package br.com.geniuskitchen.model;

public class Produto {

    //Produto
    private String nome;

    public Produto(){

    }
    public Produto(String nome, String categoria, String preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = Double.parseDouble(preco);
    }

    private String categoria;
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double valor) {
        this.preco = valor;
    }
}
