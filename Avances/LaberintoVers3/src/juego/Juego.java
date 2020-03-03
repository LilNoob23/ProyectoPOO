package juego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entes.Enemigo;
import entes.Laberinto;
import entes.Personaje;

public class Juego extends JPanel {
	/**
	 * 
	 */
	private JFrame ventana;
	private static final long serialVersionUID = 1L;
	public Laberinto laberinto = new Laberinto();
	public Personaje personaje = new Personaje();
	// agregando enemigos
	Enemigo bica = new Enemigo(this, 400, 100, "imagenes/enemigos_1.png", "BICA");
	Enemigo trica = new Enemigo(this, 120, 480, "imagenes/enemigos_2.png", "TRICA");
	Enemigo profe = new Enemigo(this, 360, 280, "imagenes/enemigos_0.png", "PROFE");

	public Juego() {
		initComponent();
		ventana = new JFrame("JUEGAZO");
		ventana.setSize(1260, 720);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(this);
		ventana.setVisible(true);

		inicio();
	}

	public void initComponent() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				personaje.moverse(e);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// mantener el foco de la aplicacion
		this.setFocusable(true);
	}

	public void inicio() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						move();
						Thread.sleep(5);
						if (personaje.getEndGame() == true) {
							JOptionPane.showMessageDialog(null, "GANASTE CRACK!!");
							System.exit(0);
						}
						if (personaje.getPisarPasto() == true) {
							JOptionPane.showMessageDialog(null, "PERDISTE POR PISAR LAS AREAS VERDES!!");
							System.exit(0);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ventana.repaint();
				}
			}

		});
		t.start();
	}

	// agregando movimiento
	public void move() {
		bica.moverse();
		trica.moverse();
		profe.moverse();
	}

	@Override
	public void paint(Graphics grafico) {
		laberinto.pintarLaberinto(grafico);
		personaje.pintarPersonaje(grafico);
		bica.pintarEnemigo(grafico);
		trica.pintarEnemigo(grafico);
		profe.pintarEnemigo(grafico);
	}

	public static void main(String[] args) {
		new Juego();
	}

}
