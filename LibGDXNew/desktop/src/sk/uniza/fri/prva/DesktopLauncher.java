package sk.uniza.fri.prva;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import sk.uniza.fri.prva.MojaHra;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Moja appka");
		//config.setWindowedMode(1200, 600);
		//config.setResizable(false);
		//config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
		//config.setDecorated(false);
		new Lwjgl3Application(new MojaHra(), config);
	}
}
