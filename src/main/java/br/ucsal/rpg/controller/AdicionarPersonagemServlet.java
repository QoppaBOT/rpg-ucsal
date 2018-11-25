package br.ucsal.rpg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.PersonagemDAO;
import br.ucsal.rpg.dao.RacaDAO;
import br.ucsal.rpg.dao.SalaDAO;
import br.ucsal.rpg.dao.UsuarioDAO;
import br.ucsal.rpg.model.Personagem;
import br.ucsal.rpg.model.Raca;
import br.ucsal.rpg.model.Sala;
import br.ucsal.rpg.model.Usuario;

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
		String nome = request.getParameter("nome");
		String idraca = request.getParameter("raca");
		String idsala = request.getParameter("sala");
		String idusuario = request.getParameter("usuario");

		String maiorPersonalidade = request.getParameter("maiorPersonalidade");
		Integer pontosDeVida = Integer.parseInt(request.getParameter("pontosDeVida"));
		Integer pontosDeEnergia = Integer.parseInt(request.getParameter("pontosDeEnergia"));
		Integer xP = Integer.parseInt(request.getParameter("xp"));
		Integer level = Integer.parseInt(request.getParameter("level"));

		Personagem personagem = new Personagem();
		personagem.setNome(nome);
		personagem.setMaiorPersonalidade(maiorPersonalidade);
		personagem.setPontosDeVida(pontosDeVida);
		personagem.setPontosDeEnergia(pontosDeEnergia);
		personagem.setXP(xP);
		personagem.setLevel(level);

		RacaDAO racaDAO = new RacaDAO();
		Integer id_raca = Integer.parseInt(idraca);
		Raca raca = racaDAO.getRaca(id_raca);
		personagem.setRaca(raca);
		
		SalaDAO salaDAO = new SalaDAO();
		Integer id_sala = Integer.parseInt(idsala);
		Sala sala = salaDAO.getSala(id_sala);
		personagem.setSala(sala);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Integer id_usuario = Integer.parseInt(idusuario);
		Usuario usuario = usuarioDAO.getUsuario(id_usuario);
		personagem.setUsuario(usuario);
		
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
