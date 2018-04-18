package daos;

import java.util.List;

import modelos.Medicamento;

public interface MedicamentosDAOListFarm {

	List<Medicamento> obtenerMedicamentosFarmacia (int idFarmacia);
	
	List<Medicamento> obtenerMedicamentos (int desde, int cuantos, String busqueda);
	
	int obtenerTotalMedicamentos(String busqueda);
	
}
