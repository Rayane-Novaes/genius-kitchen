/**
 * Esta classe é responsável por lidar com as requisições relacionadas à criação de um novo item no cardápio.
 * Ao receber uma requisição GET, ela redireciona para a página de criação de item.
 * Ao receber uma requisição POST com os dados preenchidos pelo usuário, ela tenta inserir o novo item no banco de dados.
 * Em seguida, redireciona para a mesma página de criação de item, informando se a operação foi bem sucedida ou não.
 * 
 * Nome do arquivo: CriarItemCardapioServlet.java
 * Autor: José V. Vieira
 * Data de criação: 05/05/2023
 */

package br.com.geniuskitchen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.geniuskitchen.dao.CardapioDAO;
import br.com.geniuskitchen.model.ItemCardapio;

@WebServlet("/criar-item-cardapio")
public class CriarItemCardapioServlet extends HttpServlet {
	
	private CardapioDAO _dao;
	
	/**
	 * Método init() que é executado apenas uma vez na criação do objeto. 
	 * Ele cria uma instância da classe CardapioDAO para ser usada posteriormente na requisição GET.
	 */
	@Override
	public void init() throws ServletException { _dao = new CardapioDAO(); }
	
	/**
	 * Responde à solicitações HTTP GET. Mostra o formulário para criação de um novo item de cardápio.
	 * 
	 * @param req Objeto HttpServletRequest contendo a requisição HTTP
	 * @param resp Objeto HttpServletResponse contendo a resposta HTTP
	 * @throws ServletException se o servlet encontrar problemas ao lidar com a solicitação HTTP GET
	 * @throws IOException se ocorrerem erros de I/O ao lidar com a solicitação HTTP GET
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("home/criar-item-cardapio.jsp");
		dispatcher.forward(req, resp);
	}
	/**
	 * Método responsável por lidar com as requisições POST para a servlet.
	 * Ele tenta inserir o novo item no banco de dados e redireciona o usuário para a página de criação de item.
	 * A página informa se a operação foi bem sucedida ou não.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.err.println("\nPOST - Criar item cardapio.");
		
		String mensagem = "";		
	    String nome = req.getParameter("nome");
	    double preco = Double.parseDouble(req.getParameter("preco").replace(",", "."));
	    String urlImagem = req.getParameter("URLImagem");
	    String tipo = req.getParameter("tipo");
	    String palavrasChave = req.getParameter("palavrasChave");
	    
	    ItemCardapio item = new ItemCardapio(nome, tipo, preco, urlImagem, palavrasChave);
	    
	    boolean resultado = _dao.inserirItem(item);
	    
	    if(resultado) mensagem = String.format("O item %s, foi inserido com sucesso. Seu código é: %s", item.getNome(), item.getCodigoItemCardapio());
	    else mensagem = String.format("Não foi possível inserir o item %s, tente novamente mais tarde.<br>Se o problema persistir, contate um administrador do sistema!<br>", item.getNome());
	    
		RequestDispatcher dispatcher = req.getRequestDispatcher("home/criar-item-cardapio.jsp");
		req.setAttribute("mensagem", mensagem);
		resp.setStatus(201);
		dispatcher.forward(req, resp);
	}
}
