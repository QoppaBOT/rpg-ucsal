package br.ucsal.rpg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.DangeonDAO;
import br.ucsal.rpg.model.Dangeon;

/**

  */

@WebServlet("/AdicionarDangeonServlet")
public class AdicionarDangeonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Dangeon dangeon = new Dangeon();
		dangeon.setNome(nome);
		dangeon.setDescricao(descricao);
		DangeonDAO dao = new DangeonDAO();
		dao.inserir(dangeon);

		response.sendRedirect("ListarDangeonServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarDangeonForm.jsp");
		dispatcher.forward(request, response);
	}

}
