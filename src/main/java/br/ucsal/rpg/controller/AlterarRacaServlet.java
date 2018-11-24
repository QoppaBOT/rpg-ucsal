package br.ucsal.rpg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.RacaDAO;
import br.ucsal.rpg.model.Raca;

@WebServlet("/AlterarSalaServlet")
public class AlterarRacaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarRacaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		RacaDAO dao = new RacaDAO();
		Raca raca = dao.getRaca(id);
		request.setAttribute("raca", raca);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarRacaForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer nome_id = Integer.parseInt(request.getParameter("nome_id"));
		Integer forca = Integer.parseInt(request.getParameter("forca"));
		Integer destreza = Integer.parseInt(request.getParameter("destreza"));
		Integer contituicao = Integer.parseInt(request.getParameter("contituicao"));
		Integer inteligencia = Integer.parseInt(request.getParameter("inteligencia"));
		Integer percepicao = Integer.parseInt(request.getParameter("percepicao"));
		Integer carisma = Integer.parseInt(request.getParameter("carisma"));

		Raca raca = new Raca();
		raca.setId(nome_id);
		raca.setForca(forca);
		raca.setDestreza(destreza);
		raca.setContituicao(contituicao);
		raca.setInteligencia(inteligencia);
		raca.setPercepicao(percepicao);
		raca.setCarisma(carisma);
		RacaDAO dao = new RacaDAO();
		dao.altera(raca);

		List<Raca> lista = dao.getLista();
		request.setAttribute("raca", lista);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarRaca.jsp");
		requestDispatcher.forward(request, response);

	}

}
