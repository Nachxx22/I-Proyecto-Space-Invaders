package Objects;

import java.awt.Graphics2D;
import java.util.Random;

/**
 * Clase del invasor enemigo, características básicas, es jefe...
 */
public class Invader extends Moveable implements Drawable, Comparable<Invader> {
	private int resistance;
	private boolean boss; 
	private int id;

	public Invader(int posX, int posY, int width, int height, int resistance, int speed, String spriteName) {
		super(posX, posY, width, height, speed, spriteName);
		this.resistance = resistance;

		Random r = new Random();

		id = r.nextInt(100);
		this.boss = false;
	}
	
	public int getId()
	{
		return id;
	}
	
	public boolean destroy() {
		--resistance;
		return (resistance <= 0);
	}
	
	public void setBoss() {
		this.boss = true;

		this.resistance = 5;
		this.setImage("Boss_1");
		this.setWidth(100);
		this.setHeight(75);
	}



	public int getResistance() {
		return resistance;
	}

	public boolean isBoss() {
		return boss;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(this.getSprite(), this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight(), null);


	}

	@Override
	public void update(double delta) {

		this.setRect();
	}

	@Override
	public int compareTo(Invader o) {
		// TODO Auto-generated method stub

	     int id = Integer.compare(this.id, o.id);
		
		return id;
	}
}
