<%@ page language = "java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.geniuskitchen.model.Produto"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Abrir Mesa</title>
    <style><%@include file="abrirMesa.css"%></style>

</head>

<body>

    <div class="box-principal">
        <form  method="POST" action="/nova-mesa"  class="box-formulario">
            <h1 class="titulo"> ABRIR MESA<h1>

            <div>
                <input type="text" id="cliente" name="cliente" placeholder="cliente" required>
                <input type="text" id="mesa" name="mesa" placeholder="mesa" required>
            </div>

            <div>
                <select id="escolha" name="produto" required>
                    <c:forEach var="produto" items="${produtos}">
                            <table>
                                <option value="${produto.id}">${produto.id} ${produto.nome} </option>
                            </table>
                    </c:forEach>
                </select>
                <input type="number" id="qtd" name="qtd" placeholder="Qtd" required>
            </div>

            <div>
                <button type="submit">
                    <img class="cancelar-icon" class="logo" src="garcom/images/cancelarIcon.svg" alt="Icone cancelar">
                </button>

                <button  >
                    <img class="continuar-icon" class="logo" src="/garcom/images/continuarIcon.svg" alt="Icone continuar">
                </button>
            </div>
                <div>
                </div>
        </form>
    </div>
</body>

</html>