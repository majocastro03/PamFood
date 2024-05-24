package server;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ServerAviso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerAviso frame = new ServerAviso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerAviso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Usuario\\Documents\\UPB\\Troisième semestre\\ESTRUCTURAS\\Proyecto\\OperadoresPaMFood\\src\\imagenes\\huevo.jpg"));
		// setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagenes/huevo.png")));
		setTitle("PAMFOOD");
		setBackground(new Color(235, 69, 95));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(545, 208);
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

		panel.setBounds(33, 33, 471, 115);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel text = new JLabel("Servidor iniciado");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setForeground(new Color(30, 144, 255));
		text.setFont(new Font("Cocogoose", Font.PLAIN, 24));
		text.setBounds(47, 0, 372, 64);
		panel.add(text);

		JButton btnAtras = new JButton("Ok");
		btnAtras.setBounds(177, 65, 103, 39);
		panel.add(btnAtras);
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
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
		btnAtras.setFont(new Font("Cocogoose", Font.PLAIN, 20));
		btnAtras.setFocusable(false);
		btnAtras.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnAtras.setBackground(new Color(235, 69, 95));
	
	}

}
