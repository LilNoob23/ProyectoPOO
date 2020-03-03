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

public class Instrucciones extends JFrame implements ActionListener {

	JPanel panel;
	JButton btnVolver;
	JLabel imagen;

	public Instrucciones() {
		setTitle("Laberinto Game");
		setSize(560, 380);
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

		btnVolver = new JButton("VOLVER");
		panel.add(btnVolver);
		btnVolver.addActionListener(this);

		ImageIcon im = new ImageIcon("imagenes/CajaTexto.png");
		imagen = new JLabel(im);
		imagen.setBounds(0, 0, 500, 300);
		imagen.setIcon(new ImageIcon(
				im.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(imagen);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			JOptionPane.showMessageDialog(panel, "VOLVIENDO...");
			PresentacionAntesDeInstrucciones pres = new PresentacionAntesDeInstrucciones();
			this.dispose();
		}

	}
}
