package daos;

import modelos.Farmacia;

public interface FarmaciasDAOreg {

	void registrarFarmacia(Farmacia f);
	
	boolean loginUsuarios(String email, String contraseña);
}
