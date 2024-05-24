package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.DropMode;

public class VistaFactura extends JFrame {

    private JTextField telefonoField;
    private JTextArea facturaArea;

    public VistaFactura() {
        initComponents();
    }

    private void initComponents() {
        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoLabel.setBounds(10, 10, 80, 20);
        getContentPane().add(telefonoLabel);

        telefonoField = new JTextField();
        telefonoField.setBounds(100, 10, 150, 20);
        getContentPane().add(telefonoField);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBounds(489, 10, 80, 20);
        getContentPane().add(buscarButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 340, 200);
        getContentPane().add(scrollPane);

        facturaArea = new JTextArea();
        facturaArea.setDropMode(DropMode.INSERT);
        scrollPane.setViewportView(facturaArea);

        buscarButton.addActionListener(new ActionListener() {
         
			@Override
			public void actionPerformed(ActionEvent e) {

                String telefono = telefonoField.getText();
                String producto = obtenerUltimoProducto(telefono);

                if (producto != null) {
                    JSONObject objProducto = new JSONObject(producto);

                    String factura = "Cliente:\n" + "Teléfono: " + telefono + "\n" +
                                      "Nombre: " + objProducto.getString("nombre") + "\n" +
                                      "Precio: " + objProducto.getDouble("precio") + "\n" +
                                      "Prioridad: " + objProducto.getInt("prioridad") + "\n";

                    facturaArea.setText(factura);
                } else {
                    facturaArea.setText("No se encontraron productos para el cliente con el teléfono " + telefono);
                }
            
				
			}
        });

        setTitle("Factura");
        setSize(611, 302);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
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

    public static void main(String[] args) {
        new VistaFactura();
    }
}
