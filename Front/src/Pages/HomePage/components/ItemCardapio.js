import "./ItemCardapio.css"

export default function ItemCardapio(props) {
    return (
        <div className="container-item-cardapio">
            <div className="container-imagem-item">
                <img id="imagem-item" src={props.imgItem}></img>
            </div>
            <div className="container-descricao-item">
                <h1>{props.titulo}</h1>
                <p>{props.preco}</p>
            </div>
        </div>
    )
}