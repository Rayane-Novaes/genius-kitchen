<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="css/login.css"%></style>
</head>
<body>
    <div class="container">
            <div class="img-container">
                <img class="img-login" src="login/img/imagem-login.svg" alt="Imagem login">
            </div>
            <div class="img-container">
                <img class="logo-login" src="login/img/Logo%205.png" alt="logo login">
            </div>
            <form>
                <div class="input-container">
                    <label for="username">Login</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-container">
                    <label for="password">Senha</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="btn">Confirmar</button>
            </form>
        </div>
  </body>
</html>