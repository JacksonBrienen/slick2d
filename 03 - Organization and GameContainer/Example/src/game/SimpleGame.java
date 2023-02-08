package game;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class SimpleGame extends BasicGame{

	// Constructor
	// Called before any other method
	// sets the title of the game window
	public SimpleGame(String title) {
		super(title);
	}

	@Override
	// Called after the constructor
	// Called only once
	public void init(GameContainer gc) throws SlickException {
		
	}
	
	@Override
	// Called every frame
	// updates game logic (positions, speeds, etc.)
	// delta in milliseconds the time from the last update call
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}
	
	@Override
	// Called every frame
	// draws to screen
	// g the graphics object being used to draw to the screen
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
	}
	
}