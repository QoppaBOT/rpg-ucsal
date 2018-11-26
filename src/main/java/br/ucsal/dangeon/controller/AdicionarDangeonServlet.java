package br.ucsal.dangeon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.DangeonDAO;
import br.ucsal.rpg.dao.MonstroDAO;
import br.ucsal.rpg.model.Dangeon;
import br.ucsal.rpg.model.Monstro;

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
		String idMonstro = request.getParameter("idMonstro");
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Dangeon dangeon = new Dangeon();
		dangeon.setNome(nome);
		dangeon.setDescricao(descricao);

		MonstroDAO monstroDAO = new MonstroDAO();
		Integer idmons = Integer.parseInt(idMonstro);
		Monstro monstro = monstroDAO.getMonstro(idmons);
		dangeon.setMonstro(monstro);
		
		DangeonDAO dao = new DangeonDAO();
		dao.inserir(dangeon);

		response.sendRedirect("ListarDangeonServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MonstroDAO dao = new MonstroDAO();
		List<Monstro> monstro = dao.getLista();
		request.setAttribute("monstro", monstro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarDangeonForm.jsp");
		dispatcher.forward(request, response);
	}

}
