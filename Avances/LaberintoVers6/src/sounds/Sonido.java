package sounds;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sonido {
	public static final AudioClip INTRO = Applet.newAudioClip(Sonido.class.getResource("intro.wav"));
	public static final AudioClip FONDO = Applet.newAudioClip(Sonido.class.getResource("fondo.wav"));
	public static final AudioClip WIN = Applet.newAudioClip(Sonido.class.getResource("winGame.wav"));
	public static final AudioClip LOSE = Applet.newAudioClip(Sonido.class.getResource("endGame.wav"));

}
