package daos;

import java.util.List;

import modelos.Medicamento;

public interface MedicamentosDAOPrepReg {

	List<Medicamento> obtenerDatosMedicamentos (String busquedaDatos);
	Medicamento obtenerMedicamentoPorId (int id);
}