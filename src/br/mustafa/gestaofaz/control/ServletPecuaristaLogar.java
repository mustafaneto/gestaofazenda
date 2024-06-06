package br.mustafa.gestaofaz.control;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.mustafa.gestaofaz.dao.PecuaristaDao;
import br.mustafa.gestaofaz.model.Pecuarista;



/**
 * Servlet implementation class ServletPecuaristaLogar
 */
@WebServlet("/ServletPecuaristaLogar")
public class ServletPecuaristaLogar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPecuaristaLogar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// Extrair a variável do formulário
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		//Criar pecuarista
		Pecuarista pecuarista = null;
		
		// Verificar login do pecuarista
		PecuaristaDao pecDao = new PecuaristaDao();
		try {
			pecuarista = pecDao.logar(login,senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String nextPage = null;
		String erro = null;
		
		if (pecuarista!= null) {
			nextPage = "menu.jsp";
		}
		else {
			nextPage ="index.jsp";
			erro = "Login inválido";
			request.setAttribute("erro", erro);

		}
		
		// Pegando a session e pendurando um pecuarista
		HttpSession session = request.getSession();
		session.setAttribute("pecuarista", pecuarista);
		
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
