package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.Part;

import com.mysql.jdbc.Statement;

import constantesSQL.ConstantesSQLj;
import daos.FarmaciasDAOreg;
import daos.GenericDAO;
import gestorArchivos.GestorDeArchivos;
import modelos.Farmacia;

public class FarmaciasDAOImplReg extends GenericDAO implements FarmaciasDAOreg {

	@Override
	public void registrarFarmacia(Farmacia f) {
		conectar();
		try {

			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQLj.SQL_REGISTRAR_FARMACIA,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, f.getNombre());
			ps.setString(2, f.getEmail());
			ps.setString(3, f.getContraseña());
			ps.setString(4, f.getTelefono());
			ps.setString(5, f.getDireccion());
			ps.setString(6, f.getCodigoPostal());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				int idGenerado = rs.getInt(1);
				System.out.println("id generado en DB" + idGenerado);
				GestorDeArchivos.guardarArchivo(f.getImagenSubida(), ".jpg");
			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			System.out.println("Se EJECUTA LA SQL INSERTAR: " + e.getMessage());
		}
		desconectar();
	}

	@Override
	public boolean loginUsuarios(String email, String contraseña) {
		boolean ide = false;
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQLj.SQL_LOGIN_USUARIO);
			ps.setString(1, email);
			ps.setString(2, contraseña);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ide = true;
			}
		} catch (SQLException e) {
			System.out.println("SE EJECUTA SQL LOGIN FARMACIAS info: " + e.getMessage());
		}

		desconectar();
		return ide;
	}

}
