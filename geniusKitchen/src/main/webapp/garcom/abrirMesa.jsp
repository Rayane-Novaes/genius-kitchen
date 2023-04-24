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
        <form class="box-formulario">
            <h1 class="titulo"> ABRIR MESA<h1>

            <div>
                <input type="text" id="fname" name="fname" placeholder="cliente" required>
                <input type="text" id="fname" name="fname" placeholder="mesa" required>
            </div>

            <div>
                <select name="select" required>
                  <option value="valor1">Comida</option>
                  <option value="valor2" >Valor 2</option>
                  <option value="valor3">Valor 3</option>
                </select>
                <input type="number" id="fname" name="fname" placeholder="Qtd" required>
            </div>

            <div>
                <button>
                    <img class="cancelar-icon" class="logo" src="images/cancelarIcon.svg" alt="Icone cancelar">
                </button>

                <button>
                    <img class="continuar-icon" class="logo" src="images/continuarIcon.svg" alt="Icone continuar">
                </button>
            </div>


        </form>

    </div>
</body>

</html>