package br.mustafa.gestaofaz.control;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.mustafa.gestaofaz.model.Pecuarista;


/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter("/*")
public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("Entrou!!");
		HttpServletRequest  req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String url = req.getRequestURI();
		HttpSession session = req.getSession();
		System.out.println(url);
		Pecuarista pecuarista = (Pecuarista) session.getAttribute("pecuarista");
	
		if(pecuarista!=null) 
			chain.doFilter(request, response);
		 else
			if(url.endsWith("index.jsp") ||  
			 url.endsWith("frmpecuarista.html") ||
			 url.endsWith("ServletPecuaristaAdicionar") ||
			 url.endsWith("ServletPecuaristaLogar"))
				 chain.doFilter(request, response);
			else
				resp.sendRedirect("index.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
