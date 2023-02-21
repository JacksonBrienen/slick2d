package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

public class Player extends Box{

	private final float speed = 275f; // 200 px/s
	
	public Player(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override // use of the @Override annotation is quite important, 
			  // this will make sure the update method is properly overriding the one from Box
	public void update(float ds, GameContainer gc) {
		Input in = gc.getInput();
		
		// Support for both left arrow key and a key
		if(in.isKeyDown(Input.KEY_LEFT) || in.isKeyDown(Input.KEY_A)) {
			Shape translated = getBounds().transform(Transform.createTranslateTransform(-speed * ds, 0));		
			// the leftmost X value has gone off the screen
			// only transform as much is needed to not go off the screen
			// that value will be equal to the pre-translated minX
			if(translated.getMinX() < 0)
				setBounds(getBounds().transform(Transform.createTranslateTransform(getBounds().getMinX(), 0)));
			// else simply translate as much as should be moved
			else
				setBounds(translated);
			
		}
		
		// Support for both right arrow key and d key
		if(in.isKeyDown(Input.KEY_RIGHT) || in.isKeyDown(Input.KEY_D)) {
			Shape translated = getBounds().transform(Transform.createTranslateTransform(speed * ds, 0));		
			// the rightmost X value has gone off the screen
			// only transform as much is needed to not go off the screen
			// that value will be equal to the game width minus the pre-translated maxX
			if(translated.getMaxX() > gc.getWidth())
				setBounds(getBounds().transform(Transform.createTranslateTransform(gc.getWidth() - getBounds().getMaxX(), 0)));
			// else simply translate as much as should be moved
			else
				setBounds(translated);
		}
		
		
	}
	
}
