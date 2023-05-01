<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>adminCozinheiroPedidos</title>

<style><%@include file="sytle.css"%></style>

<body>
    <span class="decoracao"><span>

    <div class="estrutura">

        <a  class="botao-link" href="cozinheiro/tela04CadastroDeProduto.jsp">Cadastrar Produto</a>
    </div>

    <div class="logo">
        <img class="logo-2" src="img/Logo%205.png" alt="logo genius kitchen">
    </div>

    <h1>PEDIDOS</h1>

        <div class="box-pedidos" id="pedidos">

          <c:if test="${empty pendente}">
              <div class="estrutura-item">
                  <p>Nenhum pedido encontrado.</p>
              </div>
          </c:if>

        <c:forEach var="pendente" items="${pendente}">
            <div class="estrutura-item">
                <div class="format-texto">
                     <p> <strong>Numero do pedido: </strong> ${pendente.id}</p>
                     <p> <strong>Nome cliente: </strong> ${pendente.cliente}<p>
                     <p> <strong>Mesa: </strong> ${pendente.mesa}</p>
                </div>

                <div class="format-comida">
                    <p> <strong>Comidas a serem preparada:</strong></p>
                    <p> </p>
                </div>
               <form action="/update-pedido-preparado" method="post">
                    <input type="hidden" id="id" name="id" value="${pendente.id}">
                    <button class="btn-finalizar" type="submit"> Pronto para entrega </button>
                </form>

            </div>

      </c:forEach>

        </div>
</body>

</html>