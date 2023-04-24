<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedidos Concluidos</title>
    <link rel="stylesheet" href="concluidos.css">

</head>

<body>
    <div class="box-principal">

        <img class="logo" src="images/logo.svg" alt="logo Genius Kitchen">
        <h1 class="titulo"> CONCLUIDOS<h1>

        <div class="box-pedidos">
            <c:forEach var="pedido" items="${pedidos}">
            <p>${pedido.mesa}</p>


            </c:forEach>

        </div>

        <div class="box-button">
            <a href="abrirMesa.jsp" >
                <img class="adicionar-icon" class="logo" src="images/adicionarIcon.svg" alt="Icone adicionar">
            </a>
        </div>
    </div>
</body>
</html>