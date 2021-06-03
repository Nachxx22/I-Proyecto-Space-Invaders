package Objects;

import DataStructures.BinarySearchTree;

import java.awt.*;

public class BST extends InvaderLine implements Drawable{
    public BST(int posX, int posY, int speed, int size, int lvl){
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        this.setTreeEnemies(new BinarySearchTree());
        while(counter < size) {


            String sprite = "Invader_1";

            Invader enemy = new Invader(posX, posY, 50, 50, lvl, speed, sprite);
            //this.getTreeEnemies().insert(enemy);
            counter++;
        }
        this.setLineClass("BST");
    }

    @Override
    public void draw(Graphics2D g) {
        for(int c = 0; c < this.getTreeEnemies().tamaño(); c++){
            this.getTreeEnemies().contiene(c).draw(g);
        }
    }
    /*
    @Override
    public void paint(Graphics2D g) {
        for(int c = 0; c < this.getTreeEnemies().tamaño(); c++){
            this.getTreeEnemies().paint(g);
        }
    }
   
     */

    @Override
    public void update(double delta) {
        for(int c = 0; c < this.getEnemies().size(); c++) {
            this.getEnemies().get(c).setPosY(this.getEnemies().get(c).getPosY() + this.getSpeed());
            this.getEnemies().get(c).update(delta);
        }
    }

}
