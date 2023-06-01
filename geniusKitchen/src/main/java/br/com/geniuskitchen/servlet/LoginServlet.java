package br.com.geniuskitchen.servlet;

import br.com.geniuskitchen.model.Usuario;
import br.com.geniuskitchen.session.SessionHelper;
import br.com.geniuskitchen.dao.UsuarioDAO;
import br.com.geniuskitchen.enums.TipoUsuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("login/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Usuario usuarioInput = new Usuario();
		
		usuarioInput.setUsername(username);
		usuarioInput.setPassword(password);
		
		var usuarioBase = new UsuarioDAO().buscarUsuario(usuarioInput);

		if (usuarioBase.UsuarioDiferenteDeNull()) {
			
			SessionHelper.criarSessao(req, usuarioBase.getUsername(), usuarioBase.getTipo().toString());
			
			if(TipoUsuario.GARCOM == usuarioBase.getTipo()) {
				resp.sendRedirect("/find-mesa");
			}
			
			else if(TipoUsuario.COZINHEIRO == usuarioBase.getTipo()) { 
				resp.sendRedirect("/exibir-pendente");
			}

			} else {
			
			req.setAttribute("mensagem", "Usuário ou Senha inválidos. Tente novamente!");

			req.getRequestDispatcher("login/login.jsp").forward(req, resp);
		}
	}
}
