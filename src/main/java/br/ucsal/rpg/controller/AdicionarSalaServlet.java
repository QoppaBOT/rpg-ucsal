package br.ucsal.rpg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.MestreDAO;
import br.ucsal.rpg.dao.MonstroDAO;
import br.ucsal.rpg.dao.SalaDAO;
import br.ucsal.rpg.model.Mestre;
import br.ucsal.rpg.model.Monstro;
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
		String id_mestre = request.getParameter("mestre");
		String id_monstro = request.getParameter("mosntro");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String descricao = request.getParameter("descricao");

		MestreDAO mdao = new MestreDAO();

		Sala sala = new Sala();

		int mestre_id = Integer.parseInt(id_mestre);
		int monstro_id = Integer.parseInt(id_monstro);

         MestreDAO mestreDao = new MestreDAO();
         MonstroDAO monstroDao = new MonstroDAO();

		Mestre mestre = mestreDao.getMestre(mestre_id);
		Monstro monstro= monstroDao.getMonstro(monstro_id);
		
		sala.setMestre(mestre);
		sala.setNome(nome);
		sala.setSenha(senha);
		sala.setDescricao(descricao);
		sala.setMonstro(monstro);
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
