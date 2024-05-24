package Vistas;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Aviso extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aviso frame = new Aviso();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Aviso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"src\\Imagenes\\huevo.png"));
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

		JLabel text = new JLabel("Registro exitoso");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setForeground(new Color(30, 144, 255));
		text.setFont(new Font("cream DEMO", Font.PLAIN, 20));
		text.setBounds(31, -21, 406, 102);
		panel.add(text);

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(166, 54, 134, 39);
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
