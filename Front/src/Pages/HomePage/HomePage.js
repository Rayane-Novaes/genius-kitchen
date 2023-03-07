import './HomePage.css';
import '../../assets/common/site.css'
import Logo from "../../assets/images/logo.svg"
export default function HomePage() {

  return (
    <div className='home-page'>
        <div className="cabecalho">
            <div className="container">
                <div className="container-navbar-login">
                    <div className="btn-login">
                        <p>Login</p>
                    </div>
                </div>
                <div className="container-navbar-logo">
                    <img id="navbar-logo" src={Logo}/>
                    <div className="navbar-logo-titulos">
                        <p id="kitchen">Kitchen</p>
                        <h2 id="genius">Genius</h2>
                    </div>
                </div>
                <div className="container-navbar-texto">
                    <h1>A COMIDA DOS <span>INTELIGENTES</span></h1>
                    
                </div>
            </div>
        </div>
    </div>
  )
}