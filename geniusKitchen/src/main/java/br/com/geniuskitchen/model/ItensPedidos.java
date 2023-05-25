package br.com.geniuskitchen.model;

public class ItensPedidos {

    private int id, quantidade;

    private Pedido pedido;

    private Produto produto;

    private String observacao;

<<<<<<< HEAD
    public ItensPedidos(int quantidade, Produto produto, Pedido pedido, String observacao){
=======
    public ItensPedidos(){}

    public ItensPedidos(int id, int quantidade, Produto produto, String observacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
        this.observacao = observacao;
    }


    public ItensPedidos(Pedido pedido, Produto produto, int quantidade){
>>>>>>> 96b164c19b421f9eab5dde0ea2a8aa18f7c6942e
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }
    public ItensPedidos(int quantidade,Produto produto){
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

//    public int getProdutoID(){
//        int id = produto.getId();
//    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
