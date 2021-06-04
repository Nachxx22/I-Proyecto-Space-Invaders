package Objects;

import DataStructures.BinarySearchTree;
import DataStructures.SimplyLinkedList;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BST extends InvaderLine implements Drawable{
    public BST(int posX, int posY, int speed, int size, int lvl){
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        this.setTreeEnemies(new BinarySearchTree());
        while(counter < size) {


            String sprite = "Invader_1";

            //Invader enemy = new Invader(posX, posY, 50, 50, lvl, speed, sprite);
            //this.getTreeEnemies().insert(enemy);
            counter++;
        }
        this.setLineClass("BST");
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void update(double delta) {

    }
}
