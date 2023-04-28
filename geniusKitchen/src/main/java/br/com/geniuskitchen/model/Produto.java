package br.com.geniuskitchen.model;

public class Produto {



    private String id;
    private String nome;
    private String categoria;
    private double preco;



    public Produto(String nome, String categoria, double preco) {

        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public Produto(String id, String nome, String categoria, double preco) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }


    public Produto(){};

    public Produto(String nome){
        this.nome = nome;
    }



    public String getCod_Produto() {
        return id;
    }
    public void setCod_Produto(String cod_Produto) {
        id = cod_Produto;
    }


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

    @Override
    public String toString() {
        return "Produto{" +
                "Cod_Produto='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", preco=" + preco +
                '}';
    }

}
