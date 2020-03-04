package entes;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.Juego;

public class Recompensa {
	private int x;
	private int y;
	private final int ANCHO = 30;
	private final int ALTO = 30;
	private Juego juego;
	private ImageIcon imagen;
	private String direccion;

	public Recompensa(Juego juego, int x, int y, String direccion) {
		this.juego = juego;
		this.direccion = direccion;
		this.x = x;
		this.y = y;
	}

	public void pintarRecompensa(Graphics grafico) {
		imagen = new ImageIcon(direccion);
		grafico.drawImage(imagen.getImage(), x, y, juego);
	}

	public void moverse() {
		if (capturarRecompensa()) {
			// subiendo vidas al personaje
			juego.vidas++;
			// adicionando puntaje
			juego.puntaje += 50;
			// posicionando recompensa
			this.x = (int) (Math.random() * 900 + 100);
			this.y = (int) (Math.random() * 500 + 100);
		}
	}

	public boolean capturarRecompensa() {
		// return juego.personaje.getBounds().intersects(getBounds());
		return juego.getPersonaje().getBounds().intersects(getBounds());
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, ANCHO, ALTO);
	}
}
