<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Cardapio</title>
    <style><%@include file="/css/site.css"%></style>
    <style><%@include file="/css/home-cardapio.css"%></style>
</head>
<body style="margin: 0px;">
<div class="home-page">
    <div class="cabecalho">
        <div >
            <div class="container">
                <div class="container-navbar-login">
                    <div class="btn-login">
                        <a href="#">Login</a>
                    </div>
                </div>
                <div class="container-navbar-logo">
                <img src="/img/Logo.svg" alt="descrição imagem">
                </div>
                <div class="container-navbar-texto">
                    <h1>A COMIDA DOS <span>INTELIGENTES</span></h1>
                </div>
            </div>
        </div>
    </div>
<!--Secção 2 aqui-->	
    <div class="container-cardapio-home-page">
        <div class="container-campo-buscar-home-page">
            <input id="campoBuscaHomePage" placeholder="procure sua comida aqui">
        </div>
        <div class="container-tab-navegation-home-page">
            <div class="tab-navegation-home-page">
                <tabs href="">Lanches</tabs>
                <tabs href="">Sobremesas</tabs>
                <tabs href="">Bebidas</tabs>
                <tabs href="">Adicionais</tabs>
            </div>
        </div>
        <div class="container-itens-home-page">
            <div class="subcontainer-itens-home-page">
                <div class="container-item-cardapio">
                    <div class="container-imagem-item">
                        <img id="imagem-item" src="/img/duplo-burger.svg"></img>
                    </div>
                    <div class="container-descricao-item">
                        <h1>Burguer Duplo</h1>
                        <p>40 R$</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<!--Secção 4 aqui-->
</body>
</html>