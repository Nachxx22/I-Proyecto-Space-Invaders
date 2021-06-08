package DataStructures;

import Objects.Invader;

public class TestBST {

    public static void main(String[] args) {
        BinarySearchTree test = new BinarySearchTree();
        int counter=0;
        int size=2;
        while(counter < size) {


            String sprite = "Invader_1";

            Invader enemy = new Invader(50, 50, 50, 50, 1,10, sprite);
            //this.getEnemies().add(enemy);
            //this.getTreeEnemies().insert(enemy,counter);
            test.insert(enemy,counter);
            counter++;
        }
        test.inOrder(test.root);
        counter=0;
        test.getTree(counter);
    }
}
