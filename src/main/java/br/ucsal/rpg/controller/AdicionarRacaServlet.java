package br.ucsal.rpg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.RacaDAO;
import br.ucsal.rpg.model.Raca;

/**

  */

@WebServlet("/AdicionarRacaServlet")
public class AdicionarRacaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Integer forca = Integer.parseInt(request.getParameter("forca"));
		Integer destreza = Integer.parseInt(request.getParameter("destreza"));
		Integer contituicao = Integer.parseInt(request.getParameter("contituicao"));
		Integer inteligencia = Integer.parseInt(request.getParameter("inteligencia"));
		Integer percepicao = Integer.parseInt(request.getParameter("percepicao"));
		Integer carisma = Integer.parseInt(request.getParameter("carisma"));

		Raca raca = new Raca();
		raca.setNome(nome);
		raca.setForca(forca);
		raca.setDestreza(destreza);
		raca.setContituicao(contituicao);
		raca.setInteligencia(inteligencia);
		raca.setPercepicao(percepicao);
		raca.setCarisma(carisma);

		RacaDAO dao = new RacaDAO();
		dao.inserir(raca);

		response.sendRedirect("ListarRacaServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarRacaForm.jsp");
		dispatcher.forward(request, response);
	}

}
