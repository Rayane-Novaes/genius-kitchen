<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Card�pio</title>
    <style>
        <%@include file="../css/site.css" %>
    </style>
    <style>
        <%@include file="css/home-cardapio.css" %>
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>ss
</head>

<body style="margin: 0px;">
    <div class="home-page">
        <div class="cabecalho">
            <div>
                <div class="container">
                    <div class="container-navbar-login">
                        <div class="btn-login">
                            <a href="#">Login</a>
                        </div>
                    </div>
                    <div class="container-navbar-logo">
                        <img src="home/img/Logo.svg" id="logoCacebalho" alt="descri��o imagem">
                    </div>
                    <div class="container-navbar-texto">
                        <h1>A COMIDA DOS <span>INTELIGENTES</span></h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="secao-2">
        <div class="s2-textos">
            <h1><span>PROMO��O</span> COMBO FAMILIA</h1>
            <p>Nas compras dos combos familia, consiga um <span>desconto de 30% nas sobremesas</span></p>
        </div>
    </div>
    <div class="container-cardapio-home-page">
        <div class="container-campo-buscar-home-page">
            <input id="campoBuscaHomePage" placeholder="procure sua comida aqui">
        </div>
        <div class="container-tab-navegation-home-page">
            <div class="tab-navegation-home-page">
            	<a class="item-cardapio" data-tipo="TODOS">Todos</a>
                <a class="item-cardapio" data-tipo="LANCHE">Lanches</a>
                <a class="item-cardapio" data-tipo="SOBREMESA">Sobremesas</a>
                <a class="item-cardapio" data-tipo="BEBIDA">Bebidas</a>
                <a class="item-cardapio" data-tipo="ADICIONAL">Adicionais</a>
            </div>
        </div>

        <div class="container-itens-home-page">
            <c:forEach var="item" items="${listaItems}">
                <div class="container-item-cardapio" data-tipo="${item.getTipo()}">
                    <div class="container-imagem-item">
                        <img id="imagem-item" src="${item.getURLImagem() }"></img>
                    </div>
                    <div class="container-descricao-item">
                        <h1>${item.getNome()}</h1>
                        <p>R$ ${item.getPreco()}</p>
                        <span style="display: none;">${item.getPalavrasChavesBusca()}</span>
	                    <p>${item.getTipo()}</p>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
    <div class="secao-4">
        <div class="s4-textos">
            <h1>contato.kitchengenius@genius.com</h1>
            <p>Powered By - Kitchen Genius</p>
            <p>
                <img id="logo-footer" src="home/img/Logo.svg"></img>
            </p>
            <p>(11) 9 9999-9999</p>
        </div>
    </div>
    <script type="text/javascript" src="home/js/home.js"></script>
</body>

</html>