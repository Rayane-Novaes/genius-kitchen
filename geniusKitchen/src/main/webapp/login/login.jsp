<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style><%@include file="css/login.css"%></style>
</head>
<body>
    <div class="container">
    <form action="login" method="post">
       	<label for="nome">Nome completo:</label>
    	<input name="nome" placeholder="Nome">
    	<label for="email">Email:</label>
    	<input name="email" placeholder="E-mail">
    	<label for="senha">Senha:</label>
    	<input name="senha" placeholder="Senha">
    	
    	<button type="submit">&nbsp;Entrar&nbsp;</button>    
    </form>
    </div>
</body>
</html>