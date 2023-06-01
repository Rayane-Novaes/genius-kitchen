<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="css/login.css"%></style>
</head>
<body>

    <span>${requestScope.message}</span>


    <div class="container">


            
            <form action="login" method="post">
                <div class="input-container">
                    <label for="username">Login</label>
                    <input type="username" id="username" name="username" required>
                </div>
                <div class="input-container">
                    <label for="password">Senha</label>
                    <input type="password" id="password" name="password" required>
                        <% 
       String mensagem = (String) request.getAttribute("mensagem");
       if (mensagem != null && !mensagem.isEmpty()) {
           %>
           <p style="color:#fff; text-align:center;"><%= mensagem %></p>
           <%
       } 
    %>
                </div>
                       <button type="submit" class="btn">Confirmar</button>
            </form>
            
        </div>
  </body>
</html>