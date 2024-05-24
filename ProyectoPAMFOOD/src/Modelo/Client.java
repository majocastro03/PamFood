package Modelo;

import java.time.LocalDateTime;

public class Client {

    String nombre, direccion;
    String telefono;
    
	public Client(String nombre, String telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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



    

}

