package display;

import Objects.Audio;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


import javax.imageio.ImageIO;


/**
 *
 */
public class Menu extends SuperStateMachine implements KeyListener {
	private Font titleFont = new Font("Impact", Font.PLAIN, 64);
	private Font startFont = new Font("Impact", Font.PLAIN, 32);
	private String title = "Space Invaders";
	private String start = "Press Enter";

	
	private BufferedImage bg;


	/**
	 *
	 * @param stateMachine
	 */
	public Menu(StateMachine stateMachine) {
		super(stateMachine);
		
		try {
			URL url = this.getClass().getResource("/Sprites/Background.png");
			bg = ImageIO.read(url);
		} catch(IOException e) {e.printStackTrace();}
	}

	/**
	 *
	 * @param g
	 */
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(bg, 0, 0, 280*3, 200*3+10, null);
		
		g.setFont(titleFont);
		int titleWidth = g.getFontMetrics().stringWidth(title);
		g.setColor(Color.black);
		g.drawString(title, (280*3/2)-(titleWidth/2)+2, 300+2);
		g.setColor(Color.white);
		g.drawString(title, (280*3/2)-(titleWidth/2), 270);
		
		g.setFont(startFont);
		int startWidth = g.getFontMetrics().stringWidth(title);
		g.setColor(Color.white);
		g.drawString(start, (280*3/2)-(startWidth/2)+30, 500);
	}

	/**
	 *
	 * @param delta
	 */
	@Override
	public void update(double delta) {}

	/**
	 *
	 * @param canvas
	 */
	@Override
	public void init(Canvas canvas) {
		canvas.addKeyListener(this);
	}

	/**
	 *
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ENTER) {
			this.getStateMachine().setState((byte) 1);

		}
	}

	/**
	 *
	 * @param e
	 */
	@Override
	public void keyReleased(KeyEvent e) {}

	/**
	 *
	 * @param e
	 */
	@Override
	public void keyTyped(KeyEvent e) {}
}
