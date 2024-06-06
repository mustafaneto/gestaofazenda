package br.mustafa.gestaofaz.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mustafa.gestaofaz.dao.AnimalDao;
import br.mustafa.gestaofaz.dao.LoteDao;
import br.mustafa.gestaofaz.dao.RacaDao;
import br.mustafa.gestaofaz.model.Animal;

/**
 * Servlet implementation class ServletProdutoExcluir
 */
@WebServlet("/ServletAnimalAlterar")
public class ServletAnimalAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAnimalAlterar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		AnimalDao aniDao = new AnimalDao();
		Animal animal = new Animal();
		
		String nome = request.getParameter("nome");
		float peso = Float.valueOf(request.getParameter("peso"));
		int idRaca = Integer.valueOf(request.getParameter("raca"));
		int idLote = Integer.valueOf(request.getParameter("lote"));
		
		animal.setNome(nome);
		animal.setId(id);
		animal.setPeso(peso);
		
		RacaDao racDao = new RacaDao();
		try {
			animal.setRaca(racDao.listarUm(idRaca));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		LoteDao lotDao = new LoteDao();
		try {
			animal.setLote(lotDao.listarUm(idLote));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			aniDao.alterar(animal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}