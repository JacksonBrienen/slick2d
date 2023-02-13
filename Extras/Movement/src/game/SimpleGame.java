package game;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

public class SimpleGame extends BasicGame{

	// the parent class Shape is used so a transform can easily be done
	private Shape rectangle;
	
	// Constructor
	// Called before any other method
	// sets the title of the game window
	public SimpleGame(String title) {
		super(title);
		
		rectangle = new Rectangle(100, 100, 50, 50);
		
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
		
		float ds = delta / 1000f; // delta converted from milliseconds into seconds
		
		Input in = gc.getInput();
		
		float speed = 100 * ds; // 100 px per second
		
		// Transform the rectangle 100px/s on input
		
		if(in.isKeyDown(Input.KEY_UP))
			rectangle = rectangle.transform(Transform.createTranslateTransform(0, -speed));
		
		if(in.isKeyDown(Input.KEY_RIGHT))
			rectangle = rectangle.transform(Transform.createTranslateTransform(speed, 0));
		
		if(in.isKeyDown(Input.KEY_DOWN))
			rectangle = rectangle.transform(Transform.createTranslateTransform(0, speed));
		
		if(in.isKeyDown(Input.KEY_LEFT))
			rectangle = rectangle.transform(Transform.createTranslateTransform(-speed, 0));
		
	}
	
	@Override
	// Called every frame
	// draws to screen
	// g the graphics object being used to draw to the screen
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		// draw the rectangle
		g.fill(rectangle);
		
	}
	
}