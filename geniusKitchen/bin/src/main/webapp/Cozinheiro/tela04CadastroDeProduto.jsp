<html>
<body>

<link rel="stylesheet" href="sytle.css">

<h1>Pedidos</h1>

    <div class="cadastro">
        <form method="post" action="/cadastrar-produto">
            <div class="item">
                <div class="sub-item">
                    <div class="estrutura-texto">
                        <label class="label-form" for="nome-produto">Nome do produto</label>
                        <input type="text" name="nome-produto" id="nome-produto">
                    </div>

                    <div class="estrutura-texto">
                        <label for="preco-produto"> Valor do produto </label>
                        <input type="text" name="preco-produto" id="preco-produto">
                    </div>
                </div>


            </div>
            <div class="item">
                <label for="categoria-produto"> Categoria do produto </label>
                <input type="text" name="categoria-produto" id="categoria-produto">
            </div>

            <div class="confirmar">
                <button type=submit name="confirmar">confirmar</button>
            </div>

        </form>
    </div>

<div class="botoes-alteracoes">
    <button>alterar</button>
    <button>excluir</button>
</div>


<div class="tabela">
    <table>
        <tr>
            <th> ID </th>
            <th> Nome </th>
            <th> Categoria </th>
            <th> Preco </th>
        </tr>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>

    </table>

</div>

</body>
</html>
