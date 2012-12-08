package game;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

public class Main extends Applet implements Runnable, KeyListener 
{
	private static final long serialVersionUID = 1L;
	
	private URL base;
	private Image image;
	private Graphics second;
	
	private Emitter emitter;
	
	@Override
	public void init() 
	{
		setSize(800, 480);
		
		setBackground(Color.WHITE);
		
		setFocusable(true);
		
		addKeyListener(this);
		
		Frame frame = (Frame) this.getParent().getParent();
		
		frame.setTitle("Game");
		
		try 
		{
			base = getDocumentBase();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	
	@Override
	public void start() 
	{
		emitter = new RandomEmitter(150, 150);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void paint(Graphics g) 
	{
		ArrayList<Particle> particles = emitter.getParticles();
		
		//paint particles on the screen
		for (int i = 0; i < particles.size(); i++) 
		{
			Particle p = (Particle) particles.get(i);
			
			g.setColor(Color.BLACK);
			g.fillRect(p.getX(), p.getY(), 2, 2);
		}
		
		//paint emitter
		g.setColor(Color.RED);
		g.fillRect(emitter.getCenterX(), emitter.getCenterY(), 5, 5);
	}
	
	@Override
	public void update(Graphics g) 
	{
		if (image == null) 
		{
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);

	}
	
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		switch (arg0.getKeyCode()) 
		{
		case KeyEvent.VK_UP:
			emitter.setCenterY(emitter.getCenterY() - 1);
			break;

		case KeyEvent.VK_DOWN:
			emitter.setCenterY(emitter.getCenterY() + 1);
			break;

		case KeyEvent.VK_LEFT:
			emitter.setCenterX(emitter.getCenterX() - 1);
			break;

		case KeyEvent.VK_RIGHT:
			emitter.setCenterX(emitter.getCenterX() + 1);
			break;

		case KeyEvent.VK_SPACE:
			System.out.println("SPACE");
			emitter.EmitParticle();
			break;

		case KeyEvent.VK_CONTROL:

			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
	}
	
	@Override
	public void run() 
	{
		int step = 0;
		
		while (true) 
		{
			emitter.update(step);
			
			repaint();
			
			try 
			{
				Thread.sleep(17);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			step++;
		}
	}
}
