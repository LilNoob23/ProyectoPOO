package entes;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import juego.Juego;

public class Enemigo {
	private int x;
	private int y;
	private int xa = 2;
	private int ya = 2;
	private final int ANCHO = 40;
	private final int ALTO = 40;
	private Juego juego;
	// agregando
	private ImageIcon imagen;
	private String direccion;
	private String nombre;

	public Enemigo(Juego juego, int x, int y, String direccion, String nombre) {
		this.juego = juego;
		this.x = x;
		this.y = y;
		this.direccion = direccion;
		this.nombre = nombre;
	}

	public void pintarEnemigo(Graphics grafico) {
		imagen = new ImageIcon(direccion);
		grafico.drawImage(imagen.getImage(), x, y, juego);
	}

	public void moverse() {
		if (x + xa < 0)
			xa = 2;
		if (x + xa > juego.getWidth() - ANCHO)
			xa = -2;
		if (y + ya < 0)
			ya = 2;
		if (y + ya > juego.getHeight() - ALTO)
			// juego.gameOver();
			ya = -2;
		if (colision()) {
			if (nombre.equals("BICA") || nombre.equals("TRICA"))
				JOptionPane.showMessageDialog(juego, "Te agarró la " + nombre + " ,crack!");
			else
				JOptionPane.showMessageDialog(juego,
						"Te agarró el " + nombre + "...Muchachito te veo el próximo verano");
			y = (int) (Math.random() * 400) + 1;
			x = (int) (Math.random() * 400) + 1;
		}
		x = x + xa;
		y = y + ya;
	}

	public boolean colision() {
		return juego.personaje.getBounds().intersects(getBounds());
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, ANCHO, ALTO);
	}

}
