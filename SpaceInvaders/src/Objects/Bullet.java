package Objects;

import java.awt.*;
public class Bullet extends MoveObject implements Drawable {
    public Bullet(int posX, int posY, int width, int height, int speed, String sprite) {
        super(posX, posY, width, height, speed, sprite);
    }
    public void draw(Graphics2D g) {
        g.drawImage(this.getSprite(), this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight(), null);
    }
    public void update(double delta) {
        this.setPosY(this.getPosY()+this.getSpeed());
        this.setRect();
    }
}
