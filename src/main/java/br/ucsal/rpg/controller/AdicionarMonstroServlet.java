package br.ucsal.rpg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.MonstroDAO;
import br.ucsal.rpg.model.Monstro;

/**

  */

@WebServlet("/AdicionarMonstroServlet")
public class AdicionarMonstroServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Integer pontosDeVida = Integer.parseInt(request.getParameter("pontosDeVida"));
		String descricao = request.getParameter("descricao");

		Monstro monstro = new Monstro();

		monstro.setNome(nome);
		monstro.setPontosDeVida(pontosDeVida);
		monstro.setDescricao(descricao);

		MonstroDAO dao = new MonstroDAO();
		dao.inserir(monstro);

		response.sendRedirect("ListarMonstroServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarMonstroForm.jsp");
		dispatcher.forward(request, response);
	}

}
