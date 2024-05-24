package server;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import interfaces.AdminRMI;


public class ServiceAdmin extends UnicastRemoteObject implements AdminRMI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ServiceAdmin() throws RemoteException {
		super();
	}
		/*Permite autenticar al administrador, recuerde que solo tenemos un solo
		 admnistrador, el cual ya está en el administrador.json
		 El metodo recibe un string administrador que previamente fue casteado con
		 GSON para convertir el objeto de tipo admnistrador a string
		 */
		public boolean autenticarAdministrador(String administrador) {
			Gson gson = new Gson();
			Administrador admin = gson.fromJson(administrador, Administrador.class);
			String id = null;
			String password = null;
			JsonParser jsonParser = new JsonParser();
			JOptionPane.showMessageDialog(null, "Administrador inexistente", "Error", JOptionPane.ERROR_MESSAGE);

			try {
				FileReader reader = new FileReader("D:\\Usuario\\Documents\\UPB\\Troisième semestre\\ESTRUCTURAS\\RMI\\src\\database\\administrador.json");
				Object obj = jsonParser.parse(reader);
				JsonObject objectJSON = (JsonObject) obj;
				password = objectJSON.get("password").toString();
				id = objectJSON.get("id").toString();
			} catch (Exception e) {
				System.out.println("ERROR");
				JOptionPane.showMessageDialog(null, "Administrador inexistente", "Error", JOptionPane.ERROR_MESSAGE);
			}
			password = password.substring(1, password.length() - 1);
			id = id.substring(1, id.length() - 1);

			if (id.equals(admin.getId()) && password.equals(admin.getPassword())) {
				System.out.println("Autenticacion exitosa");
				return true;
			} else {
				System.out.println("Intente de nuevo");
				return false;
			}
		}
	
	@Override
	/*  Añade un operador sin eliminar los demas
		Tambien valida si el ID del operador a ingresar ya existe y si es asi retorna
 		false
		Si el ID no se encuentra en operadores.json se retorna true añadiendo el
		operador de manera exitosa
	*/
	public boolean agregarOperador(String operador) {
	
		Gson gson = new Gson();
		Operador op = gson.fromJson(operador, Operador.class);
		String archivo = "D:\\Usuario\\Documents\\UPB\\Troisième semestre\\ESTRUCTURAS\\RMI\\src\\database\\operadores.json";
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject Operador = new JSONObject(contenido);
			JSONArray operadores = Operador.getJSONArray("Operadores");
			JSONObject obj = new JSONObject();
			obj.put("id", op.getId());
			obj.put("contrasena", op.getContrasena());
			for (int i = 0; i < operadores.length(); i++) {
				String id = operadores.getJSONObject(i).getString("id");
				if (id.equals(op.getId())) {
					return false;
				}
			}
			
			operadores.put(obj);
			FileWriter fileWriter = new FileWriter(archivo);
			fileWriter.write(Operador.toString());
			fileWriter.flush();
			fileWriter.close();
			
			System.out.println(" Operador agregado ");
		} catch (Exception e) {
			System.out.println("Error al agregar operador");
			System.out.println("ERROR " + e);
		}
		return true;
	}



	@Override
	public boolean modificarOperadores(String idOperador)  {
		
		
		String archivo = "D:\\Usuario\\Documents\\UPB\\Troisième semestre\\ESTRUCTURAS\\RMI\\src\\database\\operadores.json";
		
		try {
	
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject operador = new JSONObject(contenido);
			JSONArray operadores = operador.getJSONArray("Operadores");
			for (int i = 0; i < operadores.length(); i++) {
				String id = operadores.getJSONObject(i).getString("id");
				if (idOperador.equals(id)) {
					operadores.remove(i);
					FileWriter fileWriter = new FileWriter("D:\\Usuario\\Documents\\UPB\\Troisième semestre\\ESTRUCTURAS\\RMI\\src\\database\\operadores.json");
					fileWriter.write(operador.toString());
					fileWriter.flush();
					fileWriter.close();
					JOptionPane.showMessageDialog(null, "Operador registrador", "Error", JOptionPane.ERROR_MESSAGE);

					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String mostrarOperadores()  {
		String contenido = " ";
		String archivo = "D:\\Usuario\\Documents\\UPB\\Troisième semestre\\ESTRUCTURAS\\RMI\\src\\database\\operadores.json";
		try {
			JOptionPane.showMessageDialog(null, "Mostrar Operador ", "Error", JOptionPane.ERROR_MESSAGE);

			contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			//System.out.println("contenido: " + contenido);
			return contenido;
		} catch (Exception e) {
			return e + "";
		}
	}
	 

}
