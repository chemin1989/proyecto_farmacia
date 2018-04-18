package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Medicamento;
import daos.MedicamentosDAOPrepReg;
import daosImpl.MedicamentosDAOImplPrepReg;

@WebServlet("/ServletSeleccionMedicamentos")
public class ServletSeleccionMedicamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		MedicamentosDAOPrepReg medicamentosDAO = new MedicamentosDAOImplPrepReg();
		Medicamento medicamentoSeleccionado = medicamentosDAO.obtenerMedicamentoPorId(id);
		
		request.setAttribute("medicamentoSeleccionado", medicamentoSeleccionado);
		request.getRequestDispatcher("registroMedicamento.jsp").forward(request, response);
	
	}

}
