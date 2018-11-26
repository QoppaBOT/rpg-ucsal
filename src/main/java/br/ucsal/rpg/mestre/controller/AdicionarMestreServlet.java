package br.ucsal.rpg.mestre.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.MestreDAO;
import br.ucsal.rpg.model.Mestre;

/**

  */

@WebServlet("/AdicionarMestreServlet")
public class AdicionarMestreServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Mestre mestre = new Mestre();
		mestre.setNome(nome);
		mestre.setDescricao(descricao);

		MestreDAO dao = new MestreDAO();
		dao.inserir(mestre);

		response.sendRedirect("ListarMestreServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarMestreForm.jsp");
		dispatcher.forward(request, response);
	}

}
