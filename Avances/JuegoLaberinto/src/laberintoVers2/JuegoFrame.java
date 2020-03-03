package laberintoVers2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JuegoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	public JuegoFrame() {
		panel = new JPanel();
		setSize(1260, 720);
		setTitle("JUEGAZO");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JuegoPanel game = new JuegoPanel();
		this.add(game);
		this.setVisible(true);

		while (true) {
			try {
				game.move();
				Thread.sleep(5);
				if (game.personaje.getEndGame() == true) {
					JOptionPane.showMessageDialog(panel, "GANASTE CRACK!!");
					System.exit(0);
				}
				if (game.personaje.getPisarPasto() == true) {
					JOptionPane.showMessageDialog(panel, "PERDISTE POR PISAR LAS AREAS VERDES!!");
					System.exit(0);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
		}

	}

	public static void main(String[] args) {
		JuegoFrame frame = new JuegoFrame();
	}

}
