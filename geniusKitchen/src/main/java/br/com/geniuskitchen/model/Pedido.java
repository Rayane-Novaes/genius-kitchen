package br.com.geniuskitchen.model;

public class Pedido {
    private int id;
    private int mesa;
    private String andamento;

    private String cliente;
    private int quantidade;
    private String observacao;
    private String comida;

    public Pedido(){}


    public Pedido(int mesa, int id, String cliente){
        this.mesa = mesa;
        this.cliente = cliente;
        this.id = id;
    }

    public Pedido(int mesa, String andamento, String cliente, int id) {
        this.mesa = mesa;
        this.andamento = andamento;
        this.cliente = cliente;
        this.id = id;
    }

    public Pedido(int mesa, int id) {
        this.mesa = mesa;
        this.id = id;
    }

    public Pedido(int id) {
        this.id = id;
    }

    public Pedido(int id, int mesa, String andamento, String cliente) {
        this.id = id;
        this.mesa = mesa;
        this.andamento = andamento;
        this.cliente = cliente;
    }

    public Pedido(int id, int mesa, String nome, String comida, int quantidade, String observacao) {
        this.id = id;
        this.mesa = mesa;
        this.cliente = nome;
        this.comida = comida;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getAndamento() {
        return andamento;
    }

    public void setAndamento(String andamento) {
        this.andamento = andamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }
}
