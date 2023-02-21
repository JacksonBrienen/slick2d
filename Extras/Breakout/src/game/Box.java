package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Box {

	private Shape bounds;
	private Color color;
	private boolean remove;
	private Sound sound;
	
	public Box(float x, float y, float width, float height) {
		this(x, y, width, height, Color.white);
	}
	
	public Box(float x, float y, float width, float height, Color color) {
		this(x, y, width, height, color, false);
	}
	
	public Box(float x, float y, float width, float height, Color color, boolean remove) {
		bounds = new Rectangle(x, y, width, height);
		this.color = color;
		this.remove = remove;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean colliding(Shape other) {
		return bounds.intersects(other) || bounds.contains(other) || other.contains(bounds);
	}
	
	public void setBounds(Shape bounds) {
		this.bounds = bounds;
	}
	
	public Shape getBounds() {
		return bounds;
	}
	
	public void update(float ds, GameContainer gc) {
		// leave empty for other methods to override
	}
	
	public void setSound(Sound sound) {
		this.sound = sound;
	}
	
	public void playSound() {
		if(sound!=null)
			sound.play();
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fill(bounds);
	}
	
	public boolean shouldRemove() {
		return remove;
	}
	
}