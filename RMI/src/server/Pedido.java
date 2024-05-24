package server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Pedido {

    public static boolean agregarPedido(User user, Producto producto) {
    	String archivo = "src\\database\\pedidos.json";
     
        // Si el archivo no existe, se crea

        // Se lee el archivo para verificar si el usuario ya existe
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
            JSONObject pedidos = new JSONObject(contenido);

            JSONArray arrUsuarios = pedidos.getJSONArray("Pedidos");

            boolean usuarioEncontrado = false;

            // Se busca si el usuario ya existe
            for (int i = 0; i < arrUsuarios.length(); i++) {
                JSONObject objUsuario = arrUsuarios.getJSONObject(i);
                if (objUsuario.getString("telefono").equals(user.getTelefono())) {
                    JSONArray arrProductos = objUsuario.getJSONArray("productos");
                    JSONObject objProducto = new JSONObject();
                    objProducto.put("nombre", producto.getNombre());
                    objProducto.put("precio", producto.getPrecio());
                    objProducto.put("prioridad", producto.getPrioridad());
                    arrProductos.put(objProducto);
                    usuarioEncontrado = true;
                    break;
                }
            }

            // Si el usuario no existe, se crea un nuevo usuario con el producto
            if (!usuarioEncontrado) {
                JSONObject objUsuario = new JSONObject();
                objUsuario.put("nombre", user.getNombre());
                objUsuario.put("direccion", user.getDireccion());
                objUsuario.put("telefono", user.getTelefono());
                objUsuario.put("prioridad", user.getPrioridad());
                JSONArray arrProductos = new JSONArray();
                JSONObject objProducto = new JSONObject();
                objProducto.put("nombre", producto.getNombre());
                objProducto.put("precio", producto.getPrecio());
                objProducto.put("prioridad", producto.getPrioridad());
                objProducto.put("id", producto.getId());
                arrProductos.put(objProducto);
                objUsuario.put("productos", arrProductos);
                arrUsuarios.put(objUsuario);
            }

            // Se escribe el archivo
            FileWriter fileWriter = new FileWriter(archivo);
            fileWriter.write(pedidos.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de pedidos");
            e.printStackTrace();
            return false;
        }

        return true;
    }
    
    
    public static String obtenerUltimoProducto(String telefono) {
    	String archivo = "src\\database\\pedidos.json";
        
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
            JSONObject pedidos = new JSONObject(contenido);
            JSONArray clientes = pedidos.getJSONArray("Pedidos");
            for (int i = 0; i < clientes.length(); i++) {
                JSONObject cliente = clientes.getJSONObject(i);
                if (cliente.getString("telefono").equals(telefono)) {
                    JSONArray productos = cliente.getJSONArray("productos");
                    JSONObject ultimoProducto = productos.getJSONObject(productos.length() - 1);
                    return ultimoProducto.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String obtenerUsuarioPorTelefono(String telefono) {
        String archivo = "src\\database\\pedidos.json";

        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
            JSONObject pedidos = new JSONObject(contenido);

            JSONArray arrUsuarios = pedidos.getJSONArray("Pedidos");

            // Se busca si el usuario existe
            for (int i = 0; i < arrUsuarios.length(); i++) {
                JSONObject objUsuario = arrUsuarios.getJSONObject(i);
                if (objUsuario.getString("telefono").equals(telefono)) {
                    String nombre = objUsuario.getString("nombre");
                    String direccion = objUsuario.getString("direccion");
               
                    // Se devuelve el usuario encontrado
                    Gson gson = new Gson();
                    User usera =  new User(nombre, direccion, telefono) ;
                    String user = gson.toJson(usera);
                    return user;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de pedidos");
            e.printStackTrace();
        }

        // Si no se encuentra el usuario, se devuelve null
        return null;
    }


    
    public static void main(String[] args) throws IOException {
		Pedido pedid = new Pedido(); 
		
		User user = new User("Ana", "Giron", "3");
		Producto comida1 = new Producto("Gaseosa", 3000, 2, 001);
		pedid.agregarPedido(user, comida1);
		System.out.println(pedid.obtenerUltimoProducto("3"));
		System.out.println(pedid.obtenerUsuarioPorTelefono("3"));
		System.out.println("ewd");
	}
}
