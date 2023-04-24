package br.com.geniuskitchen.model;

public class Pedido {
    private int id;
    private int mesa;
    private String andamento;

    private String cliente;


    public Pedido(){}




    public Pedido(int mesa, String andamento, String cliente) {
        this.mesa = mesa;
        this.andamento = andamento;
        this.cliente = cliente;
    }

    public Pedido(int mesa) {
        this.mesa = mesa;
    }

    public Pedido(int id, int mesa, String andamento, String cliente) {
        this.id = id;
        this.mesa = mesa;
        this.andamento = andamento;
        this.cliente = cliente;
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
}
