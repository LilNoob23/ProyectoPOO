package Laberinto;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Laberinto laberinto = new Laberinto();
	Personaje personaje = new Personaje();
	
	public Juego() {
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
				
			}});
		//mantener el foco de la aplicacion 
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics grafico) {
		laberinto.pintarLaberinto(grafico);
		personaje.pintarPersonaje(grafico);
	}
	
	public static void main(String[] args) {
		JFrame miventana = new JFrame("Laberinto Fisi");
		Juego game = new Juego();
		miventana.add(game);
		
		miventana.setSize(720,560);			
		miventana.setLocationRelativeTo(null);
		miventana.setVisible(true);
		miventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			try {
				//mostrar un retraso en milisegundos
				Thread.sleep(10);
				if(game.personaje.getEndGame() == true) {
					JOptionPane.showMessageDialog(miventana, "GANASTE CRACK!!");
					System.exit(0);
				}
				if(game.personaje.getPisarPasto() == true) {
					JOptionPane.showMessageDialog(miventana, "PERDISTE POR PISAR LAS AREAS VERDES!!");
					System.exit(0);
				}
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//repintar cada vez que se mueve
			miventana.repaint();
		}
		
	}
	
	

}