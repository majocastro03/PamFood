package Vistas;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controlador.Methods;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Administrador extends JFrame {

	private JPanel contentPane;
	private JTextField direccion;
	private Methods controlador = new Methods();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Administrador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"src\\Imagenes\\huevo.png"));
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

		JButton btnAñadirOperador = new JButton("Añadir operador");
		btnAñadirOperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistroOperador().setVisible(true);
				dispose();
			}
		});
		btnAñadirOperador.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
				btnAñadirOperador.setForeground(new Color(255, 250, 205));
				btnAñadirOperador.setBackground(new Color(255, 215, 0));
			}

			public void mouseExited(MouseEvent e) {
				btnAñadirOperador.setForeground(new Color(255, 215, 0));
				btnAñadirOperador.setBackground(new Color(255, 250, 205));
			}
		});
		btnAñadirOperador.setForeground(new Color(255, 215, 0));
		btnAñadirOperador.setFont(new Font("Cocogoose", Font.PLAIN, 25));
		btnAñadirOperador.setFocusable(false);
		btnAñadirOperador.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnAñadirOperador.setBackground(new Color(255, 250, 205));
		btnAñadirOperador.setBounds(72, 94, 316, 64);
		panel_1.add(btnAñadirOperador);

		JButton btnConsultarOperadores = new JButton("Consultar operadores");
		btnConsultarOperadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnConsultarOperadores.setForeground(new Color(255, 215, 0));
		btnConsultarOperadores.setFont(new Font("Cocogoose", Font.PLAIN, 25));
		btnConsultarOperadores.setFocusable(false);
		btnConsultarOperadores.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnConsultarOperadores.setBackground(new Color(255, 250, 205));
		btnConsultarOperadores.setBounds(467, 94, 335, 64);
		panel_1.add(btnConsultarOperadores);

		JButton btnModificarMenu = new JButton("Modificar Menu");
		btnModificarMenu.setForeground(new Color(255, 215, 0));
		btnModificarMenu.setFont(new Font("Cocogoose", Font.PLAIN, 25));
		btnModificarMenu.setFocusable(false);
		btnModificarMenu.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnModificarMenu.setBackground(new Color(255, 250, 205));
		btnModificarMenu.setBounds(292, 192, 316, 64);
		panel_1.add(btnModificarMenu);

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