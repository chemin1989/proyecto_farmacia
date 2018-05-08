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



@WebServlet("/ServletRegistroMedicamento")
public class ServletRegistroMedicamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("identificado")==null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		System.out.println("Se ejecuta el post");
		
		String nombre = request.getParameter("campoNombre");
		String precio = request.getParameter("campoPrecio");
		String codigoMedicamento = request.getParameter("campoCodigo");
		String cantidad = request.getParameter("campoCantidad");
		
		System.out.println(nombre);
		System.out.println(precio);
		System.out.println(codigoMedicamento);
		System.out.println(cantidad);
		
		int idFarmacia = (int) request.getSession().getAttribute("idFarmacia");
		
		Medicamento medicamentoAregistrar = new Medicamento(nombre, Double.parseDouble(precio), Integer.parseInt(cantidad), codigoMedicamento);
		MedicamentosDAOreg dao = new MedicamentosDAOImplReg();
		dao.registrarMedicamento(medicamentoAregistrar, idFarmacia);
		System.out.println("Medicamento registrado ok");	
		
		request.getRequestDispatcher("ServletListadoMedicamentosFarmacia").forward(request, response);
	}

}
