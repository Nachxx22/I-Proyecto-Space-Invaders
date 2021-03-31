package Objects;
import DataStructures.SimpleLinkedList;
import java.awt.*;

public class Basic extends InvaderRow implements Drawable {
    public Basic(int posX, int posY, int speed, int size, int lvl) {
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        this.setEnemies(new SimpleLinkedList<Invader>());
        while(counter < size) {
            String sprite = "";
            Invader invader = new Invader(posX, posY, 30, 50, lvl, speed, sprite);
            this.getEnemies().add(invader);
            counter++;
        }
        this.setLineClass("Basic");
    }

    @ Override
    public void draw(Graphics2D g) {
        for(int c = 0; c < this.getEnemies().length(); c++) {
            this.getEnemies().get(c).draw(g);
        }
    }

    @ Override
    public void update(double delta) {
        for(int c = 0; c < this.getEnemies().length(); c++) {
            this.getEnemies().get(c).setPosY(this.getEnemies().get(c).getPosY() + this.getSpeed());
            this.getEnemies().get(c).update(delta);
        }
        this.arrangeRow();

        }
    }


