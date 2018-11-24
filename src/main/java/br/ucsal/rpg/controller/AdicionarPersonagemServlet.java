package br.ucsal.rpg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.PersonagemDAO;
import br.ucsal.rpg.model.Personagem;

/**

  */

@WebServlet("/AdicionarPersonagemServlet")
public class AdicionarPersonagemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		Integer raca_id = Integer.parseInt(request.getParameter("raca_id"));
		String maiorPersonalidade = request.getParameter("maiorPersonalidade");
		Integer pontosDeVida = Integer.parseInt(request.getParameter("pontosDeVida"));
		Integer pontosDeEnergia = Integer.parseInt(request.getParameter("pontosDeEnergia"));
		Integer xP = Integer.parseInt(request.getParameter("xp"));
		Integer level = Integer.parseInt(request.getParameter("level"));

		Personagem personagem = new Personagem();
		personagem.setId(id);
		personagem.setNome(nome);
		personagem.getRaca().setId(raca_id);
		personagem.setMaiorPersonalidade(maiorPersonalidade);
		personagem.setPontosDeVida(pontosDeVida);
		personagem.setPontosDeEnergia(pontosDeEnergia);
		personagem.setXP(xP);
		personagem.setLevel(level);
		PersonagemDAO dao = new PersonagemDAO();
		dao.inserir(personagem);

		response.sendRedirect("ListarPersonagemServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarPersonagemForm.jsp");
		dispatcher.forward(request, response);
	}

}
