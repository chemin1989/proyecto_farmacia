package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constantesSQL.ConstantesSQLE;
import modelos.Farmacia;
import modelos.Medicamento;
import daos.GenericDAO;
import daos.MedicamentosDAOListFarm;

public class MedicamentosDAOImplListFarm extends GenericDAO implements MedicamentosDAOListFarm {

	@Override
	public List<Medicamento> obtenerMedicamentosFarmacia(int idFarmacia) {
		List<Medicamento> medicamentosFarmacia = new ArrayList<Medicamento>();
		
				
		conectar();
		
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQLE.SQL_LISTAR_MEDICAMENTOS_FARMACIA);
			
			ps.setInt(1, idFarmacia);
			ResultSet resultado = ps.executeQuery();
			
			while (resultado.next()) {
				Medicamento medicamentoFarmacia = new Medicamento();
				medicamentoFarmacia.setNombre(resultado.getString("nombre"));
				medicamentoFarmacia.setPrecio(resultado.getDouble("precio"));
				medicamentoFarmacia.setCantidad(resultado.getInt("cantidad"));
				medicamentoFarmacia.setCodigoMedicamento(resultado.getString("codigo"));
				medicamentosFarmacia.add(medicamentoFarmacia);
			}
				
				resultado.close();
				ps.close();
		} catch (SQLException e) {
			System.out.println("sql select medicamentos está mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		desconectar();
		return medicamentosFarmacia;
	}

	@Override
	public List<Medicamento> obtenerMedicamentos(int desde, int cuantos, String busqueda) {
		
		conectar();
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQLE.SQL_OBTENER_MEDICAMENTOS);
			
			ps.setString(1, "%"+busqueda+"%");
			ps.setInt(2, desde);
			ps.setInt(3, cuantos);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Medicamento medicamento = new Medicamento();
				medicamento.setNombre(rs.getString("nombre"));
				medicamento.setPrecio(rs.getDouble("precio"));
				medicamento.setCantidad(rs.getInt("cantidad"));
				medicamento.setCodigoMedicamento(rs.getString("codigo"));
				medicamento.setId(rs.getInt("id"));
				
				Farmacia farmacia = new Farmacia();
				farmacia.setNombre(rs.getString("nombre_farmacia"));
				farmacia.setEmail(rs.getString("email"));
				farmacia.setTelefono(rs.getString("telefono"));
				farmacia.setDireccion(rs.getString("direccion"));
				
				medicamento.setFarmacia(farmacia);
				
				medicamentos.add(medicamento);
			}
				rs.close();
				ps.close();
				
		} catch (SQLException e) {
			System.out.println("Posiblemente la sql esté mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		desconectar();
		return medicamentos;
	}

	@Override
	public int obtenerTotalMedicamentos(String busqueda) {
		conectar();
		int total = 0;
		
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQLE.SQL_CANTIDAD_TOTAL_MEDICAMENTOS);
			
			ps.setString(1, "%"+busqueda+"%");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				total = rs.getInt("total");
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("La sql puede estar mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		desconectar();
		return total;
	}

	
	
}
