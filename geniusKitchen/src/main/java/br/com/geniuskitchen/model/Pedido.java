package br.com.geniuskitchen.model;

public class Pedido {
    private int id;
    private int mesa;
    private String andamento;

    private String cliente;

    private ItensPedidos itensPedidos;


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

    public Pedido(int id, int mesa, String nome, ItensPedidos itensPedidos) {
        this.id = id;
        this.mesa = mesa;
        this.cliente = nome;
        this.itensPedidos = itensPedidos;
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

    public ItensPedidos getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(ItensPedidos itensPedidos) {
        this.itensPedidos = itensPedidos;
    }
}
