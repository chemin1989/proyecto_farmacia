package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class GenericDAO {

	protected Connection miConexion = null;

	
	static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("no encuentro el drive-libreria de mysql");
		}

	}

	protected void conectar() {
	
		try {
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_farmacias", "root",
					"jeveris");
		} catch (SQLException e) {
			
			System.out.println("no pude conectarme a la base de datos");
			System.out.println("comprobar ruta base de datos");
			System.out.println("comprobar nobre de user y pass");
		}

	}
	
	protected void desconectar(){
		
		try {
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("no pude realizar la desconexion");
			System.out.println(miConexion);
			
		}
		
		
		
	}
}
