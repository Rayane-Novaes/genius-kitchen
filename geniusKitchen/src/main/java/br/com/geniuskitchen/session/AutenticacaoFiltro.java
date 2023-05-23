package br.com.geniuskitchen.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "/*" })
public class AutenticacaoFiltro implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String servletPath = httpRequest.getServletPath();
		int index = servletPath.lastIndexOf(".");
		String extension = "";

		if (index >= 0)
			extension = servletPath.substring(index);

		if (!servletPath.equals("/") && !servletPath.equals("/login") && !servletPath.equals("/inicio")
				&& !servletPath.equals("/console")) {

			if (!extension.equals(".jpg") && !extension.equals(".png") && !extension.equals(".js")
					&& !extension.equals(".svg") && !extension.equals(".css") && !extension.equals(".jpeg")) {

				HttpSession session = httpRequest.getSession(false);

				if (session == null || session.getAttribute("username") == null) {
					httpResponse.sendRedirect("/login");
					return;
				}
			}

		}
		chain.doFilter(request, response);
	}
}
