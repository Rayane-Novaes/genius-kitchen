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
				<% String mensagem = (String) request.getAttribute("mensagem"); %>
		<% if (mensagem != null && !mensagem.isEmpty()) { %>
		  <p style="background-color: #b0db9d; padding: 24px; max-width: 700px;"><%= mensagem %></p>
		<% } %>
		<br>
		<h4 style="color: red; text-decoration: underline;">Certifique-se que você possui a tabela criada na nase de dados.<br>Segue abaixo script de criação da tabela.</h4><br>
		<pre class="language-sql" style="background-color: #000; color: #fff; max-width: 700px;"><code>
		// Script da tabela
		
		CREATE TABLE item_cardapio (
		  codigo_item_cardapio VARCHAR(18)NOT NULL,
		  nome VARCHAR(255) NOT NULL,
		  tipo VARCHAR(20) NOT NULL,
		  preco DOUBLE PRECISION NOT NULL,
		  url_imagem VARCHAR(255) NOT NULL,
		  palavras_chave VARCHAR(255) NOT NULL,
		  
		  PRIMARY KEY (codigo_item_cardapio, nome) #Com indice
		  PRIMARY KEY (codigo_item_cardapio)       #Sem indice
		);
		}
		</code></pre>
		<div>

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