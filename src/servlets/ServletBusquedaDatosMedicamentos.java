package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Medicamento;
import daos.MedicamentosDAOPrepReg;
import daosImpl.MedicamentosDAOImplPrepReg;

@WebServlet("/ServletBusquedaDatosMedicamentos")
public class ServletBusquedaDatosMedicamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String busquedaDatos = request.getParameter("campoBusquedaDatos");
		
		if (busquedaDatos==null) {
			busquedaDatos="";
		}
		
		MedicamentosDAOPrepReg datosMedicamentosDAO = new MedicamentosDAOImplPrepReg();
		List<Medicamento> datosMedicamentos = 
				datosMedicamentosDAO.obtenerDatosMedicamentos(busquedaDatos);
		
		request.setAttribute("datosMedicamentos", datosMedicamentos);
		request.getRequestDispatcher("listadoDatosMedicamentos.jsp").forward(request, response);
		
	}

}
