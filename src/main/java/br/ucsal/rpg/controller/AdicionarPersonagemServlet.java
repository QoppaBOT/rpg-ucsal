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
		String raca_id = request.getParameter("raca");
		String sala_id = request.getParameter("sala");
		String usuario_id = request.getParameter("usuario");
		
		String maiorPersonalidade = request.getParameter("maiorPersonalidade");
		Integer pontosDeVida = Integer.parseInt(request.getParameter("pontosDeVida"));
		Integer pontosDeEnergia = Integer.parseInt(request.getParameter("pontosDeEnergia"));
		Integer xP = Integer.parseInt(request.getParameter("xp"));
		Integer level = Integer.parseInt(request.getParameter("level"));
        
		int id_raca = Integer.parseInt(raca_id);
 		int id_sala = Integer.parseInt(sala_id);
		int id_usuario=Integer.parseInt(usuario_id);

		RacaDAO racaDao= new RacaDAO();
		SalaDAO salaDao= new SalaDAO();
		UsuarioDAO usuarioDao = new 	UsuarioDAO();
		
		Raca raca = racaDao.getRaca(id_raca);
		Sala sala= salaDao.getSala(id_sala);
		Usuario usuario = usuarioDao.getUsuario(id_usuario);
		
		
		
		Personagem personagem = new Personagem();
		personagem.setNome(nome);
		personagem.setMaiorPersonalidade(maiorPersonalidade);
		personagem.setPontosDeVida(pontosDeVida);
		personagem.setPontosDeEnergia(pontosDeEnergia);
		personagem.setXP(xP);
		personagem.setLevel(level);
		personagem.setRaca(raca);
		personagem.setSala(sala);
		personagem.setUsuraio(usuario);
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
