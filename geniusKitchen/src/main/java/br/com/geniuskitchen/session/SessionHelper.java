package br.com.geniuskitchen.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionHelper {
	  
	  public static void criarSessao(HttpServletRequest request, String username, String tipo) {
	    HttpSession session = request.getSession(true);
	    session.setAttribute("username", username);
	    session.setAttribute("tipo", tipo);
	  }
	  
	  public static boolean verificarSessao(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    return session != null && session.getAttribute("username") != null;
	  }
	  
	  public static void encerrarSessao(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	      session.invalidate();
	    }
	  }
	}
