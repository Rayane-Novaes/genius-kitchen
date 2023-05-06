package br.com.geniuskitchen.model;

public class Produto {



    private String id;
    private String nome;
    private String categoria;
    private double valor;



    public Produto(String nome, String categoria, double valor) {

        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
    }

    public Produto(String id, String nome, String categoria, double valor) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
    }


    public Produto(){};

    public Produto(String nome){
        this.nome = nome;
    }



    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Cod_Produto='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valor=" + valor +
                '}';
    }

}
