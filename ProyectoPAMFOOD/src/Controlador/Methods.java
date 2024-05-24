package Controlador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Modelo.Administrador;

public class Methods {
	// Permite autenticar al administrador, recuerde que solo tenemos un solo
	// admnistrador, el cual ya está en el administrador.json
	// El metodo recibe un string administrador que previamente fue casteado con
	// GSON para convertir el objeto de tipo admnistrador a string
	public boolean autenticarAdministrador(String administrador) {
		Gson gson = new Gson();
		Administrador admin = gson.fromJson(administrador, Administrador.class);
		String id = null;
		String password = null;
		JsonParser jsonParser = new JsonParser();

		try {
			FileReader reader = new FileReader("src\\database\\administrador.json");
			Object obj = jsonParser.parse(reader);
			JsonObject objectJSON = (JsonObject) obj;
			password = objectJSON.get("password").toString();
			id = objectJSON.get("id").toString();
		} catch (Exception e) {
			System.out.println("ERROR");
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

	// Añade un operador sin eliminar los demas
	// Tambien valida si el ID del operador a ingresar ya existe y si es asi retorna
	// false
	// Si el ID no se encuentra en operadores.json se retorna true añadiendo el
	// operador de manera exitosa
	public boolean agregarOperador(String operador) throws IOException, JSONException {
		Gson gson = new Gson();
		Operador op = gson.fromJson(operador, Operador.class);
		String archivo = "src\\database\\operadores.json";
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
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		return true;

	}

	// Permite al administrador visualizar los operadores
	// Retonar un string para ser mostrado en pantalla
	public String mostrarOperadores() {
		String contenido = " ";
		String archivo = "src\\database\\operadores.json";
		try {
			contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			return contenido;
		} catch (Exception e) {
			return "ERROR";
		}
	}

	// Permite al admnistrador eliminar un operador apartir de su ID
	// Retorna true si el operador se elimina correctamente
	public boolean modificarOperadores(String idOperador) {
		String archivo = "src\\database\\operadores.json";
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject operador = new JSONObject(contenido);
			JSONArray operadores = operador.getJSONArray("Operadores");
			for (int i = 0; i < operadores.length(); i++) {
				String id = operadores.getJSONObject(i).getString("id");
				if (idOperador.equals(id)) {
					operadores.remove(i);
					FileWriter fileWriter = new FileWriter("src\\database\\operadores.json");
					fileWriter.write(operador.toString());
					fileWriter.flush();
					fileWriter.close();
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	// Permite el acceso del operador a su modulo
	public boolean autenticarOperadores(String Operador) {
		Gson gson = new Gson();
		Operador op = gson.fromJson(Operador, Operador.class);
		String archivo = "src\\database\\operadores.json";
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject operador = new JSONObject(contenido);
			JSONArray operadores = operador.getJSONArray("Operadores");
			for (int i = 0; i < operadores.length(); i++) {
				String id = operadores.getJSONObject(i).getString("id");
				String password = operadores.getJSONObject(i).getString("contrasena");

				if (id.equals(op.getId()) && password.equals(op.getContrasena())) {
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
	public boolean agregarCliente(String cliente) throws IOException {
		Gson gson = new Gson();
		Client client = gson.fromJson(cliente, Client.class);
		String archivo = "src\\database\\clientes.json";
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

	// Retonar un string con los clientes en el clientes.json
	public String mostrarClientes() {
		String contenido = " ";
		String archivo = "src\\database\\clientes.json";
		try {
			contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			return contenido;
		} catch (Exception e) {
			return "ERROR";
		}
	}

	// Es un metodo extra para la autenticación
	// NO ME DECIDÍ SI BORRARLO O NO, OKI?
	public boolean autenticarCliente(String telefonoCliente) {
		System.out.println(telefonoCliente);
		String telefono = "";
		String archivo = "src\\database\\clientes.json";
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject cliente = new JSONObject(contenido);
			JSONArray clientes = cliente.getJSONArray("myArrayList");
			for (int i = 0; i < clientes.length(); i++) {
				JSONObject jsonClient = clientes.getJSONObject(i);
				telefono = jsonClient.get("telefono").toString();
				System.out.println(telefono);
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

	// Ingresa un pedido con todos sus atributos correspondiente al pedidos.json
	public boolean ingresarPedido(String pedido) throws JSONException, IOException {
		Gson gson = new Gson();
		Pedido pd = gson.fromJson(pedido, Pedido.class);
		String archivo = "src\\database\\pedidos.json";
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject Pedido = new JSONObject(contenido);
			JSONArray pedidos = Pedido.getJSONArray("Pedidos");
			JSONObject pedidoJSON = new JSONObject();
			JSONObject clientJSON = new JSONObject();

			clientJSON.put("nombre", pd.getCliente().getNombre());
			clientJSON.put("telefono", pd.getCliente().getTelefono());
			clientJSON.put("direccion", pd.getCliente().getDireccion());
			clientJSON.put("prioridad", pd.getCliente().getPrioridad());
			JSONObject productJSON = new JSONObject();
			productJSON.put("nombre", pd.getCliente().getProductos().getNombre());
			productJSON.put("precio", pd.getCliente().getProductos().getPrecio());
			productJSON.put("prioridad", pd.getCliente().getProductos().getPrioridad());
			clientJSON.put("producto", productJSON);
			pedidoJSON.put("cliente", clientJSON);
			pedidoJSON.put("id", pd.getId());
			pedidos.put(pedidoJSON);
			FileWriter fileWriter = new FileWriter(archivo);
			fileWriter.write(Pedido.toString());
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	//Obtiene el ID del ultimo pedido
	public int obtenerID() {
		String archivo = "src\\database\\pedidos.json";
		String id = null;
		int idPedido = 0;
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject Pedido = new JSONObject(contenido);

			JSONArray pedidos = Pedido.getJSONArray("Pedidos");
			System.out.println(pedidos);
			for (int i = 0; i < pedidos.length(); i++) {
				 id = pedidos.getJSONObject(i).getString("id");
			}
			idPedido = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idPedido;
	}
	//Permite ver los productos al administrador
	public String mostrarProductos() {
		String contenido = " ";
		String archivo = "src\\database\\productos.json";
		try {
			contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			return contenido;
		} catch (Exception e) {
			return "ERROR";
		}
	}
	public String editarProducto(int id) {
		Methods metodo = new Methods();
		Gson gson = new Gson();
		String stringProducto = null;
		int identificacion = 0;
		String ID = null;
		String archivo = "src\\database\\productos.json";
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject producto = new JSONObject(contenido);
			JSONArray productos = producto.getJSONArray("Productos");
			for (int i = 0; i < productos.length(); i++) {
				JSONObject jsonClient = productos.getJSONObject(i);
				ID = jsonClient.get("id").toString();
				identificacion = Integer.parseInt(ID);
				if (identificacion == id) {
					stringProducto = gson.toJson(jsonClient);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stringProducto;

	}
	public boolean editarPrecioProducto(String stringProducto, String precio) {
		Gson gson = new Gson();
		Producto pd = gson.fromJson(stringProducto, Producto.class);
		int identificacion = 0;
		String ID = null;
		String archivo = "src\\database\\productos.json";
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject Producto = new JSONObject(contenido);
			JSONArray productos = Producto.getJSONArray("Productos");
			JSONObject pedidoJSON = new JSONObject();
			System.out.println(pd.getNombre());
			System.out.println(stringProducto);
			System.out.println(pd.getId());
			FileWriter fileWriter = new FileWriter(archivo);
			fileWriter.write(Producto.toString());
			fileWriter.flush();
			fileWriter.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
	//Permite buscar un producto con su id
	public String buscarProducto(int id) {
		Gson gson = new Gson();
		String stringProducto = null;
		int identificacion = 0;
		String ID = null;
		String archivo = "src\\database\\productos.json";
		try {
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
			JSONObject producto = new JSONObject(contenido);
			JSONArray productos = producto.getJSONArray("Productos");
			for (int i = 0; i < productos.length(); i++) {
				JSONObject jsonClient = productos.getJSONObject(i);
				ID = jsonClient.get("id").toString();
				identificacion = Integer.parseInt(ID);
				if (identificacion == id) {
					stringProducto = gson.toJson(jsonClient);
					return stringProducto;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stringProducto;

	}
	// Todo el main son pruebas, no lo borre porque me fue útil y así puede tener
	// una idea para implementar en la interfaz
	public static void main(String[] args) throws Exception {

		Methods metodo = new Methods();
		Gson gson = new Gson();
		/*
		 * String Cliente = gson.toJson(cliente); metodo.agregarCliente(Cliente);
		 * Operador operador = new Operador("1234", "1234"); String Operador =
		 * gson.toJson(operador); System.out.println(metodo.agregarOperador(Operador));
		 * System.out.println(metodo.mostrarClientes());
		 * System.out.println(metodo.mostrarOperadores());
		 * System.out.println(metodo.autenticarCliente("3167836748")); Administrador
		 * administrador = new Administrador("administrador", "pamfood"); String admin =
		 * gson.toJson(administrador); metodo.autenticarAdministrador(admin);
		 * System.out.println(metodo.mostrarOperadores());
		 * System.out.println(metodo.modificarOperadores("1234"));
		 * 
		 * System.out.println(metodo.mostrarClientes());
		 * System.out.println(metodo.autenticarCliente("3167836748"));
		 * metodo.agregarCliente("Hola");
		 * 
		 * metodo.mostrarClientes();
		 * 
		 * Producto pro01 = new Producto("Bowl pollito", "10.000", "1");
		 * LinkedList<Producto> productos = new LinkedList<Producto>();
		  
		 productos.add(pro01); productos.add(pro01); //String producto =
		 gson.toJson(productos)
		 Client cliente = new Client("Daniel", "Provenza",
		 "3016679731", "1", pro01);
		 String Cliente = gson.toJson(cliente); 
		 Pedido pedido = new Pedido(cliente, "0002"); metodo.agregarCliente(Cliente); 
		 String Pedido = gson.toJson(pedido); metodo.ingresarPedido(Pedido);
	*/
		System.out.println(metodo.editarPrecioProducto(metodo.editarProducto(2), "20.000"));
		System.out.println(metodo.buscarProducto(4));
	}
}
