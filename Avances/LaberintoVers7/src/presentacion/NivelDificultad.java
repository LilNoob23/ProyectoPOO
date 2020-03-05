package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import juego.Juego;
import sounds.Sonido;

public class NivelDificultad extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnEasy;
	private JButton btnMedium;
	private JButton btnHard;
	int mapaSelect;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NivelDificultad frame = new NivelDificultad();
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
	public NivelDificultad(int valorMap) {
		setTitle("NIVEL DIFICULTAD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 534, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTitleDificultad = new JLabel("DIFICULTAD");
		lblTitleDificultad.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleDificultad.setFont(new Font("Stencil", Font.BOLD, 22));
		lblTitleDificultad.setBounds(159, 33, 187, 32);
		panel.add(lblTitleDificultad);

		ImageIcon easy = new ImageIcon("imagenes/easy.jpg");
		btnEasy = new JButton(easy);
		btnEasy.setBounds(159, 76, 187, 38);
		panel.add(btnEasy);
		btnEasy.addActionListener(this);

		ImageIcon medium = new ImageIcon("imagenes/medium.jpg");
		btnMedium = new JButton(medium);
		btnMedium.setBounds(159, 125, 187, 36);
		panel.add(btnMedium);
		btnMedium.addActionListener(this);

		ImageIcon hard = new ImageIcon("imagenes/hard.jpg");
		btnHard = new JButton(hard);
		btnHard.setBounds(159, 172, 187, 38);
		panel.add(btnHard);
		btnHard.addActionListener(this);

		mapaSelect=valorMap;
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEasy) {
			Juego.nivelDif = 2;
		}
		if (e.getSource() == btnMedium) {
			Juego.nivelDif = 4;
		}
		if (e.getSource() == btnHard) {
			Juego.nivelDif = 6;
		}
		this.dispose();
		Sonido.INTRO.play();
		// agregando imagen al JOptionPane
		ImageIcon gif = new ImageIcon("imagenes/loading.gif");
		JOptionPane.showMessageDialog(this, "LOADING...", "CARGANDO", 0, gif);
		Sonido.INTRO.stop();
		new Juego(mapaSelect);

	}
}
