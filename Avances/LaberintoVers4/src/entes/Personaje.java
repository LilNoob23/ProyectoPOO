package entes;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import juego.Juego;

public class Personaje {
	Laberinto lab = new Laberinto();
	private int x = 40;
	private int y = 40;
	private final int ANCHO = 40;
	private final int ALTO = 40;
	private final int movimiento = 40;
	// estados para los mensajes
	private boolean endGame = false;
	private boolean pisarPasto = false;
	// componentes
	private Juego juego;
	private ImageIcon imagen;

	public Personaje(Juego juego, int x, int y) {
		this.juego = juego;
		this.x = x;
		this.y = y;
	}

	public void pintarPersonaje(Graphics grafico) {
		imagen = new ImageIcon("imagenes/sprite_Abaj.png");
		grafico.drawImage(imagen.getImage(), x, y, juego);

	}

	public int getAncho() {
		return ANCHO;
	}

	public int getAlto() {
		return ALTO;
	}

	public boolean getEndGame() {
		return endGame;
	}

	public boolean getPisarPasto() {
		return pisarPasto;
	}

	public void moverse(KeyEvent evento) {
		int[][] laberinto = lab.getLaberinto();
		// Mov izquierda
		if (evento.getKeyCode() == KeyEvent.VK_A) {
			if (laberinto[y / 40][(x / 40) - 1] != 1)
				x = x - movimiento;
		}
		// Mov derecha
		if (evento.getKeyCode() == KeyEvent.VK_D) {
			if (laberinto[y / 40][(x / 40) + 1] != 1)
				x = x + movimiento;
		}
		// Mov abajo
		if (evento.getKeyCode() == KeyEvent.VK_S) {
			if (laberinto[(y / 40) + 1][x / 40] != 1)
				y = y + movimiento;
		}
		// Mov arriba
		if (evento.getKeyCode() == KeyEvent.VK_W) {
			if (laberinto[(y / 40) - 1][x / 40] != 1)
				y = y - movimiento;
		}
		// agregando mensaje al finalizar juego
		if (laberinto[y / 40][x / 40] == 9) {
			this.endGame = true;

		}
		// advertencia de pisar pasto
		if (laberinto[y / 40][x / 40] == 3) {
			this.pisarPasto = true;
		}

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, ANCHO, ALTO);
	}

}
