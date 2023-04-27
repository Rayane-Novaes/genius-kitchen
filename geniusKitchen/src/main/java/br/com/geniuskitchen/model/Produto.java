package br.com.geniuskitchen.model;

public class Produto {



    private String Cod_Produto;
    private String nome;
    private String categoria;
    private double preco;



    public Produto(String cod_Produto, String nome, String categoria, double preco) {
        this.Cod_Produto = cod_Produto;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }


    public Produto(){};

    public Produto(String nome){
        this.nome = nome;
    }

    public Produto(String nomeProduto, String categoriaProduto, double precoProduto) {
    }

    public String getCod_Produto() {
        return Cod_Produto;
    }
    public void setCod_Produto(String cod_Produto) {
        Cod_Produto = cod_Produto;
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
                "Cod_Produto='" + Cod_Produto + '\'' +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", preco=" + preco +
                '}';
    }

}
