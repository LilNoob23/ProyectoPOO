package entes;

import juego.Juego;

//Con herencia
public class Recompensa extends Ente {

	public Recompensa(Juego juego, int x, int y, String direccion) {
		super(juego, x, y, direccion);

	}

	@Override
	public void moverse() {
		if (colision()) {
			// subiendo vidas al personaje
			getJuego().vidas++;
			// adicionando puntaje
			getJuego().puntaje += 50;
			// posicionando recompensa
			int xTemp = (int) (Math.random() * 900 + 100);
			int yTemp = (int) (Math.random() * 500 + 100);

			setX(xTemp);
			setY(yTemp);
		}
	}
}
