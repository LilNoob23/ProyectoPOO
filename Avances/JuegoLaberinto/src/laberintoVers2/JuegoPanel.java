package laberintoVers2;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class JuegoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Laberinto laberinto = new Laberinto();
	Personaje personaje = new Personaje();
	// agregando enemigos
	Enemigo bica = new Enemigo(this, 400, 100, "imagenes/enemigos_1.png", "BICA");
	Enemigo trica = new Enemigo(this, 120, 480, "imagenes/enemigos_2.png", "TRICA");
	Enemigo profe = new Enemigo(this, 360, 280, "imagenes/enemigos_0.png", "PROFE");

	public JuegoPanel() {
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
		setFocusable(true);
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

}
