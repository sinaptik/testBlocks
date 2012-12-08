package game;

import java.util.ArrayList;

public class Emitter 
{
	private int centerX, centerY;
	
	protected ArrayList<Particle> particles = new ArrayList<Particle>();
	
	public Emitter(int startX, int startY)
	{
		centerX = startX;
		centerY = startY;
	}
	
	public void setCenterX(int centerX) 
	{
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) 
	{
		this.centerY = centerY;
	}
	
	public int getCenterX() 
	{
		return centerX;
	}

	public int getCenterY() 
	{
		return centerY;
	}
	
	public ArrayList<Particle> getParticles() 
	{
		return particles;
	}
	
	public void EmitParticle()
	{
		Particle p = new Particle(centerX, centerY);
		particles.add(p);
	}

	public void update(int step) 
	{		
		for (int i = 0; i < particles.size(); i++) 
		{
			Particle p = (Particle) particles.get(i);
			
			if (p.isVisible() == true) 
			{
				p.update();
			} 
			else 
			{
				particles.remove(i);
			}
		}
	}
}
