package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.FarmaciasDAO;
import daosImpl.FarmaciasDAOImpl;
import modelos.Farmacia;


@WebServlet("/ServletObtenerDatosFarmacia")
public class ServletObtenerDatosFarmacia extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String email = request.getParameter("campoEmail");
		
		FarmaciasDAO farmaciasDAO = new FarmaciasDAOImpl();
		Farmacia farmacia = farmaciasDAO.obtenerDatosFarmacia(email);
		
		int idFarmacia = farmacia.getId();
		request.getSession().setAttribute("idFarmacia", idFarmacia);
		
		request.getSession().setAttribute("farmaciaNombre", farmacia.getNombre());
		request.getSession().setAttribute("farmaciaEmail", farmacia.getEmail());
		request.getSession().setAttribute("farmaciaTelefono", farmacia.getTelefono());
		request.getSession().setAttribute("farmaciaDireccion", farmacia.getDireccion());
		request.getSession().setAttribute("farmaciaCodigoPostal", farmacia.getCodigoPostal());
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

}
