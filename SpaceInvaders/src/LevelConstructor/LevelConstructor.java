package LevelConstructor;

import Objects.Basic;
import Objects.Drawable;
import Objects.InvaderRow;
import java.awt.Graphics2D;
public class LevelConstructor implements Drawable {
        private InvaderRow current;
        private InvaderRow next;
        private int lineCounter, lvl;

        public LevelConstructor(int lvl) {
            current = new Basic(280*3/2, -60, 1, 7, lvl);
            next = this.createNewLine();
            lineCounter = 0;
            this.lvl = lvl;
        }

        public InvaderRow createNewLine() {

            int size = 6;
            ++lineCounter;

            return new Basic(280*3/2, -60, lineCounter, size, this.lvl);

        }

        public InvaderRow getCurrent() {
            return current;
        }

        public void nextLine() {
            current = next;
            next = this.createNewLine();
        }

        public int getLineCounter() {
            return lineCounter;
        }

        public InvaderRow getNext() {
            return next;
        }



    @Override
    public void draw(Graphics2D g) {
        this.current.draw(g);
    }

    @Override
        public void update(double delta) {
            if((current.getLineClass() == "LineClassA" || current.getLineClass() == "LineClassB" || current.getLineClass() == "LineClassE") && !current.isHaveBoss()) {
                this.nextLine();
                return;
            } else if(current.getEnemies().length() == 0) {
                this.nextLine();
                return;
            }
            for(int c = 0; c < this.current.getEnemies().length(); c++) {
                if(current.getEnemies().get(c).getPosY() > 600) {
                    this.nextLine();
                    return;
                }
            }
            if(current.getEnemies().length() == 0) {
                this.nextLine();
            }
            this.current.update(delta);
        }

    }
