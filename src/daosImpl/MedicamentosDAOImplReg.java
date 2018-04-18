package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import constantesSQL.ConstantesSQLc;
import modelos.Medicamento;
import daos.GenericDAO;
import daos.MedicamentosDAOreg;

public class MedicamentosDAOImplReg extends GenericDAO implements MedicamentosDAOreg {

	@Override
	public void registrarMedicamento(Medicamento medicamento, int idFarmacia) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQLc.SQL_INSERCION_MEDICAMENTO);
			ps.setString(1, medicamento.getNombre());
			ps.setDouble(2, medicamento.getPrecio());
			ps.setInt(3, medicamento.getCantidad());
			ps.setString(4, medicamento.getCodigoMedicamento());
			ps.setInt(5, idFarmacia);
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL REG MEDICAMENTO" + e.getMessage());
			
		}
		desconectar();
	}

	@Override
	public void guardarCambiosMedicamento(Medicamento medicamento) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQLc.GUARDAR_CAMBIOS_MEDICAMENTOS);
			ps.setInt(1, medicamento.getCantidad());
			ps.setInt(2, medicamento.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL GUARDAR CAMBIOS MED" + e.getMessage());
		
		}desconectar();
	}


	@Override
	public Medicamento obtenerMedicamentoPorId(int id) {
		conectar();
		Medicamento medicamento = new Medicamento();

		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQLc.OBTENER_MEDICAMENTO_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				medicamento.setNombre(rs.getString("nombre"));
				medicamento.setPrecio(rs.getDouble("precio"));
				medicamento.setCodigoMedicamento(rs.getString("codigo"));
				medicamento.setCantidad(rs.getInt("cantidad"));	
				medicamento.setId(id);
				ps.close();
			}
		} catch (SQLException e) {
			System.out.println("SQL BORRAR MEDICAMENTO" + e.getMessage());
		}

		desconectar();
		return medicamento;
		
	}

	@Override
	public Medicamento borrarMedicamentoPorId(int id) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQLc.SQL_BORRAR_MEDICAMENTO_POR_ID);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL BORRAR MEDICAMENTO POR ID" + e.getMessage());
			
		}
		desconectar();
		return null;
	}
		
	}
	

