package Vistas;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.google.gson.Gson;

import Controlador.Client;
import Controlador.Methods;
import Controlador.Producto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
@SuppressWarnings("serial")
public class Registro extends JFrame {
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField numero;
	private JTextField direccion;
	private Methods controlador = new Methods();  

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Registro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Imagenes\\huevo.png"));
		setTitle("PAMFOOD");
		setBackground(new Color(235, 69, 95));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(938,684);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 69, 95));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(75, 0, 130));
		panel.setBackground(new Color(255, 240, 245));
		

		panel.setBounds(0, 92, 937, 568);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setBounds(31, 31, 859, 329);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel nuevoCliente = new JLabel("Nuevo cliente");
		nuevoCliente.setForeground(new Color(30, 144, 255));
		nuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		nuevoCliente.setFont(new Font("Cocogoose", Font.PLAIN, 30));
		nuevoCliente.setBounds(45, 21, 757, 40);
		panel_1.add(nuevoCliente);
		
		nombre = new JTextField();
		nombre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				nombre.setText("");
				nombre.setForeground(Color.BLACK);
			}
			
		});
		nombre.setForeground(Color.LIGHT_GRAY);
		nombre.setFont(new Font("Times New Romance", Font.PLAIN, 25));
		nombre.setText("Nombre");
		nombre.setBounds(45, 70, 333, 40);
		panel_1.add(nombre);
		nombre.setColumns(10);
		
		numero = new JTextField();
		numero.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				numero.setText("");
				numero.setForeground(Color.BLACK);
			}
			
		});
		numero.setText("Numero de telefono");
		numero.setForeground(Color.LIGHT_GRAY);
		numero.setFont(new Font("Times New Romance", Font.PLAIN, 25));
		numero.setColumns(10);
		numero.setBounds(469, 71, 333, 40);
		panel_1.add(numero);
		
		direccion = new JTextField();
		direccion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				direccion.setText("");
				direccion.setForeground(Color.BLACK);
			}
			
		});
		direccion.setText("Direccion");
		direccion.setForeground(Color.LIGHT_GRAY);
		direccion.setFont(new Font("Times New Romance", Font.PLAIN, 25));
		direccion.setColumns(10);
		direccion.setBounds(45, 135, 757, 40);
		panel_1.add(direccion);
		
		JButton btnRegistarCliente = new JButton("Registrar cliente");
		btnRegistarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Gson gson = new Gson();
					Producto producto = new Producto("Producto", "10.000", 1);
					Client cliente = new Client(nombre.getText(), numero.getText(), direccion.getText(), "1", producto);
					String Cliente = gson.toJson(cliente);
					boolean a = controlador.agregarCliente(Cliente);
					if(a) {
						new Inicio().setVisible(true);
						new Aviso().setVisible(true);
						dispose();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegistarCliente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {		
			}
			
			public void mouseEntered(MouseEvent e) {
				btnRegistarCliente.setForeground(new Color(255, 250, 205));
				btnRegistarCliente.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btnRegistarCliente.setForeground(new Color(255, 215, 0));
				btnRegistarCliente.setBackground(new Color(255, 250, 205));
			}
			
			
		});
		btnRegistarCliente.setForeground(new Color(255, 215, 0));
		btnRegistarCliente.setFont(new Font("Cocogoose", Font.PLAIN, 25));
		btnRegistarCliente.setFocusable(false);
		btnRegistarCliente.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnRegistarCliente.setBackground(new Color(255, 250, 205));
		btnRegistarCliente.setBounds(273, 213, 316, 64);
		panel_1.add(btnRegistarCliente);
		
		JButton btnSalir = new JButton("Salir");
		
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();		
			}
			public void mouseEntered(MouseEvent e) {
				btnSalir.setForeground(new Color(235, 69, 95));
				btnSalir.setBackground(Color.WHITE);
			}
			
			public void mouseExited(MouseEvent e) {
				btnSalir.setForeground(Color.WHITE);
				btnSalir.setBackground(new Color(235, 69, 95));
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Cocogoose", Font.PLAIN, 25));
		btnSalir.setFocusable(false);
		btnSalir.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnSalir.setBackground(new Color(235, 69, 95));
		btnSalir.setBounds(304, 458, 316, 64);
		panel.add(btnSalir);
		
		JLabel titulo = new JLabel("PAMFOOD");
		titulo.setBounds(31, 10, 355, 77);
		contentPane.add(titulo);
		titulo.setForeground(new Color(255, 240, 245));
		titulo.setFont(new Font("The Bold Font", Font.PLAIN, 48));
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new Inicio().setVisible(true);		
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				btnAtras.setForeground(new Color(235, 69, 95));
				btnAtras.setBackground(Color.WHITE);
			}
			
			public void mouseExited(MouseEvent e) {
				btnAtras.setForeground(Color.WHITE);
				btnAtras.setBackground(new Color(235, 69, 95));
			}
		});
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Cocogoose", Font.PLAIN, 18));
		btnAtras.setFocusable(false);
		btnAtras.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnAtras.setBackground(new Color(235, 69, 95));
		btnAtras.setBounds(762, 35, 134, 39);
		contentPane.add(btnAtras);
	}
}