package game;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

public class Ball {

	
	private static final float SPEED = 400f; // 400 px/s
	private Shape bounds;
	private float speedX, speedY; // speeds in px/s
	
	
	public Ball(float cx, float cy, float r) {
		bounds = new Circle(cx, cy, r);
		speedX = 0;
		speedY = 125f; // directed straight down slower than the default speed
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fill(bounds);
	}
	
	public void update(float ds, GameContainer gc, ArrayList<Box> boxes, Player player) {
		Shape translated = bounds.transform(Transform.createTranslateTransform(speedX * ds, speedY * ds));
		Shape translatedX = bounds.transform(Transform.createTranslateTransform(speedX * ds, 0));
		Shape translatedY = bounds.transform(Transform.createTranslateTransform(0, speedY * ds));
		
		
		
		// handle the player collision differently then wall and block collisions
		if(player.colliding(translated)) {
			// first case only checks if Y doesn't collide
			// if Y doesn't collide this means that the ball only collides with the side of the player
			// we should simply bounce off then
			if(!player.colliding(translatedY)) {
				speedX *= -1; // reverse X direction
			}else { // else means that we are colliding with the top of our player like normal
				
				float distanceFromCenter = translated.getCenterX() - player.getBounds().getCenterX(); 
				// negative distance from center aka ball on left side of paddle = ball goes left
				// positive distance from center aka ball on right side of paddle = ball goes right
				float halfPlayerWidth = (player.getBounds().getMaxX() - player.getBounds().getMinX()) / 2f;
				float distPercentage = distanceFromCenter / halfPlayerWidth; // value between 1 and 0
				System.out.println(distPercentage);
				distPercentage *= 0.75f; // value between 0.75 and 0
				
				
				// think of SPEED as a hypotenuse of a right triangle
				speedX = distPercentage * SPEED; // speedX is one leg of the hypotenuse
				// we just set our speedX = (value between 0 and 0.75) * SPEED
				// meaning we have given a degree somewhere between 0 (0 * 90) degrees (bounce straight up) and 67.5(.75 * 90) degrees (bounce at a full angle)
				// to calculate speedY we use the pythagorean theorem to solve for the last leg
				
				// If we say A^2 + B^2 = C^2
				// and A = speedY, B = speedX, and C = SPEED
				// Solving for A would leave us with
				// A = sqrt(C^2 - B^2)
				// we don't need to set B (speedX) to a positive value, because squaring it will ensure its positive before the subtraction
				
			  //A      =              sqrt(         C    ^ 2  -          B     ^ 2)
				speedY = (float) Math.sqrt(Math.pow(SPEED, 2) - Math.pow(speedX, 2));
				// we then set it to negative because the ball needs to be bouncing upwards
				speedY *= -1;
			}
			player.playSound();
		}else {
			// all boxes the ball collides with get added to one arraylist
			
			Box collided = null;
			
			for(Box b: boxes)
				if(b.colliding(translatedX) || b.colliding(translatedY)) {
					collided = b;
					break;
				}
			
			if(collided != null) {
				collided.playSound();
				if(collided.colliding(translatedX)) 
					speedX *= -1;
				if(collided.colliding(translatedY)) 
					speedY *= -1;
				if(collided.shouldRemove())
					boxes.remove(collided);
			}
			
			
		}
		
		
		bounds = bounds.transform(Transform.createTranslateTransform(speedX * ds, speedY * ds));
		
	}
	
	public Shape getBounds() {
		return bounds;
	}
	
	public void setBounds(Shape bounds) {
		this.bounds = bounds;
	}
	
}
