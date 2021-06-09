package Objects;

// import DataStructures.BinarySearchTree;
// import DataStructures.SimplyLinkedList;
import DataStructures.*;

import java.awt.*;

public class BST extends InvaderLine implements Drawable{
    public BST(int posX, int posY, int speed, int size, int lvl){
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        this.setEnemies(new SimplyLinkedList<Invader>());
        this.setTreeEnemies(new BinarySearchTree());
        while(counter < size) {


            String sprite = "Invader_1";

            Invader enemy = new Invader(posX, posY, 50, 50, lvl, speed, sprite);
            this.getEnemies().add(enemy);
            this.getTreeEnemies().insert(enemy,counter);
            counter++;
        }
        this.setLineClass("BST");
    }

    @Override
    public void draw(Graphics2D g) {
        for(int c = 0; c < this.getTreeEnemies().tamaño(); c++){
            this.getTreeEnemies().getTree(c).draw(g);
        }
    }


    @Override
    public void update(double delta) {
        //this.getEnemies().size()
        for(int c = 0; c < this.getTreeEnemies().tamaño(); c++) {
            //this.getEnemies().get(c).setPosY(this.getEnemies().get(c).getPosY() + this.getSpeed());
            this.getTreeEnemies().getTree(c).setPosY(this.getTreeEnemies().getTree(c).getPosY() + this.getSpeed());
            //this.getEnemies().get(c).update(delta);
            this.getTreeEnemies().getTree(c).update(delta);
        }
    }

}
