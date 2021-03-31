package ScreenDisplay;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.*;

public class Game extends Canvas implements Runnable {
        private static final long serialVersionUID = 1L;
        private final int WIDTH = 350, HEIGHT = 200, SCALE = 3;

        private boolean running = false;
        private Thread thread;

        private int FPS;
        private JFrame frame;

    public Game() {
        this.setSize(WIDTH * SCALE, HEIGHT * SCALE);
        this.setFocusable(true);
    }
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public static void main(String args[]) {
        Game game = new Game();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.pack();

        frame.setTitle("Space Invaders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        game.setFrame(frame);
        game.start();
    }
    public synchronized void start() {
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running)
            return;

        running = false;
        try {
            thread.join();
        } catch(InterruptedException e) {e.printStackTrace();}}

        public void run() {
            long timer = System.currentTimeMillis();
            long lastTime = System.nanoTime();
            final int TARGET_FPS = 60;
            final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
            int frames = 0;

            this.createBufferStrategy(3);
            BufferStrategy bs = this.getBufferStrategy();

            while (running) {
                long now = System.nanoTime();
                long updates = now - lastTime;
                lastTime = now;
                double delta = updates / (double) OPTIMAL_TIME;

                frames++;

                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    FPS = frames;
                    frames = 0;

                    System.out.println(FPS + " FPS");
                }

                //draw(bs);
                //update(delta);

                try {
                    Thread.sleep((lastTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
                } catch (Exception e) {
                }
            }}}