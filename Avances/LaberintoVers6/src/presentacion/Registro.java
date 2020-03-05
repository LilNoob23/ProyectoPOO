package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entes.Personaje;

public class Registro extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JTextField txtPlayer;
	private JLabel lblNickname;
	private JButton btnNext;
	private JButton btnReturn;

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

		btnNext = new JButton("SIGUIENTE");
		btnNext.addActionListener(this);
		btnNext.setForeground(Color.BLUE);
		btnNext.setBackground(Color.ORANGE);
		btnNext.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		btnNext.setBounds(40, 129, 147, 23);
		panel.add(btnNext);

		txtPlayer = new JTextField();
		txtPlayer.setBounds(188, 59, 167, 36);
		panel.add(txtPlayer);
		txtPlayer.setColumns(10);

		btnReturn = new JButton("RETORNAR");
		btnReturn.addActionListener(this);
		btnReturn.setForeground(Color.BLUE);
		btnReturn.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		btnReturn.setBackground(Color.ORANGE);
		btnReturn.setBounds(220, 129, 147, 23);
		panel.add(btnReturn);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {

			Personaje.nombre = txtPlayer.getText();
			new NivelDificultad();
			this.dispose();

		}
		if (e.getSource() == btnReturn) {
			new Inicio();
			this.dispose();
		}

	}
}
