import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class SimpleGame extends BasicGame{

	private Rectangle rectangle;
	private Circle circle;
	
	public SimpleGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		
		rectangle = new Rectangle(100, 100, 150, 150);
		circle = new Circle(375, 175, 75);
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		g.setColor(Color.red);
		
		g.draw(rectangle);
		//g.fillRect(100, 100, 150, 150);
		
		g.setColor(Color.blue);
		
		g.draw(circle);
		//g.fillOval(300, 100, 150, 150);
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}

}