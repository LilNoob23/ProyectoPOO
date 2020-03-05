package presentacion;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JButton btnMapas;
	private JButton btnEmpezar;
	private JButton btnInstruciones;
	private JLabel imagen;

	// JuegoFrame inicioJuego;

	public Inicio() {
		setTitle("Laberinto Game");
		setSize(600, 450);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setVisible(true);
	}

	private void iniciarComponentes() {
		panel = new JPanel();
		panel.setSize(this.getSize());
		panel.setBackground(Color.BLACK);
		add(panel);

		btnMapas = new JButton("MAPAS");
		panel.add(btnMapas);
		btnMapas.addActionListener(this);

		ImageIcon iconButon = new ImageIcon("imagenes/btnComenzar.png");
		btnEmpezar = new JButton(iconButon);
		panel.add(btnEmpezar);
		btnEmpezar.addActionListener(this);

		btnInstruciones = new JButton("INSTRUCIONES");
		panel.add(btnInstruciones);
		btnInstruciones.addActionListener(this);

		// imagen = new JLabel();
		// imagen.setLocation(panel.getLocation());
		// imagen.setSize(panel.getSize());
		ImageIcon im = new ImageIcon("imagenes/FondoDefinitivo.png");
		// imagen.setIcon(new ImageIcon("imagenes/FondoDefinitivo.png"));
		imagen = new JLabel(im);
		imagen.setBounds(10, 10, 500, 300);
		imagen.setIcon(new ImageIcon(
				im.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(imagen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmpezar) {
			new Registro();
			this.dispose();
		}
		if (e.getSource() == btnInstruciones) {
			new Instrucciones();
			this.dispose();
		}
		if (e.getSource() == btnMapas) {
			new Mapas();
			this.dispose();
		}
	}

	public static void main(String[] args) {
		new Inicio();
	}

}
