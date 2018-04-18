package modelos;

import javax.servlet.http.Part;

public class Farmacia {

	private	String nombre;
	private String contraseña;
	private String direccion;
	private String telefono;
	private String email;
	private String codigoPostal;
	private Part imagenSubida;
	private String rutaImagen;
	private int id;
	
	public Farmacia() {
		
	}

	public Farmacia(String nombre, String contraseña, String direccion, String telefono, String email,
			String codigoPostal, Part imagenSubida) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.codigoPostal = codigoPostal;
		this.imagenSubida = imagenSubida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Part getImagenSubida() {
		return imagenSubida;
	}

	public void setImagenSubida(Part imagenSubida) {
		this.imagenSubida = imagenSubida;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Farmacia [nombre=" + nombre + ", contraseña=" + contraseña + ", direccion=" + direccion + ", telefono="
				+ telefono + ", email=" + email + ", codigoPostal=" + codigoPostal + ", imagenSubida=" + imagenSubida
				+ ", rutaImagen=" + rutaImagen + ", id=" + id + "]";
	}
	
}