package server;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class Productos {

    public JSONObject buscarProducto(int idBuscado) {
        String archivo = "src\\database\\productos.json";
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
            JSONObject productos = new JSONObject(contenido);
            JSONArray arrayProductos = productos.getJSONArray("Productos");

            for (int i = 0; i < arrayProductos.length(); i++) {
                JSONObject producto = arrayProductos.getJSONObject(i);
                int id = producto.getInt("id");

                if (id == idBuscado) {
                    return producto;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Productos productos = new Productos();
        int idBuscado = 1;
        JSONObject productoEncontrado = productos.buscarProducto(idBuscado);
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado.toString());
        } else {
            System.out.println("Producto no encontrado");
        }
    }
}