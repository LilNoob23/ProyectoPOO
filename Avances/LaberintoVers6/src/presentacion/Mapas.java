package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Mapas extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btnVolver;
//	private JLabel mapa1;
//	private JLabel mapa2;
//	private JLabel mapa3;

	public Mapas() {
		setTitle("MAPAS");
		setSize(500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setVisible(true);
	}

	public void iniciarComponentes() {
		panel = new JPanel();
		panel.setSize(this.getSize());
		panel.setBackground(Color.blue);
		panel.setLayout(new BorderLayout());
		add(panel);

		ImageIcon iconButon1 = new ImageIcon("imagenes/MapaAlesandro.jpg");
		btn1 = new JButton(iconButon1);
		panel.add(btn1, BorderLayout.WEST);
		btn1.addActionListener(this);

		ImageIcon iconButon2 = new ImageIcon("imagenes/MapaAugusto.jpg");
		btn2 = new JButton(iconButon2);
		panel.add(btn2, BorderLayout.CENTER);
		btn2.addActionListener(this);

		ImageIcon iconButon3 = new ImageIcon("imagenes/MapaGabriel.jpg");
		btn3 = new JButton(iconButon3);
		panel.add(btn3, BorderLayout.EAST);
		btn3.addActionListener(this);

		JLabel titulo = new JLabel("ESCOGE TU MAPA", SwingConstants.CENTER);
		titulo.setForeground(Color.blue);
		titulo.setOpaque(true);
		titulo.setBackground(Color.green);
		titulo.setFont(new Font("chiller", Font.PLAIN, 50));
		panel.add(titulo, BorderLayout.NORTH);

		btnVolver = new JButton("VOLVER");
		panel.add(btnVolver, BorderLayout.SOUTH);
		btnVolver.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			System.out.println("MAPA ALESANDRO");
		}
		if (e.getSource() == btn2) {
			System.out.println("MAPA AUGUSTO");
		}
		if (e.getSource() == btn3) {
			System.out.println("MAPA GABRIEL");
		}
		if (e.getSource() == btnVolver) {
			new Inicio();
			this.dispose();
		}

	}

	public static void main(String[] args) {
		new Mapas();
	}

}
