package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Medicamento;
import daos.MedicamentosDAOreg;
import daosImpl.MedicamentosDAOImplReg;


@WebServlet("/ServletEditarMedicamento")
public class ServletEditarMedicamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		MedicamentosDAOreg medicamentosDAOreg = new MedicamentosDAOImplReg();

		Medicamento medicamentoAeditar = medicamentosDAOreg.obtenerMedicamentoPorId(id);
		request.setAttribute("medicamentoAeditar", medicamentoAeditar);
		request.getRequestDispatcher("editarMedicamento.jsp").forward(request, response);

	
	}

}
