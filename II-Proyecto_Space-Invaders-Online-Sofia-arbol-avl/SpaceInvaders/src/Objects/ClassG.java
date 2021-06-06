package Objects;

import java.awt.Graphics2D;
import java.util.Comparator;
import java.util.Random;

import DataStructures.ArbolAvl;

public class ClassG extends  InvaderLine implements  Drawable{
    public ClassG(int posX, int posY, int speed, int size, int lvl) {
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        //this.setEn(new ArbolAvl<Invader>());
        
        ArbolAvl<Invader> arbol = new ArbolAvl<Invader>();

        while(counter < size) {
            String sprite = "Invader_1";
             
            boolean agregado = false;
            while (!agregado)
            { 
                Invader enemy = new Invader(posX, posY, 50, 50, lvl, speed, sprite);
                agregado = arbol.add(enemy);
            } 
	        counter++;
        }
        
        this.setEnemies(arbol);

        this.setLineClass("ArbolAVL");

    }



    @ Override
    public void draw(Graphics2D g) {
        for(int c = 0; c < this.getEnemies().size(); c++) {
            this.getEnemies().get(c).draw(g);
        }
    }

    @ Override
    public void update(double delta) {
        this.setHaveBoss(false);;
        for(int c = 0; c < this.getEnemies().size(); c++) {
            this.getEnemies().get(c).setPosY(this.getEnemies().get(c).getPosY()+this.getSpeed());
            this.getEnemies().get(c).update(delta);
            if(this.getEnemies().get(c).isBoss()) {
                this.setHaveBoss(true);
            }
        }
        this.arrangeLine(); 
    }
}
