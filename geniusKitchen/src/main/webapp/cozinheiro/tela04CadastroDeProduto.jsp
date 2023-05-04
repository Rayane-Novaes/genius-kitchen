<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de produto</title>
</head>
<body>
<a href = "/listarProdutos">mostrar produtos</a>
<style><%@include file="sytle.css"%></style>

<h1>Pedidos</h1>

    <div class="cadastro">
        <form method="post" action="/cadastrar-produto">
            <div class="item">
                <div class="sub-item">
                    <div class="estrutura-texto">
                        <label class="label-form" for="nome-produto">Nome do produto</label>
                        <input type="text" name="nome-produto" id="nome" value="${param.nome}">
                    </div>

                    <div class="estrutura-texto">
                        <label for="valor-produto"> Valor do produto </label>
                        <input type="text" name="valor-produto" id="valor" value="${param.valor}">
                    </div>
                </div>

<input type="hidden" name="id" id="id" value="${param.id}">
            </div>
            <div class="item">
                <label for="categoria-produto"> Categoria do produto </label>
                <input type="text" name="categoria-produto" id="categoria" value="${param.categoria}">
            </div>

            <div class="confirmar">
                <button type=submit name="confirmar">confirmar</button>
            </div>

        </form>
    </div>

<div class="botoes-alteracoes">    
</div>


<div class="tabela">
    <table>
        <tr>
            <th> ID </th>
            <th> nome-produto </th>
            <th> valor-produto </th>
            <th> categoria-produto </th>
            <th> actions </th>
        </tr>

<c:forEach var="produto" items="${produtos}">

        <tr>
            <td>${produto.id} </td>
            <td>${produto.nome}</td>
            <td>${produto.valor}</td>
            <td>${produto.categoria}</td>
            
            <td>
            <form action="/update-produto" method="post">
                <a href="/cozinheiro/tela04CadastroDeProduto.jsp?id=${produto.id}&nome=${produto.nome}&valor=${produto.valor}&categoria=${produto.categoria} ">Update</a>
            </form>
            
            </td>
            
        </tr>
</c:forEach>
    </table>
</div>

</body>
</html>
