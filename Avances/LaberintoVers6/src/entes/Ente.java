package entes;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.Juego;

public abstract class Ente {
	private int xTemp;
	private int yTemp;
	private final int ANCHO = 40;
	private final int ALTO = 40;
	private Juego juego;
	private ImageIcon imagen;
	private String direccion;

	public Ente(Juego juego, int x, int y, String direccion) {
		this.juego = juego;
		this.xTemp = x;
		this.yTemp = y;
		this.direccion = direccion;
	}

	public void pintar(Graphics grafico) {
		imagen = new ImageIcon(direccion);
		grafico.drawImage(imagen.getImage(), xTemp, yTemp, juego);
	}

	public Rectangle getBounds() {
		return new Rectangle(xTemp, yTemp, ANCHO, ALTO);
	}

	public boolean colision() {
		return juego.getPersonaje().getBounds().intersects(getBounds());
	}

	public abstract void moverse();

	// getters
	public ImageIcon getImagen() {
		return imagen;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getX() {
		return xTemp;
	}

	public void setX(int x) {
		this.xTemp = x;
	}

	public int getY() {
		return yTemp;
	}

	public void setY(int y) {
		this.yTemp = y;
	}

	public Juego getJuego() {
		return juego;
	}

	public int getAncho() {
		return ANCHO;
	}

	public int getAlto() {
		return ALTO;
	}

}
