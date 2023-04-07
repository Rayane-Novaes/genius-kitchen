package br.com.geniuskitchen.servlet.model;

public class Produto {

    //Produto
    private String nome, categoria;
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
