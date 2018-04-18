package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daosImpl.MedicamentosDAOImplReg;
import modelos.Medicamento;


@WebServlet("/ServletBorrarMedicamento")
public class ServletBorrarMedicamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		MedicamentosDAOImplReg dao = new MedicamentosDAOImplReg();
		Medicamento borrar = dao.borrarMedicamentoPorId(id);
		request.getRequestDispatcher("ServletListadoMedicamentosFarmacia").forward(request, response);
		
	}

}
