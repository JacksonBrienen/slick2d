package game;

import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SimpleGame extends BasicGame{
	
	private Player player;
	private Ball ball;
	private ArrayList<Box> boxes;
	
	
	// Constructor
	// Called before any other method
	// sets the title of the game window
	public SimpleGame(String title) {
		super(title);
		
	}

	private Sound[] block = new Sound[6];
	private Sound paddle;
	private Sound wall;
	
	@Override
	// Called after the constructor
	// Called only once
	public void init(GameContainer gc) throws SlickException {
		for(int i = 0; i < 6; i++)
			block[i] = new Sound("res/block" + i + ".wav");
		paddle = new Sound("res/paddle.wav");
		wall = new Sound("res/wall.wav");
		
		// we create the player here so we know the the width and height of the screen to properly place the player
		player = new Player((gc.getWidth() - 100)/2f, gc.getHeight() - 50, 100, 10);
		player.setSound(paddle);
		
		ball = new Ball(gc.getWidth()/2f, gc.getHeight()/2f, 7);
		
		boxes = new ArrayList<>();
		
		Box[] walls = new Box[] {
				new Box(-10, 0, 10, gc.getHeight()),
				new Box(gc.getWidth(), 0, 10, gc.getHeight()),
				new Box(0, -10, gc.getWidth(), 10),
				new Box(0, gc.getHeight(), gc.getWidth(), 10)
		};
		
		for(Box b: walls) {
			b.setSound(wall);
			boxes.add(b);
		}
			
		Color[] colors = new Color[] {
				new Color(64, 69, 188),
				new Color(70, 172, 63),
				new Color(150, 171, 42),
				new Color(166, 119, 41),
				new Color(190, 98, 61),
				new Color(182, 55, 64)};
		float y = 175;
		for(int c = 0; c < colors.length; c++) {
			Color color = colors[c];
			for(int x = 0; x < gc.getWidth(); x+=50) {
				Box b = new Box(x, y, 50, 15, color, true);
				b.setSound(block[c]);
				boxes.add(b);
			}
			y -= 15;
		}
		
	}
	
	@Override
	// Called every frame
	// updates game logic (positions, speeds, etc.)
	// delta in milliseconds the time from the last update call
	public void update(GameContainer gc, int delta) throws SlickException {
		float ds = delta / 1000f;
		
		player.update(ds, gc);
		ball.update(ds, gc, boxes, player);
		
	}
	
	@Override
	// Called every frame
	// draws to screen
	// g the graphics object being used to draw to the screen
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		player.render(g);
		ball.render(g);
		for(Box b: boxes)
			b.render(g);
		
		
	}
	
}