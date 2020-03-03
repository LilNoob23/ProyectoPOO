package presentacion;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PresentacionAntesDeInstrucciones extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JPanel panel;
	JButton btnEmpezar;
	JButton btnSalir;
	JLabel imagen;

	public PresentacionAntesDeInstrucciones() {
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

		ImageIcon iconButon = new ImageIcon("imagenes/btnComenzar.png");
		btnEmpezar = new JButton(iconButon);
		panel.add(btnEmpezar);
		btnEmpezar.addActionListener(this);

		btnSalir = new JButton("SALIR");
		panel.add(btnSalir);
		btnSalir.addActionListener(this);

		ImageIcon im = new ImageIcon("imagenes/FondoDefinitivo.png");
		imagen = new JLabel(im);
		imagen.setBounds(10, 10, 500, 300);
		imagen.setIcon(new ImageIcon(
				im.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(imagen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmpezar) {
			JOptionPane.showMessageDialog(panel, "LOADING...");
			Instrucciones inst = new Instrucciones();
			this.dispose();
		}
		if (e.getSource() == btnSalir) {
			JOptionPane.showMessageDialog(panel, "SALIENDO");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		PresentacionAntesDeInstrucciones ventana = new PresentacionAntesDeInstrucciones();
	}

}
