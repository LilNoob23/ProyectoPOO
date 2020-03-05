package entes;

import java.awt.event.KeyEvent;

import juego.Juego;

//Con herencia

public class Personaje extends Ente {
	private final int movimiento = 40;
	// estados para los mensajes
	private boolean endGame = false;
	private boolean pisarPasto = false;
	public static String nombre;

	public Personaje(Juego juego, int x, int y, String direccion) {
		super(juego, x, y, direccion);
	}

	public boolean getEndGame() {
		return endGame;
	}

	public boolean getPisarPasto() {
		return pisarPasto;
	}

	public void moverse(KeyEvent evento) {
		int[][] laberinto = Laberinto.getLaberinto();
		// Mov izquierda
		if (evento.getKeyCode() == KeyEvent.VK_A) {
			if (laberinto[getY() / 40][(getX() / 40) - 1] != 1) {
				setX(getX() - movimiento);
			}
		}
		// Mov derecha
		if (evento.getKeyCode() == KeyEvent.VK_D) {
			if (laberinto[getY() / 40][(getX() / 40) + 1] != 1)
				setX(getX() + movimiento);
		}
		// Mov abajo
		if (evento.getKeyCode() == KeyEvent.VK_S) {
			if (laberinto[(getY() / 40) + 1][getX() / 40] != 1)
				setY(getY() + movimiento);
		}
		// Mov arriba
		if (evento.getKeyCode() == KeyEvent.VK_W) {
			if (laberinto[(getY() / 40) - 1][getX() / 40] != 1)
				setY(getY() - movimiento);
		}
		// agregando mensaje al finalizar juego
		if (laberinto[getY() / 40][getX() / 40] == 9) {
			this.endGame = true;

		}
		// advertencia de pisar pasto
		if (laberinto[getY() / 40][getX() / 40] == 3) {
			this.pisarPasto = true;
		}

	}

	@Override
	public void moverse() {
		// TODO Auto-generated method stub

	}
}
