package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.MedicamentosDAOreg;
import daosImpl.MedicamentosDAOImplReg;
import modelos.Medicamento;


@WebServlet("/ServletGuardarCambiosMedicamento")
public class ServletGuardarCambiosMedicamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cantidad = request.getParameter("campoCantidad");
		String id = request.getParameter("campoId");
		
		Medicamento medicamento = new Medicamento(null, 0, Integer.parseInt(cantidad), null);
		medicamento.setId(Integer.parseInt(id));
		
		MedicamentosDAOreg medicamentosDAOreg = new MedicamentosDAOImplReg();
		medicamentosDAOreg.guardarCambiosMedicamento(medicamento);
		
		request.getRequestDispatcher("ServletListadoMedicamentosFarmacia").forward(request, response);
		
	}

}
