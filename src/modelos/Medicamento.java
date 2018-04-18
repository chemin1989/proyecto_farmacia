package modelos;

public class Medicamento {

	private int id;
	private String nombre;
	private double precio;
	private int cantidad;
	private String codigoMedicamento;
	private int idFarmacia;
	
	private Farmacia farmacia;
	
	
	public Medicamento() {
	}


	


	public Medicamento(String nombre, double precio, int cantidad,
			String codigoMedicamento) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.codigoMedicamento = codigoMedicamento;

	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getCodigoMedicamento() {
		return codigoMedicamento;
	}


	public void setCodigoMedicamento(String codigoMedicamento) {
		this.codigoMedicamento = codigoMedicamento;
	}

	
	
	public int getIdFarmacia() {
		return idFarmacia;
	}

	public void setIdFarmacia(int idFarmacia) {
		this.idFarmacia = idFarmacia;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}





	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nombre=" + nombre + ", precio="
				+ precio + ", cantidad=" + cantidad + ", código medicamento="
				+ codigoMedicamento + ", id_farmacia=" + idFarmacia + "]";
	}


	
	
	
	
}
