package br.mustafa.gestaofaz.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mustafa.gestaofaz.dao.RacaDao;
import br.mustafa.gestaofaz.model.Raca;

/**
 * Servlet implementation class ServletRacaAdicionar
 */
@WebServlet("/ServletRacaAdicionar")
public class ServletRacaAdicionar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRacaAdicionar() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// Extrair a vari�vel do formul�rio
		String nome = request.getParameter("nome");
		
		//Definir e instanciar uma raca
		Raca raca = new Raca();
		raca.setNome(nome);
		
		// Salvar no BD
		RacaDao racDao = new RacaDao();
		try {
			racDao.adicionar(raca);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
