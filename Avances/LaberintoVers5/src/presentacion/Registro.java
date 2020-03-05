package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import juego.Juego;
import sounds.Sonido;

public class Registro extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel panel;
	private JTextField textField;
	JLabel lblNickname;
	JButton btnNext;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Registro frame = new Registro();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public Registro() {
		setTitle("REGISTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 410, 181);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNickname = new JLabel("NICKNAME:");
		lblNickname.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setBounds(40, 59, 138, 36);
		panel.add(lblNickname);

		btnNext = new JButton("NEXT");
		btnNext.addActionListener(this);
		btnNext.setForeground(Color.BLUE);
		btnNext.setBackground(Color.ORANGE);
		btnNext.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		btnNext.setBounds(148, 128, 89, 23);
		panel.add(btnNext);

		textField = new JTextField();
		textField.setBounds(188, 59, 167, 36);
		panel.add(textField);
		textField.setColumns(10);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			this.dispose();
			Sonido.INTRO.play();
			// agregando imagen al JOptionPane
			ImageIcon gif = new ImageIcon("imagenes/loading.gif");
			JOptionPane.showMessageDialog(this, "LOADING...", "CARGANDO", 0, gif);
			// inicioJuego = new JuegoFrame();
			Sonido.INTRO.stop();
			new Juego();
		}

	}
}
