package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entes.Enemigo;
import entes.Ente;
import entes.Laberinto;
import entes.Personaje;
import entes.Recompensa;
import sounds.Sonido;

//MODIFICACIONES CON HERENCIA
public class Juego extends JPanel {
	/**
	 * 
	 */
	private JFrame ventana;
	private static final long serialVersionUID = 1L;
	private Personaje personaje = new Personaje(this, 40, 40, "imagenes/sprite_Abaj.png");
	private final int PTJMAX = 300;
	public int mat[][];
	public JLabel[][] matriz;
	public JPanel panelJuego;
	public int mapaSelect;
	// agregando enemigos
	private Ente bica = new Enemigo(this, 400, 100, "imagenes/enemigos_1.png", "BICA");
	private Ente trica = new Enemigo(this, 120, 480, "imagenes/enemigos_2.png", "TRICA");
	private Ente profe = new Enemigo(this, 360, 280, "imagenes/enemigos_0.png", "PROFE");
	private Ente perrovaca = new Enemigo(this, 1000, 600, "imagenes/perrovaca.png", "PERROVACA");
	// recompensas
	private Ente recomp = new Recompensa(this, 200, 150, "imagenes/recompensa.png");
	private Ente comida = new Recompensa(this, 600, 300, "imagenes/comidaunmsm.png");

	public int vidas = 5;
	public int puntaje = 0;

	public static int nivelDif;

	public int getVidas() {
		return vidas;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void gameOver() {
		Sonido.FONDO.stop();
		Sonido.LOSE.play();
		JOptionPane.showMessageDialog(this, "\n\nSe te acabaron las vidas! || vidas = " + getVidas(), "Game Over",
				JOptionPane.YES_NO_OPTION);
		System.exit(0);
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public Juego(int valorMap) {
		initComponent();
		ventana = new JFrame("Laberinto Game");
		ventana.setSize(1260, 720);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(this);
		ventana.setVisible(true);
		mapaSelect = valorMap;

		mat = new int[17][31];
		matriz = new JLabel[17][31];
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 31; j++) {
				matriz[i][j] = new JLabel();
			}
		}

		mat = Laberinto.getLaberinto(mapaSelect);
		ventana.setVisible(true);

		inicio();
		jugar();
	}

	public void jugar() {
		panelJuego = new JPanel();
		panelJuego.setLayout(null);
		panelJuego.setSize(1260, 720);
		panelJuego.setVisible(true);
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 31; j++) {
				matriz[i][j].setIcon(new ImageIcon("imagenes/" + mat[i][j] + mapaSelect + ".png"));
				matriz[i][j].setBounds(j * 40, i * 40, 40, 40);
				matriz[i][j].setVisible(true);
				panelJuego.add(matriz[i][j], 0);
			}
		}
		ventana.add(panelJuego);

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
				personaje.moverse(e, mapaSelect);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// mantener el foco de la aplicacion
		this.setFocusable(true);
		Sonido.FONDO.loop();
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
							Sonido.FONDO.stop();
							Sonido.WIN.play();
							if (getPuntaje() < 10.5) {
								JOptionPane
										.showMessageDialog(null,
												"[" + Personaje.nombre + "] \nPERDISTE CRACK!! \nTu puntaje es: "
														+ getPuntaje() + " y no supero el 10.5",
												"LOSE", JOptionPane.OK_OPTION);
							} else {
								JOptionPane
										.showMessageDialog(null,
												"[" + Personaje.nombre + "] \nGANASTE CRACK!! \nTu puntaje es: "
														+ getPuntaje() + " y supero el 10.5",
												"WIN", JOptionPane.OK_OPTION);
							}

							System.exit(0);
						}
						if (personaje.getPisarPasto() == true) {
							Sonido.FONDO.stop();
							Sonido.LOSE.play();
							JOptionPane.showMessageDialog(null,
									Personaje.nombre + " \nPERDISTE POR PISAR LAS AREAS VERDES!!", "GAME OVER",
									JOptionPane.YES_NO_OPTION);
							System.exit(0);
						}
						if (getPuntaje() == PTJMAX) {
							Sonido.FONDO.stop();
							Sonido.WIN.play();
							JOptionPane.showMessageDialog(null,
									"GANASTE CRACK!! \nAlcanzaste el puntaje establecido! \nTu puntaje es: "
											+ getPuntaje(),
									"LOSE", JOptionPane.OK_OPTION);
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
		perrovaca.moverse();
		// recompensas
		recomp.moverse();
		comida.moverse();
	}

	@Override
	public void paint(Graphics grafico) {
		// laberinto.pintarLaberinto(grafico,mapaSelect);
		personaje.pintar(grafico);
		bica.pintar(grafico);
		trica.pintar(grafico);
		profe.pintar(grafico);
		perrovaca.pintar(grafico);
		recomp.pintar(grafico);
		comida.pintar(grafico);

		// pintando las vidas
		grafico.setColor(Color.RED);
		grafico.setFont(new Font("Verdana", Font.BOLD, 60));
		grafico.drawString("VIDAS: " + String.valueOf(getVidas()), 10, 650);

		// pintando el puntaje
		grafico.setColor(Color.MAGENTA);
		grafico.setFont(new Font("Verdana", Font.CENTER_BASELINE, 60));
		grafico.drawString("PUNTAJE: " + String.valueOf(getPuntaje()), 700, 650);

	}

	// public static void main(String[] args) {
	// new Juego();
	// }

}
