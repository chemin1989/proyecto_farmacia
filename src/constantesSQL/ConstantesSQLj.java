package constantesSQL;


public class ConstantesSQLj {

	public static final String SQL_REGISTRAR_FARMACIA = "insert into tabla_farmacias(nombre, email, pass, telefono, direccion, codigo_postal)"
			+ " VALUES(?,?,?,?,?,?)";
	public static final String SQL_LOGIN_USUARIO = "select id from tabla_farmacias where email = ? and pass = ?";
	
}
