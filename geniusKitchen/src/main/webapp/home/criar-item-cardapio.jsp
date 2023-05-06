<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Criar item cardapio</title>
	    <style><%@include file="css/criar-item-cardapio.css"%></style>
	    
	</head>
	<body style="padding: 40px;">
		<h1>Criar item cardápio</h1>
		<br>
		<div>
		<% String mensagem = (String) request.getAttribute("mensagem"); %>
		<% if (mensagem != null && !mensagem.isEmpty()) { %>
		  <p><%= mensagem %></p>
		<% } %>

		<br>
		</div>
		<form action="criar-item-cardapio" method="POST">
			<label for="nome">Nome: </label>
			<input type="text" name="nome">
			<br><br>			
			<label for="nome">Preço: </label>
			<input type="text" name="preco" id="preco" step="0.01">
			<br><br>
			<label for="nome">URL Imagem: </label>
			<input type="text" name="URLImagem" placeholder="Use imagems em svg">
			<br><br>
			<label for="tipo">Selecione um tipo: </label>
			<select name="tipo" id="tipo">
			  <option selected>Selecione</option>
			  <option value="LANCHE">Lanche</option>
			  <option value="SOBREMESA">Sobremesa</option>
			  <option value="BEBIDA">Bebida</option>
			  <option value="ADICIONAL">Adicional</option>
			</select>
			<br><br>
			<textarea name="palavrasChave" maxlength="255" rows="6" cols="60" placeholder="Informe uma lista de palavras chaves para facilitar a busca dos items no sistema."></textarea>
			<br>
		  <button type="submit">&nbsp;Salvar&nbsp;</button>
		</form>
	</body>
</html>