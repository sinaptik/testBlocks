package game;

import java.util.Random;

public class RandomEmitter extends Emitter 
{
	public RandomEmitter(int startX, int startY) 
	{
		super(startX, startY);
	}
	
	@Override
	public void update(int step) 
	{
		if (step % 10 == 0)
			emitParticle();
		
		super.update(step);
	}
	
	public void emitParticle()
	{
		Random randomGenerator = new Random();
		
		//emit once every 1 steps
		Particle p = new Particle(super.getCenterX(), super.getCenterY(), randomGenerator.nextInt(20) - 10, randomGenerator.nextInt(20) - 10);
		super.particles.add(p);

	}
}
