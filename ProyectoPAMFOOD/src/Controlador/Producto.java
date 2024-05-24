package Controlador;

import org.json.JSONException;
import org.json.JSONObject;

public class Producto {
	String nombre, precio;
	int id, prioridad;
	
	public Producto(JSONObject jsonObject) throws JSONException {
		this.nombre = jsonObject.getString("nombre");
		this.precio = jsonObject.getString("precio");
		this.prioridad = jsonObject.getInt("prioridad");
		this.id = jsonObject.getInt("id");
	}
	public JSONObject toJSONObject() throws JSONException {
		JSONObject jsonProducto = new JSONObject();
		jsonProducto.put("nombre", this.nombre);
		jsonProducto.put("precio", this.precio);
		jsonProducto.put("prioridad", this.prioridad);
		jsonProducto.put("id", this.id);
		return jsonProducto;
	}
	public Producto(String nombre, String precio, int prioridad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.prioridad = prioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", prioridad=" + prioridad + "]";
	}
	
}
