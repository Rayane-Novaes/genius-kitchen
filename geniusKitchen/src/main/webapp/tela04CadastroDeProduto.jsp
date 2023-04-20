<html>
<body>
<h1>pedidos</h1>

    <div>
    <form method="post" action="/cadastrar-produto">
<label for="nome-produto">nome do produto</label>
<input type="text" name="nome-produto" id="nome">

<label for="preco-produto">valor do produto</label>
<input type="text" name="preco-produto" id="preco">

<label for="categoria-produto">categoria do produto</label>
<input type="text" name="categoria-produto" id="categoria">

<button type=submit name="confirmar">confirmar</button>

</form>
</div>

<div>
    <table>
    <tr>
        <th>id</th>
        <th>nome</th>        
        <th>categoria</th>        
        <th>preço</th>        
    </tr>
<tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
</tr>
</table>

<button>alterar</button>
<button>excluír</button>
</div>

</body>
</html>
