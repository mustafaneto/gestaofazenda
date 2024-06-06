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

import br.mustafa.gestaofaz.dao.LoteDao;
import br.mustafa.gestaofaz.dao.RacaDao;
import br.mustafa.gestaofaz.model.Lote;
import br.mustafa.gestaofaz.model.Raca;

/**
 * Servlet implementation class ServletRacaListar
 */
@WebServlet("/ServletRacaListar")
public class ServletRacaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRacaListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = request.getParameter("nextPage");
		//Pegar raca
		RacaDao racDao = new RacaDao();
		LoteDao lotDao = new LoteDao();
		
		List<Raca> racas = null;
		try {
			racas = racDao.listarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Lote> lotes = null;
		try {
			lotes = lotDao.listarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("racas", racas);
		request.setAttribute("lotes", lotes);
		
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
