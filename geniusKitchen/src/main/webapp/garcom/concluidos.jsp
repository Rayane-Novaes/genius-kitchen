<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedidos Concluidos</title>
    <style><%@include file="concluidos.css"%></style>

</head>

<body>
    <div class="box-principal">

        <img class="logo" src="/garcom/images/logo.svg" alt="logo Genius Kitchen">
        <h1 class="titulo"> CONCLUIDOS<h1>

        <div class="box-pedidos" id="pedidos-concluidos">
          <c:if test="${empty pedidos}">
            <p>Nenhum pedido encontrado.</p>
          </c:if>
          <c:forEach var="pedido" items="${pedidos}">
            <p>Mesa: ${pedido.mesa}</p>
            <button>Finalizar</button>
          </c:forEach>
        </div>

        <div class="box-button">
            <a href="/garcom/abrirMesa.jsp" >
                <img class="adicionar-icon" class="logo" src="/garcom/images/adicionarIcon.svg" alt="Icone adicionar">
            </a>
        </div>


    </div>

<script>
    setInterval(function(){
      location.reload();
    }, 10000);
</script>

</body>



</html>