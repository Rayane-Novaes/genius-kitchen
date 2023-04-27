<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Abrir Mesa</title>
    <link rel="stylesheet" href="abrirMesa.css">

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
                <select name="produto" required>
                  <option value="valor1">Comida</option>
                  <option value="valor2" >Bebida</option>
                </select>
                <input type="number" id="qtd" name="qtd" placeholder="Qtd" required>
            </div>

            <div>
                <button type="submit">
                    <img class="cancelar-icon" class="logo" src="images/cancelarIcon.svg" alt="Icone cancelar">
                </button>

                <button  >
                    <img class="continuar-icon" class="logo" src="images/continuarIcon.svg" alt="Icone continuar">
                </button>
            </div>


        </form>

    </div>
</body>

</html>