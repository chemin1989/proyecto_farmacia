package daos;

import modelos.Medicamento;

public interface MedicamentosDAOreg {

	void registrarMedicamento(Medicamento medicamento, int idFarmacia);

	void guardarCambiosMedicamento(Medicamento medicamento);

	Medicamento obtenerMedicamentoPorId(int id);

	Medicamento borrarMedicamentoPorId(int id);

	
	
}
