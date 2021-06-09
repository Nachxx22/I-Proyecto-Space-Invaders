package DataStructures;

import Objects.Invader;

public class TestBST {

    public static void main(String[] args) {
        BinarySearchTree test = new BinarySearchTree();
        int counter=0;
        int size=6;
        while(counter < size) {


            String sprite = "Invader_1";

            Invader enemy = new Invader(50, 50, 50, 50, 1,10, sprite);
            //this.getEnemies().add(enemy);
            //this.getTreeEnemies().insert(enemy,counter);
            test.insert(enemy,counter);
            counter++;
        }
        try{
            int index=0;
            //test.inOrder(test.root,index);
            counter=0;
            System.out.println("Entrada 0");
            test.getTree(0);
            System.out.println("Entrada 1");
            test.getTree(1);
            System.out.println("Entrada 2");
            test.getTree(2);
            System.out.println("Entrada 3");
            test.getTree(3);
            System.out.println("Entrada 4");
            test.getTree(4);
            System.out.println("Entrada 5");
            test.getTree(5);
            System.out.println("Entrada 6");
            test.getTree(6);
        }catch (NullPointerException e){
            System.out.println("Hay un nodo null");
            e.printStackTrace();
        }

    }
}
