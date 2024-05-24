package server;

import org.json.JSONException;
import org.json.JSONObject;

public class User {



	String nombre, direccion, telefono;
	Producto productos;
	int prioridad ; 
	/*
	public User(JSONObject jsonObject) throws JSONException {
		this.nombre = jsonObject.getString("nombre");
		this.direccion = jsonObject.getString("direccion");
		this.telefono = jsonObject.getString("telefono");
		this.prioridad = jsonObject.getString("prioridad");
		JSONObject producto = jsonObject.getJSONObject("producto");
		this.productos = new Producto(producto);
	}*/
	
	public JSONObject toJSONObject() throws JSONException {
		JSONObject jsonClient = new JSONObject();
		jsonClient.put("nombre", this.nombre);
		jsonClient.put("direccion", this.direccion);
		jsonClient.put("telefono", this.telefono);
		jsonClient.put("prioridad", this.prioridad);
		jsonClient.put("producto", this.productos);
		return jsonClient;
	}

	public User(String nombre, String direccion, String telefono) {
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

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}
	
	
}





