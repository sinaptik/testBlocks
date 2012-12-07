package game;

public class Particle 
{
	private int x, y, speedX, speedY;
	private boolean visible;
	
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
		x += speedX;
		y += speedY;
		
		if (x > 800 || x < 0)
		{
			visible = false;
		}
		
		if (y > 480 || y < 0)
		{
			visible = false;
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
