import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Launcher {
	
	
	public static void main(String[] args) throws SlickException {
		
		String nativePath = new File("./natives").getAbsolutePath();
		System.setProperty("org.lwjgl.librarypath", nativePath);
		System.setProperty("net.java.games.input.librarypath", nativePath);
		
		
		SimpleGame game = new SimpleGame("A Very Simple Game");
		AppGameContainer screen = new AppGameContainer(game);
		screen.setDisplayMode(500, 500, false);
		screen.start();
		
	}

}
