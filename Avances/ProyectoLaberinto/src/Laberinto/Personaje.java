package Laberinto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Personaje {
	Laberinto lab = new Laberinto();
	private int x = 20;
	private int y = 20;
	private final int ancho = 20;
	private final int alto = 20;
	private final int movimiento = 20;
	//estados para los mensajes
	private boolean endGame = false;
	private boolean pisarPasto = false;
	public void pintarPersonaje(Graphics grafico) {
		grafico.setColor(Color.black);
		grafico.fillOval(x, y, ancho, alto);
		grafico.setColor(Color.red);
		grafico.drawOval(x, y, ancho, alto);
		
		
	}
	
	public boolean getEndGame() {
		return endGame;
	}
	
	public boolean getPisarPasto() {
		return pisarPasto;
	}
	public void moverse(KeyEvent evento) {
		int[][] laberinto = lab.getLaberinto();
		//Mov izquierda
		if(evento.getKeyCode() == 37) {
			if(laberinto[y/20][(x/20) - 1] != 1)
				x = x - movimiento;
		}
		//Mov derecha
		if(evento.getKeyCode() == 39) {
			if(laberinto[y/20][(x/20) + 1] != 1)
				x = x + movimiento;
		}
		//Mov abajo
		if(evento.getKeyCode() == 40) {
			if(laberinto[(y/20) + 1][x/20] != 1)
				y = y + movimiento;		
		}
		//Mov arriba
		if(evento.getKeyCode() == 38) {
			if(laberinto[(y/20) - 1][x/20] != 1)
				y = y - movimiento;
		}
		//agregando mensaje al finalizar juego
		if(laberinto[y/20][x/20] == 9) {
			this.endGame = true;
		}
		//advertencia de pisar pasto
		if(laberinto[y/20][x/20] == 3) {
			this.pisarPasto = true;
		}
		
	}

}