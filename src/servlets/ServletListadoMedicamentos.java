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

@WebServlet("/ServletListadoMedicamentos")
public class ServletListadoMedicamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String busqueda = (String) request.getSession().getAttribute("busqueda");
		
		if (busqueda==null) {
			busqueda="";
		}
		
		String desde = request.getParameter("desde");
		String cuantos = request.getParameter("cuantos");
		
		int desdeInt = 0;
		int cuantosInt = 15;
		
		if(desde != null && cuantos != null){
			desdeInt = Integer.parseInt(desde);
			cuantosInt = Integer.parseInt(cuantos);
		}
		
		System.out.println(desdeInt);
		System.out.println(cuantosInt);
		
		MedicamentosDAOListFarm medicamentosDAO = new MedicamentosDAOImplListFarm();
		List<Medicamento> medicamentos = 
				medicamentosDAO.obtenerMedicamentos(desdeInt, cuantosInt, busqueda);
		
		
		int totalBusqueda = medicamentosDAO.obtenerTotalMedicamentos(busqueda);
		request.getSession().setAttribute("medicamentosTotales", totalBusqueda);
		System.out.println(busqueda);
		System.out.println(totalBusqueda);
		request.setAttribute("medicamentos", medicamentos);
		request.setAttribute("desdeSiguiente", desdeInt + 15);
		request.setAttribute("desdeAnterior", desdeInt - 15);
		request.getRequestDispatcher("listadoMedicamentos.jsp").forward(request, response);
		
	}

}
