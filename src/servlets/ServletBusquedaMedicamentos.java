package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletBusquedaMedicamentos")
public class ServletBusquedaMedicamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String busquedaIntro = request.getParameter("campoBusqueda");
		request.getSession().setAttribute("busqueda",busquedaIntro);
		request.getRequestDispatcher("ServletListadoMedicamentos?desde=0&cuantos=15").forward(request, response);
	}

}
