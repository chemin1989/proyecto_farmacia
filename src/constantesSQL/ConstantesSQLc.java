package constantesSQL;

public class ConstantesSQLc {

	public static final String SQL_INSERCION_MEDICAMENTO = "insert into tabla_medicamentos(nombre, precio, cantidad, codigo, id_farmacia) values(?,?,?,?,?)";
	public static final String GUARDAR_CAMBIOS_MEDICAMENTOS = "update tabla_medicamentos set cantidad = ? where id = ?";
	public static final String OBTENER_MEDICAMENTO_POR_ID = "select * from tabla_medicamentos where id = ?";
	public static final String SQL_BORRAR_MEDICAMENTO_POR_ID = "delete from tabla_medicamentos where id= ?";
	

}
