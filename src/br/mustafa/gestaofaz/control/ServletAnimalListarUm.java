package br.mustafa.gestaofaz.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mustafa.gestaofaz.dao.AnimalDao;
import br.mustafa.gestaofaz.dao.LoteDao;
import br.mustafa.gestaofaz.dao.RacaDao;
import br.mustafa.gestaofaz.model.Animal;
import br.mustafa.gestaofaz.model.Lote;
import br.mustafa.gestaofaz.model.Raca;

/**
 * Servlet implementation class SerletAnimalListarUm
 */
@WebServlet("/ServletAnimalListarUm")
public class ServletAnimalListarUm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAnimalListarUm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnimalDao aniDao = new AnimalDao();
		Animal animal = new Animal();

		int id = Integer.valueOf(request.getParameter("id"));

		try {
			animal = aniDao.listarUm(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		RacaDao racDao = new RacaDao();
		List<Raca> racas = null;
		try {
			racas = racDao.listarTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Despachar as racas para o JSP;
		request.setAttribute("racas", racas);
		// Despachar as racas para o jsp
		request.setAttribute("animal", animal);
		
		LoteDao lotDao = new LoteDao();
		List<Lote> lotes = null;
		try {
			lotes = lotDao.listarTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Despachar as lotes para o JSP;
		request.setAttribute("lotes", lotes);
		// Despachar as lotes para o jsp
		request.setAttribute("animal", animal);
		
		RequestDispatcher rd = request.getRequestDispatcher("animalalterar.jsp");
		rd.forward(request, response);

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

