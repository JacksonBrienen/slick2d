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
	
	// set the sound that will be played when playSound() is called
	public void setSound(Sound sound) {
		this.sound = sound;
	}
	
	public void playSound() {
		// check if the sound is null
		// if not null check if the sound is already playing
		// then play sound
		if(sound!=null && !sound.playing())
			sound.play();
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fill(bounds);
	}
	
	// if this box should be removed when colliding with Ball
	// by default is set to false
	public boolean shouldRemove() {
		return remove;
	}
	
}