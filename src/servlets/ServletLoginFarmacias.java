package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.FarmaciasDAOreg;
import daosImpl.FarmaciasDAOImplReg;
import modelos.Farmacia;


@WebServlet("/ServletLoginFarmacias")
public class ServletLoginFarmacias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("campoEmail");
		String contraseña = request.getParameter("campoContraseña");
		
		FarmaciasDAOreg dao = new FarmaciasDAOImplReg();
		if(dao.loginUsuarios(email, contraseña)) {
			
			
			request.getSession().setAttribute("identificado", "ok");
			request.getRequestDispatcher("ServletObtenerDatosFarmacia").forward(request, response);
			
			
		}else {
			// request.setAttribute("mensaje", "email y/o pass incorrectos");
			System.out.println("TONTOOOOOOO");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		
		}
	}

}


