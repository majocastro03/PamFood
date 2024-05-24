package Controlador;

public class Operador {

	private String id;
	private String contrasena;

	public Operador(String id, String contrasena) {
		this.id = id;
		this.contrasena = contrasena;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean ingresar(String provideId, String providepassword, String id, String password) {
		if (provideId.equals(id) && providepassword.equals(password)) {
			System.out.println("Autenticacion exitosa");
			return true;
		} else {
			System.out.println("Intente de nuevo");
			return false;
		}

	}
}
