package br.ucsal.rpg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.MestreDAO;
import br.ucsal.rpg.dao.SalaDAO;
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

	/*
	 * private Integer id; 
	 * private Mestre mestre; 
	 * private String nome; 
	 * private String senha; 
	 * private String descricao;
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_mestre = request.getParameter("mestre");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String descricao = request.getParameter("descricao");

		MestreDAO mdao = new MestreDAO();

		Sala sala = new Sala();

		int id = Integer.parseInt(id_mestre);

		Mestre mestre = mdao.getMestre(id);
		sala.setMestre(mestre);
		sala.setNome(nome);
		sala.setSenha(senha);
		sala.setDescricao(descricao);

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
