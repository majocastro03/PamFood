package Vistas;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.google.gson.Gson;

import Controlador.Methods;
import Controlador.Operador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

@SuppressWarnings("serial")
public class InicioOperador extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField password;
	private JTextField direccion;
	private Methods controlador = new Methods();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioOperador frame = new InicioOperador();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InicioOperador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\maria\\OneDrive - UPB\\UPB\\3 SEMESTRE\\Estructuras de Datos\\Proyecto Integrador\\ProyectoPAMFOOD\\src\\Imagenes\\huevo.png"));
		setTitle("PAMFOOD");
		setBackground(new Color(235, 69, 95));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(938, 684);
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

		JLabel nuevoCliente = new JLabel("Autenticación");
		nuevoCliente.setForeground(new Color(30, 144, 255));
		nuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		nuevoCliente.setFont(new Font("Cocogoose", Font.PLAIN, 30));
		nuevoCliente.setBounds(45, 21, 757, 40);
		panel_1.add(nuevoCliente);

		id = new JTextField();
		id.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				id.setText("");
				id.setForeground(Color.BLACK);
			}

		});
		id.setForeground(Color.LIGHT_GRAY);
		id.setFont(new Font("Times New Romance", Font.PLAIN, 25));
		// id.setText("Id");
		id.setBounds(45, 70, 333, 40);
		panel_1.add(id);
		id.setColumns(10);

		password = new JTextField();
		password.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				password.setText("");
				password.setForeground(Color.BLACK);
			}

		});
		password.setForeground(Color.LIGHT_GRAY);
		password.setFont(new Font("Times New Romance", Font.PLAIN, 25));
		password.setColumns(10);
		password.setBounds(469, 71, 333, 40);
		panel_1.add(password);
		Gson gson = new Gson();
		JButton btnRegistarCliente = new JButton("Autenticar");
		btnRegistarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operador operador = new Operador(id.getText(), password.getText());
				String Operador = gson.toJson(operador);
				boolean a = controlador.autenticarOperadores(Operador);
				if (a) {
					new Inicio().setVisible(true);
					dispose();
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