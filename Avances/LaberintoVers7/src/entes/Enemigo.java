package entes;

import javax.swing.JOptionPane;

import juego.Juego;

//Con herencia
//public class Enemigo extends Ente {
//	private int velocidadX = 2;
//	private int velocidadY = 2;
//	private String nombre;
//
//	public Enemigo(Juego juego, int x, int y, String direccion, String nombre) {
//		super(juego, x, y, direccion);
//		this.nombre = nombre;
//	}
//
//	@Override
//	public void moverse() {
//		if (getX() + velocidadX < 0) {
//			velocidadX = 2;
//			getJuego().puntaje++;
//		}
//		if (getX() + velocidadX > getJuego().getWidth() - getAncho()) {
//			velocidadX = -2;
//			getJuego().puntaje++;
//		}
//		if (getY() + velocidadY < 0) {
//			velocidadY = 2;
//			getJuego().puntaje++;
//		}
//		if (getY() + velocidadY > getJuego().getHeight() - getAlto()) {
//			velocidadY = -2;
//			getJuego().puntaje++;
//		}
//		if (colision()) {
//			if (nombre.equals("BICA") || nombre.equals("TRICA")) {
//				JOptionPane.showMessageDialog(getJuego(), "Te agarró la " + nombre + " ,crack!");
//			} else {
//				if (nombre.equals("PERROVACA")) {
//					JOptionPane.showMessageDialog(getJuego(), "Te mordió " + nombre + " ,crack!");
//				} else {
//					JOptionPane.showMessageDialog(getJuego(),
//							"Te agarró el " + nombre + "...Muchachito te veo el próximo verano");
//				}
//			}
//
//			setX((int) (Math.random() * 400) + 1);
//			setY((int) (Math.random() * 400) + 1);
//
//			// quitando vidas al jugador
//			getJuego().vidas--;
//			// quitando puntaje al jugador
//			if (getJuego().puntaje >= 0) {
//				getJuego().puntaje -= 20;
//			}
//			if (getJuego().vidas == 0) {
//				getJuego().gameOver();
//			}
//		}
//		setX(getX() + velocidadX);
//		setY(getY() + velocidadY);
//	}
//
//}

public class Enemigo extends Ente {
	private int velocidadX = Juego.nivelDif;
	private int velocidadY = Juego.nivelDif;
	private String nombre;

	public Enemigo(Juego juego, int x, int y, String direccion, String nombre) {
		super(juego, x, y, direccion);
		this.nombre = nombre;
	}

	@Override
	public void moverse() {
		if (getX() + velocidadX < 0) {
			velocidadX = Juego.nivelDif;
			getJuego().puntaje++;
		}
		if (getX() + velocidadX > getJuego().getWidth() - getAncho()) {
			velocidadX = -Juego.nivelDif;
			getJuego().puntaje++;
		}
		if (getY() + velocidadY < 0) {
			velocidadY = Juego.nivelDif;
			getJuego().puntaje++;
		}
		if (getY() + velocidadY > getJuego().getHeight() - getAlto()) {
			velocidadY = -Juego.nivelDif;
			getJuego().puntaje++;
		}
		if (colision()) {
			if (nombre.equals("BICA") || nombre.equals("TRICA")) {
				JOptionPane.showMessageDialog(getJuego(), "Te agarró la " + nombre + " ,crack!");
			} else {
				if (nombre.equals("PERROVACA")) {
					JOptionPane.showMessageDialog(getJuego(), "Te mordió " + nombre + " ,crack!");
				} else {
					JOptionPane.showMessageDialog(getJuego(),
							"Te agarró el " + nombre + "...Muchachito te veo el próximo verano");
				}
			}

			setX((int) (Math.random() * 400) + 1);
			setY((int) (Math.random() * 400) + 1);

			// quitando vidas al jugador
			getJuego().vidas--;
			// quitando puntaje al jugador
			if (getJuego().puntaje >= 0) {
				getJuego().puntaje -= 20;
			}
			if (getJuego().vidas == 0) {
				getJuego().gameOver();
			}
		}
		setX(getX() + velocidadX);
		setY(getY() + velocidadY);
	}

}
