package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import constantesSQL.ConstantesSQLE;
import modelos.Farmacia;
import daos.FarmaciasDAO;
import daos.GenericDAO;

public class FarmaciasDAOImpl extends GenericDAO implements FarmaciasDAO {

	@Override
	public Farmacia obtenerDatosFarmacia(String email) {
		conectar();
		
		Farmacia farmacia = new Farmacia();
		
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQLE.SQL_OBTENER_DATOS_FARMACIA);
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				farmacia.setId(rs.getInt("id"));
				farmacia.setNombre(rs.getString("nombre"));
				farmacia.setEmail(rs.getString("email"));
				farmacia.setContraseña(rs.getString("pass"));
				farmacia.setTelefono(rs.getString("telefono"));
				farmacia.setDireccion(rs.getString("direccion"));
				farmacia.setCodigoPostal(rs.getString("codigo_postal"));
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("sql select proveedores está mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		desconectar();
		return farmacia;
	}

	
	
}
