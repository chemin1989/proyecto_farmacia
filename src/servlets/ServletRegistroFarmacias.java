package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import daos.FarmaciasDAOreg;
import daosImpl.FarmaciasDAOImplReg;
import modelos.Farmacia;

@WebServlet("/ServletRegistroFarmacias")
@MultipartConfig
public class ServletRegistroFarmacias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("campoNombre");
		String contraseÒa = request.getParameter("campoContraseÒa");
		String direccion = request.getParameter("campoDireccion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String cp = request.getParameter("campoCp");// codigoPostal
		Part imagen = request.getPart("campoImagen");

		
		
		String expresionRegularEmail = "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—¸‹Á«0-9._+-]{1,70}@"
				+ "[a-zA-Z0-9]{1,30}\\.[a-zA-Z.]{2,20}";
		Pattern pattern4 = Pattern.compile(expresionRegularEmail);
		Matcher matcher4 = pattern4.matcher(email);
		if(matcher4.matches()){
			System.out.println("Correo electrÛnico v·lido");
		} else{
			System.out.println("Correo electrÛnico no v·lido");
			request.setAttribute("mensajeErrorEmail", "Correo electrÛnico no v·lido");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		/*
		String gxnombre = "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄—Ò\\s0-9]{3,30}";
		String gxcontraseÒa = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})\r\n";
		String gxdireccion = "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄—Ò\\s0-9]{3,50}";
		String gxTelefono = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
		String gxEmail = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
		String gxCp = "(\\d{5})";

		Pattern p = Pattern.compile(gxnombre);
		Matcher m = p.matcher(nombre);

		Pattern p1 = Pattern.compile(gxcontraseÒa);
		Matcher m1 = p1.matcher(contraseÒa);

		Pattern p2 = Pattern.compile(gxdireccion);
		Matcher m2 = p2.matcher(direccion);

		Pattern p3 = Pattern.compile(gxTelefono);
		Matcher m3 = p3.matcher(telefono);

		Pattern p4 = Pattern.compile(gxEmail);
		Matcher m4 = p4.matcher(email);

		Pattern p5 = Pattern.compile(gxCp);
		Matcher m5 = p5.matcher(cp);

		if (m.matches() && m1.matches() && m2.matches() && m3.matches() && m4.matches() && m5.matches()) {
			System.out.println("datos introducidos correctamente");
		} else {
			request.setAttribute("info", "Algun dato no valido");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} */
		Farmacia f = new Farmacia(nombre, contraseÒa, direccion, telefono, email, cp, imagen);

		FarmaciasDAOreg dao = new FarmaciasDAOImplReg();
		dao.registrarFarmacia(f);
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
