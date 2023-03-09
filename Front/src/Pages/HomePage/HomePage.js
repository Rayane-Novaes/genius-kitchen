import './HomePage.css';
import '../../assets/common/site.css'
import ItemCardapio from './components/ItemCardapio';

export default function HomePage() {

    return (
        <div className='home-page'>
            <div className="cabecalho">
                <div >
                    <div className="container">
                        <div className="container-navbar-login">
                            <div className="btn-login">
                                <a href="#">Login</a>
                            </div>
                        </div>
                        <div className="container-navbar-logo">
                            <img id="navbar-logo" src="../../../assets/logo.svg" />
                        </div>
                        <div className="container-navbar-texto">
                            <h1>A COMIDA DOS <span>INTELIGENTES</span></h1>
                        </div>
                    </div>
                </div>
            </div>
            <div className="secao-2">
                {/* <img className="img-secao-2" src="./assets/promocoes.svg" /> */}
                <div class="s2-textos">
                    <h1><span>PROMOÇÃO</span> COMBO FAMILIA</h1>
                    <p>Nas compras dos combos familia, consiga um <span>desconto de 30% nas sobremesas</span></p>
                </div>
            </div>
            <div className="container-cardapio-home-page">
                <div className="container-campo-buscar-home-page">
                    <input id="campo-busca-home-page" placeholder="procure sua comida aqui">
                    </input>
                </div>
                <div className="container-tab-navegation-home-page">
                    <div className="tab-navegation-home-page">
                        <teste href="">Lanches</teste>
                        <teste href="">Sobremesas</teste>
                        <teste href="">Bebidas</teste>
                        <teste href="">Adicionais</teste>
                    </div>
                </div>
                <div className='container-itens-home-page'>
                    <div className='subcontainer-itens-home-page'>
                        <ItemCardapio titulo="X-Bacon duplo cheedar" preco="R$ 32,90" imgItem='assets/x-bacon.svg' />
                        <ItemCardapio titulo="X-Salada clássico" preco="R$ 25,50" imgItem='assets/x-salada.svg' />
                        <ItemCardapio titulo="Duplo burguer" preco="R$ 37,00" imgItem='assets/duplo-burger.svg' />
                        <ItemCardapio titulo="X-Egg duplo" preco="R$ 52,00" imgItem='assets/x-egge-duplo.svg' />
                        <ItemCardapio titulo="Tocco Burger" preco="R$ 42,50" imgItem='assets/tocco-burguer.svg' />
                        <ItemCardapio titulo="X-Tudo duplo cheedar" preco="R$ 77,50" imgItem='assets/x-tudo.svg' />
                        <ItemCardapio titulo="Black Burguer" preco="R$ 63,90" imgItem='assets/black-burguer.svg' />
                        <ItemCardapio titulo="X-Bacon duplo cheedar" preco="R$ 32,90" imgItem='assets/x-bacon.svg' />
                        <ItemCardapio titulo="X-Salada clássico" preco="R$ 25,50" imgItem='assets/x-salada.svg' />
                        <ItemCardapio titulo="Duplo burguer" preco="R$ 37,00" imgItem='assets/duplo-burger.svg' />
                        <ItemCardapio titulo="X-Egg duplo" preco="R$ 52,00" imgItem='assets/x-egge-duplo.svg' />
                        <ItemCardapio titulo="Tocco Burger" preco="R$ 42,50" imgItem='assets/tocco-burguer.svg' />
                        {/* <ItemCardapio titulo="X-Tudo duplo cheedar" preco="R$ 77,50" imgItem='assets/x-tudo.svg' />
                        <ItemCardapio titulo="Black Burguer" preco="R$ 63,90" imgItem='assets/black-burguer.svg' /> */}

                    </div>
                </div>
            </div>
            <div className="secao-4">
                <div class="s4-textos">
                    <h1>contato.kitchengenius@genius.com</h1>
                    <p>Powered By - Kitchen Genius</p>
                    <p>
                    <img id="logo-footer" src="../../../assets/logo.svg"></img>
                    </p>
                    <p>(11) 9 9999-9999</p>
                </div>
            </div>
        </div>
    )
}