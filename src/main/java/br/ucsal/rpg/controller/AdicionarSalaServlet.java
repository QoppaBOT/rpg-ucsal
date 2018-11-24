package br.ucsal.rpg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.DangeonDAO;
import br.ucsal.rpg.dao.MestreDAO;
import br.ucsal.rpg.dao.SalaDAO;
import br.ucsal.rpg.model.Dangeon;
import br.ucsal.rpg.model.Mestre;
import br.ucsal.rpg.model.Sala;

/**

  */

@WebServlet("/AdicionarSalaServlet")
public class AdicionarSalaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idMestre = request.getParameter("mestre");
		String idDangeon = request.getParameter("dangeon");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String descricao = request.getParameter("descricao");

		Sala sala = new Sala();

		int mestre_id = Integer.parseInt(idMestre);
		int monstro_id = Integer.parseInt(idDangeon);

		MestreDAO mestreDAO = new MestreDAO();
		DangeonDAO dangeonDAO = new DangeonDAO();

		Mestre mestre = mestreDAO.getMestre(mestre_id);
		Dangeon dangeon = dangeonDAO.getDangeon(monstro_id);

		sala.setMestre(mestre);
		sala.setNome(nome);
		sala.setSenha(senha);
		sala.setDescricao(descricao);
		sala.setDangeon(dangeon);
		sala.setMestre(mestre);

		SalaDAO dao = new SalaDAO();
		dao.inserir(sala);

		response.sendRedirect("ListarMestreServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarSalaForm.jsp");
		dispatcher.forward(request, response);
	}

}
