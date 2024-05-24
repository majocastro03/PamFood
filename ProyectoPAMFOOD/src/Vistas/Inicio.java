package Vistas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Inicio extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\maria\\OneDrive - UPB\\UPB\\3 SEMESTRE\\Estructuras de Datos\\Proyecto Integrador\\ProyectoPAMFOOD\\src\\Imagenes\\huevo.png"));
		setTitle("PAMFOOD");
		setBackground(new Color(235, 69, 95));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		panel_1.setBounds(31, 31, 389, 255);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel nuevoPedido = new JLabel("Nuevo pedido");
		nuevoPedido.setForeground(new Color(30, 144, 255));
		nuevoPedido.setHorizontalAlignment(SwingConstants.CENTER);
		nuevoPedido.setFont(new Font("Cocogoose", Font.PLAIN, 30));
		nuevoPedido.setBounds(35, 29, 316, 40);
		panel_1.add(nuevoPedido);

		JButton btnRegistarCliente = new JButton("Registrar cliente");
		btnRegistarCliente.setBounds(35, 90, 316, 64);
		btnRegistarCliente.setForeground(new Color(255, 215, 0));
		btnRegistarCliente.setBackground(new Color(255, 250, 205));
		panel_1.add(btnRegistarCliente);
		btnRegistarCliente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new Registro().setVisible(true);
				;
				dispose();

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
		btnRegistarCliente.setBackground(new Color(255, 250, 205));
		btnRegistarCliente.setFocusable(false);
		btnRegistarCliente.setFont(new Font("Coco Gothic", Font.PLAIN, 25));
		btnRegistarCliente.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));

		JButton btnPedido = new JButton("Generar pedido");
		btnPedido.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}

			public void mouseEntered(MouseEvent e) {
				btnPedido.setForeground(new Color(255, 250, 205));
				btnPedido.setBackground(new Color(255, 215, 0));
			}

			public void mouseExited(MouseEvent e) {
				btnPedido.setForeground(new Color(255, 215, 0));
				btnPedido.setBackground(new Color(255, 250, 205));
			}

		});
		btnPedido.setForeground(new Color(255, 215, 0));
		btnPedido.setFont(new Font("Coco Gothic", Font.PLAIN, 25));
		btnPedido.setFocusable(false);
		btnPedido.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnPedido.setBackground(new Color(255, 250, 205));
		btnPedido.setBounds(35, 168, 316, 64);
		panel_1.add(btnPedido);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 230, 140));
		panel_2.setBounds(458, 31, 431, 350);
		panel.add(panel_2);

		JLabel menu = new JLabel("Menú");
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setForeground(new Color(30, 144, 255));
		menu.setFont(new Font("Cocogoose", Font.PLAIN, 30));
		menu.setBounds(33, 28, 366, 40);
		panel_2.add(menu);

		JButton btnPedidosFrecuentes = new JButton("Pedidos frecuentes");
		btnPedidosFrecuentes.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnPedidosFrecuentes.setForeground(new Color(255, 250, 205));
				btnPedidosFrecuentes.setBackground(new Color(255, 215, 0));
			}

			public void mouseExited(MouseEvent e) {
				btnPedidosFrecuentes.setForeground(new Color(255, 215, 0));
				btnPedidosFrecuentes.setBackground(new Color(255, 250, 205));
			}
		});
		btnPedidosFrecuentes.setForeground(new Color(255, 215, 0));
		btnPedidosFrecuentes.setFont(new Font("Coco Gothic", Font.PLAIN, 25));
		btnPedidosFrecuentes.setFocusable(false);
		btnPedidosFrecuentes.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnPedidosFrecuentes.setBackground(new Color(255, 250, 205));
		btnPedidosFrecuentes.setBounds(33, 90, 366, 64);
		panel_2.add(btnPedidosFrecuentes);

		JButton btnMenu = new JButton("Menu completo");
		btnMenu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnMenu.setForeground(new Color(255, 250, 205));
				btnMenu.setBackground(new Color(255, 215, 0));
			}

			public void mouseExited(MouseEvent e) {
				btnMenu.setForeground(new Color(255, 215, 0));
				btnMenu.setBackground(new Color(255, 250, 205));
			}
		});
		btnMenu.setForeground(new Color(255, 215, 0));
		btnMenu.setFont(new Font("Coco Gothic", Font.PLAIN, 25));
		btnMenu.setFocusable(false);
		btnMenu.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnMenu.setBackground(new Color(255, 250, 205));
		btnMenu.setBounds(33, 177, 366, 64);
		panel_2.add(btnMenu);

		JButton btnBuscarProducto = new JButton("Buscar producto");
		btnBuscarProducto.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnBuscarProducto.setForeground(new Color(255, 250, 205));
				btnBuscarProducto.setBackground(new Color(255, 215, 0));
			}

			public void mouseExited(MouseEvent e) {
				btnBuscarProducto.setForeground(new Color(255, 215, 0));
				btnBuscarProducto.setBackground(new Color(255, 250, 205));
			}
		});
		btnBuscarProducto.setForeground(new Color(255, 215, 0));
		btnBuscarProducto.setFont(new Font("Coco Gothic", Font.PLAIN, 25));
		btnBuscarProducto.setFocusable(false);
		btnBuscarProducto.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnBuscarProducto.setBackground(new Color(255, 250, 205));
		btnBuscarProducto.setBounds(33, 262, 366, 64);
		panel_2.add(btnBuscarProducto);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}

			public void mouseEntered(MouseEvent e) {
				btnSalir.setForeground(new Color(235, 69, 95));
				btnSalir.setBackground(Color.WHITE);
				btnSalir.setBorder(new LineBorder(new Color(235, 69, 95), 1, true));
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
		titulo.setBounds(30, 10, 355, 77);
		contentPane.add(titulo);
		titulo.setForeground(new Color(255, 240, 245));
		titulo.setFont(new Font("The Bold Font", Font.PLAIN, 55));
	}
}
