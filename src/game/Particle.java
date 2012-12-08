package game;

public class Particle 
{
	private int x, y, speedX, speedY;
	private boolean visible;
	private int tick;
	
	public Particle(int startX, int startY)
	{
		x = startX;
		y = startY;
		
		speedX = 5;
		speedY = 5;
		
		visible = true;
	}
	
	public Particle(int startX, int startY, int spX, int spY)
	{
		x = startX;
		y = startY;
		
		speedX = spX;
		speedY = spY;
		
		visible = true;
	}
	
	public void update()
	{
		updatePosition();
		
		checkCollisionsWithWalls();
		
		checkVisibility();
		
		decelerate();
		
		applyGravity();
		
		tick++;
	}
	
	private void applyGravity()
	{
		if (tick % 100 == 0)
		{
			speedY++;
		}
	}
	
	private void decelerate()
	{
		if (tick % 100 == 0)
		{
			if (speedX > 0)
				speedX--;
			
			if (speedY > 0)
				speedY--;
		}
	}
	
	private void updatePosition()
	{
		x += speedX;
		y += speedY;
	}
	
	private void checkVisibility()
	{
		if (x > 800 || x < 0)
		{
			visible = false;
		}
		
		if (y > 480 || y < 0)
		{
			visible = false;
		}
	}
	
	private void checkCollisionsWithWalls()
	{
		//right side
		if (x == 800 || (x + speedX) > 800)
		{
			speedX = -speedX;
		}
		
		//left side
		if (x == 0 || (x + speedX) < 0)
		{
			speedX = -speedX;
		}
		
		//top side
		if (y == 0 || (y + speedY) < 0)
		{
			speedY = -speedY;
		}
		
		//bottom side
		if (y == 480 || (y + speedY) > 480)
		{
			speedY = -speedY;
		}
	}

	public int getX() 
	{
		return x;
	}

	public int getY() 
	{
		return y;
	}

	public int getSpeedX() 
	{
		return speedX;
	}

	public boolean isVisible() 
	{
		return visible;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public void setSpeedX(int speedX) 
	{
		this.speedX = speedX;
	}

	public void setVisible(boolean visible) 
	{
		this.visible = visible;
	}
}
