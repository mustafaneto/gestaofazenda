package br.mustafa.gestaofaz.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mustafa.gestaofaz.dao.LoteDao;
import br.mustafa.gestaofaz.model.Lote;



/**
 * Servlet implementation class ServletLoteAdicionar
 */
@WebServlet("/ServletLoteAdicionar")
public class ServletLoteAdicionar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLoteAdicionar() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// Extrair a vari�vel do formul�rio
		String nome = request.getParameter("nome");
		float area = Float.valueOf(request.getParameter("area"));
		
		//Definir e instanciar um lote
		Lote lote = new Lote();
		lote.setNome(nome);
		lote.setArea(area);
		
		// Salvar no BD
		LoteDao lotDao = new LoteDao();
		try {
			lotDao.adicionar(lote);
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