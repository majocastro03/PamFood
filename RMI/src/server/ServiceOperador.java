package server; 

import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;


import interfaces.OperadorRMI;

public class ServiceOperador extends UnicastRemoteObject implements OperadorRMI {
	
	protected ServiceOperador() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	// Permite el acceso del operador a su modulo
	public boolean autenticarOperadores(String Operador) {
		Gson gson = new Gson();
		Operador op = gson.fromJson(Operador, Operador.class);
		String archivo = "D:\\Usuario\\Documents\\UPB\\Troisième semestre\\ESTRUCTURAS\\RMI\\src\\database\\operadores.json";
		
		JOptionPane.showMessageDialog(null, "Administrador inexistente", "Error", JOptionPane.ERROR_MESSAGE); 
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject operador = new JSONObject(contenido);
			JSONArray operadores = operador.getJSONArray("Operadores");
			for (int i = 0; i < operadores.length(); i++) {
				String id = operadores.getJSONObject(i).getString("id");
				String password = operadores.getJSONObject(i).getString("contrasena");

				if (id.equals(op.getId()) && password.equals(op.getContrasena())) {
					JOptionPane.showMessageDialog(null, "Administrador inexistente", "Error", JOptionPane.ERROR_MESSAGE);
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Añade un cliente siempre y cuando este no este registrado, la validacion se
	// realiza con el numero de telefono
	// Si el cliente ya existe se devuelve false
	// En el caso contrario se añade correctamente y devuelve true
	public boolean agregarCliente(String cliente)  {
		
		Gson gson = new Gson();
		User client = gson.fromJson(cliente, User.class);
		String archivo = "D:\\Usuario\\Documents\\UPB\\Troisième semestre\\ESTRUCTURAS\\RMI\\src\\database\\clientes.json";
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject Cliente = new JSONObject(contenido);
			JSONArray clientes = Cliente.getJSONArray("Clientes");
			JSONObject obj = new JSONObject();
			obj.put("nombre", client.getNombre());
			obj.put("telefono", client.getTelefono());
			obj.put("direccion", client.getDireccion());
			obj.put("prioridad", client.getPrioridad());
			JSONObject producto = new JSONObject();
			producto.put("nombre", client.getProductos().getNombre());
			producto.put("precio", client.getProductos().getPrecio());
			producto.put("prioridad", client.getProductos().getPrioridad());
			obj.put("producto", producto);
			for (int i = 0; i < clientes.length(); i++) {
				String telefono = clientes.getJSONObject(i).getString("telefono");
				if (telefono.equals(client.getTelefono())) {
					return false;
				}
			}
			clientes.put(obj);
			FileWriter fileWriter = new FileWriter(archivo);
			fileWriter.write(Cliente.toString());
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		return true;
	}
	

	public boolean autenticarCliente(String telefonoCliente) {
		String userDir = System.getProperty("user.dir");
		String filePath = userDir + File.separator + "src" + File.separator + "database" + File.separator + "operadores.json";
		System.out.println(telefonoCliente);
		String telefono = "";
		String archivo = "database\\clientes.json";
		JOptionPane.showMessageDialog(null, archivo, "Error", JOptionPane.ERROR_MESSAGE);

		try {
			File file = new File(archivo);
			FileReader fr = new FileReader(file); 			
//			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			
			
			BufferedReader buffer = new BufferedReader(fr);
			String contenido="";
			String line = buffer.readLine();
			while(line!=null) {
				contenido+=line;
				line=buffer.readLine();
			}
					
			JSONObject cliente = new JSONObject(contenido);
			JSONArray clientes = cliente.getJSONArray("Clientes");
			for (int i = 0; i < clientes.length(); i++) {
				JSONObject jsonClient = clientes.getJSONObject(i);
				telefono = jsonClient.get("telefono").toString();
				if (telefonoCliente.equals(telefono)) {
					System.out.println("El cliente ya existe");
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	
	public boolean agregarCliente1(String cliente, int idProducto) throws IOException {
	
		Gson gson = new Gson();
		User  client = gson.fromJson(cliente, User.class);
		
		String archivo = "D:\\Usuario\\Documents\\UPB\\Troisième semestre\\ESTRUCTURAS\\RMI\\src\\database\\clientes.json";
	try {
		String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
		JSONObject Cliente = new JSONObject(contenido);
		JSONArray clientes = Cliente.getJSONArray("Clientes");
		JSONObject obj = new JSONObject();
		obj.put("nombre", client.getNombre());
		obj.put("telefono", client.getTelefono());
		obj.put("direccion", client.getDireccion());
		obj.put("prioridad", client.getPrioridad());
		JSONObject producto = new JSONObject();
		producto.put("nombre", client.getProductos().getNombre());
		producto.put("precio", client.getProductos().getPrecio());
		producto.put("prioridad", client.getProductos().getPrioridad());
		obj.put("producto", producto);
		for (int i = 0; i < clientes.length(); i++) {
			String telefono = clientes.getJSONObject(i).getString("telefono");
			if (telefono.equals(client.getTelefono())) {
				return false;
			}
		}
		clientes.put(obj);
		FileWriter fileWriter = new FileWriter(archivo);
		fileWriter.write(Cliente.toString());
		fileWriter.flush();
		fileWriter.close();
	} catch (Exception e) {
		System.out.println("ERROR");
	}
	return true;
	}

	

	public JSONObject buscarProducto(int id, String archivo) throws IOException {
	    String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
	    JSONArray productos = new JSONArray(contenido);
	    for (int i = 0; i < productos.length(); i++) {
	        int idProducto = productos.getJSONObject(i).getInt("id");
	        if (idProducto == id) {
	            return productos.getJSONObject(i);
	        }
	    }
	    return null;
	}
	
	
	@Override
	public boolean agregarPedido(String user, String pedido) {
		return false;
		}
	
	
	
	
	
}