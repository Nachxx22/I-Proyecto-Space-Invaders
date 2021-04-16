package display;
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

import Objects.Audio;
import Objects.Level;
import Objects.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Objects.Mouse;

/***
 *
 */
public class Game extends SuperStateMachine implements KeyListener, MouseListener {
	private Player player;
	private Level level;
	private int levelCounter;
	private int score;
	private BufferedImage bg;
	private Font GMFont = new Font("Impact", Font.PLAIN, 28);
	private Mouse pointer;
	private int setA=0;
	public boolean playM= true;

	/**
	 *
	 * @param stateMachine
	 */
	public Game(StateMachine stateMachine) {
		super(stateMachine);
		player =  Player.getInstance();
		level = new Level(1);
		levelCounter = 1;
		score = 0;
		pointer = new Mouse(stateMachine.getCanva());


		try {
			URL url = this.getClass().getResource("/Sprites/Background.png");
			bg = ImageIO.read(url);
		} catch(IOException e) {e.printStackTrace();}
	}


	/**
	 *
	 */
	public void reset() {
		level = new Level(1);
		player =  Player.getInstance();
		levelCounter = 1;
		score = 0;
	}

	/**
	 *
	 * @param g
	 */
	public void gameOver(Graphics2D g) {
		this.getStateMachine().StopM();
		g.setColor(Color.black);
		g.fillRect(0, 0, 350*3+10, 200*3+10);
		BufferedImage go = null;
		try {
			URL url = this.getClass().getResource("/Sprites/GameOver.png");
			go = ImageIO.read(url);
		} catch(IOException e) {e.printStackTrace();}
		g.drawImage(go, (280*3+10)/2-300, 50, go.getWidth(), go.getHeight(), null);

		g.setFont(GMFont);
		g.setColor(Color.white);
		g.drawString(Integer.toString(score), (280*3+10)/2-g.getFontMetrics().stringWidth(Integer.toString(score))/2, 500);
		if (setA==0){
			++setA;
			Audio loss = new Audio("SpaceInvaders/Tracks/GameOver.wav");

		}
	}


	/**
	 *
	 * @param g
	 */
	public void showInfo(Graphics2D g) {
		g.setFont(GMFont);
		g.setColor(Color.white);
		g.drawString(level.getCurrent().getLineClass(), 5, 40);
		g.drawString(Integer.toString(score), 230*3+30, 80);

		BufferedImage heart = null;
		try {
			URL url = this.getClass().getResource("/Sprites/Health.png");
			heart = ImageIO.read(url);
		} catch(IOException e) {e.printStackTrace();}
		for(int i = 0; i < player.getLifes(); i++) {
			g.drawImage(heart, 220*3+30+25*i, 20, 20, 20, null);
		}
	}

	/**
	 *
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 *
	 * @return
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 *
	 * @param g
	 */
	@Override
	public void draw(Graphics2D g) {

			if(!this.player.isAlive()) {
				this.gameOver(g);
				return;
			}

			g.drawImage(bg, 0, 0, 280*3+10, 200*3+10, null);
			g.setColor(Color.gray);
			g.fillRect(280*3+10, 0, 350*3-280*3, 200*3+10);
			this.showInfo(g);
			player.draw(g);
			level.draw(g);
		}


	/**
	 *
	 * @param delta
	 */
	@Override
	public void update(double delta) {
		if(playM){
			playM = false;}
		if(!player.isAlive()) {
			return;
		}
		if(level.getSpeed() == 4) {
			++levelCounter;
			level = new Level(levelCounter);
		}
		// Destroy enemies
		for(int i = 0; i < level.getCurrent().getEnemies().size(); i++) {
			int b = 0;
			if(level.getCurrent().getEnemies().get(i).getPosY() >= 600 - level.getCurrent().getEnemies().get(i).getHeight()) {

				while(player.isAlive()) {
					player.loseLife();

				}

				return;
			}
			while(b < player.getBullets().size()) {
				if(player.getBullets().get(b).isColliding(level.getCurrent().getEnemies().get(i))) {
					player.getBullets().remove(b);
					if(level.getCurrent().getEnemies().get(i).destroy()) {
						Audio exp = new Audio("SpaceInvaders/Tracks/explosion.wav");
						if(level.getCurrent().getEnemies().get(i).isBoss()) {
							this.score += 500;
						} else {
							this.score += 100;

						}
						level.getCurrent().getEnemies().remove(i);
						if(level.getCurrent().getEnemies().size() == 0) {
							level.nextLine();
							level.update(delta);
						}
						--i;
					}
				} else {
					b++;
				}
			}
		}
		level.getCurrent().arrangeLine();



		// Destroy bullets out of the screen
		for(int i = 0; i < player.getBullets().size(); i++) {
			if(player.getBullets().get(i).getPosY() < -50) {
				player.getBullets().remove(i);
				--i;
			}
		}



		// Get collisions between enemies and the player
		for(int i = 0; i < level.getCurrent().getEnemies().size(); i++) {
			if(level.getCurrent().getEnemies().get(i).isColliding(player)) {
				if(level.getCurrent().getEnemies().get(i).isBoss()) {
					this.score += 250;
				} else {
					this.score += 50;
				}
				level.getCurrent().getEnemies().remove(i);
				if(level.getCurrent().getEnemies().size() == 0) {
					level.nextLine();
					level.update(delta);
				}
				player.loseLife();
			}
		}
		// Update

		pointer.updatePosition();
		player.SetPosX(pointer.getMouseX());
		player.update(delta);
		level.update(delta);
	}

	/**
	 *
	 * @param canvas
	 */
	@Override
	public void init(Canvas canvas) {
		canvas.addMouseListener(player);
		canvas.addMouseListener(this);
		canvas.addKeyListener(this);
	}

	/**
	 *
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			this.reset();
			this.getStateMachine().setState((byte) 0);
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

	/**
	 *
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 *
	 * @param e
	 */
	@Override
	public void mousePressed(MouseEvent e) {

	}

	/**
	 *
	 * @param e
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 *
	 * @param e
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 *
	 * @param e
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

}
