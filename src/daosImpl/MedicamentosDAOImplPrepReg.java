package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constantesSQL.ConstantesSQLE;
import modelos.Medicamento;
import daos.GenericDAO;
import daos.MedicamentosDAOPrepReg;

public class MedicamentosDAOImplPrepReg extends GenericDAO implements MedicamentosDAOPrepReg{

	@Override
	public List<Medicamento> obtenerDatosMedicamentos(String busquedaDatos) {
		conectar();
		List<Medicamento> datosMedicamentos = new ArrayList<Medicamento>();
		
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQLE.SQL_OBTENER_DATOS_MEDICAMENTOS);
			
			ps.setString(1, "%"+busquedaDatos+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Medicamento datosMedicamento = new Medicamento();
				datosMedicamento.setId(rs.getInt("id"));
				datosMedicamento.setNombre(rs.getString("nombre"));
				datosMedicamento.setPrecio(rs.getDouble("pvp"));
				datosMedicamento.setCodigoMedicamento(rs.getString("codigo"));
				
				datosMedicamentos.add(datosMedicamento);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Posiblemente la sql esté mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		desconectar();
		
		return datosMedicamentos;
	}

	@Override
	public Medicamento obtenerMedicamentoPorId(int id) {
		conectar();
		Medicamento medicamento = new Medicamento();
		
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQLE.SQL_OBTENER_MEDICAMENTO_POR_ID);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				medicamento.setNombre(rs.getString("nombre"));
				medicamento.setPrecio(rs.getDouble("pvp"));
				medicamento.setCodigoMedicamento(rs.getString("codigo"));
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Seguramente la sql esté mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		desconectar();
		return medicamento;
	}

	
	
}
