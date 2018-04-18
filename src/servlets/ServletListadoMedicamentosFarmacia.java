package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Medicamento;
import daos.MedicamentosDAOListFarm;
import daosImpl.MedicamentosDAOImplListFarm;

@WebServlet("/ServletListadoMedicamentosFarmacia")
public class ServletListadoMedicamentosFarmacia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		/* if(request.getSession().getAttribute("admin") == null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		} */
		
		int idFarmacia = (int) request.getSession().getAttribute("idFarmacia");
		request.setAttribute("idFarmacia", idFarmacia);
		
		MedicamentosDAOListFarm medicamentosDAO = new MedicamentosDAOImplListFarm();
		List<Medicamento> medicamentos = medicamentosDAO.obtenerMedicamentosFarmacia(idFarmacia);

		
		
		request.setAttribute("medicamentos", medicamentos);
		request.getRequestDispatcher("listadoMedicamentosFarmacia.jsp").forward(request, response);
	}

}
