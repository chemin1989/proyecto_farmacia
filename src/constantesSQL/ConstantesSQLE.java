package constantesSQL;

public class ConstantesSQLE {

	public static final String SQL_LISTAR_MEDICAMENTOS_FARMACIA = 
			"select * from tabla_medicamentos where id_farmacia=?";
	
	public static final String SQL_OBTENER_DATOS_FARMACIA = 
			"select * from tabla_farmacias where email=?";

	public static final String SQL_OBTENER_MEDICAMENTOS = 
			"select tabla_medicamentos.nombre as nombre, tabla_medicamentos.precio, "
			+ "tabla_medicamentos.cantidad, tabla_medicamentos.codigo, tabla_farmacias.nombre as "
			+ "nombre_farmacia, tabla_farmacias.email, tabla_farmacias.telefono, "
			+ "tabla_farmacias.direccion, tabla_medicamentos.id as id from tabla_medicamentos, "
			+ "tabla_farmacias where tabla_medicamentos.id_farmacia=tabla_farmacias.id and "
			+ "tabla_medicamentos.nombre like ? order by tabla_medicamentos.id desc limit ?,?";
	
	public static final String SQL_CANTIDAD_TOTAL_MEDICAMENTOS = 
			"select count(id) as total from tabla_medicamentos where nombre like ?";

	public static final String SQL_OBTENER_DATOS_MEDICAMENTOS = 
			"select * from tabla_datos_medicamentos where nombre like ?";

	public static final String SQL_OBTENER_MEDICAMENTO_POR_ID = 
			"select * from tabla_datos_medicamentos where id=?";

}
