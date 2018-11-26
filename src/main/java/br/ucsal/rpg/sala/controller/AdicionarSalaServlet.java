package br.ucsal.rpg.sala.controller;

import java.io.IOException;
import java.util.List;

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
		sala.setNome(nome);
		sala.setSenha(senha);
		sala.setDescricao(descricao);

		MestreDAO mestreDAO = new MestreDAO();
		int idmest = Integer.parseInt(idMestre);
		Mestre mestre = mestreDAO.getMestre(idmest);
		sala.setMestre(mestre);

		DangeonDAO dangeonDAO = new DangeonDAO();
		int iddang = Integer.parseInt(idDangeon);
		Dangeon dangeon = dangeonDAO.getDangeon(iddang);
		sala.setDangeon(dangeon);

		SalaDAO dao = new SalaDAO();
		dao.inserir(sala);

		response.sendRedirect("ListarSalaServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MestreDAO mdao = new MestreDAO();
		List<Mestre> mestre = mdao.getLista();
		request.setAttribute("mestre", mestre);
		DangeonDAO rdao = new DangeonDAO();
		List<Dangeon> dangeon = rdao.getLista();
		request.setAttribute("dangeon", dangeon);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarSalaForm.jsp");
		dispatcher.forward(request, response);
	}

}
