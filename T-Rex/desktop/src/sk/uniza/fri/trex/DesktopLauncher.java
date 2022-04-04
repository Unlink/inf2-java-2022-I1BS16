package sk.uniza.fri.trex;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import sk.uniza.fri.trex.MyTrexGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(MyTrexObrazovka.SIRKA_PLOCHY, MyTrexObrazovka.VYSKA_PLOCHY);
		new Lwjgl3Application(new MyTrexGame(), config);
	}
}
