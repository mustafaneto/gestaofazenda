package br.mustafa.gestaofaz.control;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mustafa.gestaofaz.dao.PecuaristaDao;
import br.mustafa.gestaofaz.model.Pecuarista;


/**
 * Servlet implementation class ServletPecuaristaAdicionar
 */
@WebServlet("/ServletPecuaristaAdicionar")
public class ServletPecuaristaAdicionar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPecuaristaAdicionar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Pecuarista pecuarista = new Pecuarista();
		pecuarista.setNome(nome);
		pecuarista.setLogin(login);
		pecuarista.setSenha(senha);
		
		PecuaristaDao pecuaristaDao = new PecuaristaDao();
		try {
			pecuaristaDao.adicionar(pecuarista);
		} catch (SQLException e) {
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
