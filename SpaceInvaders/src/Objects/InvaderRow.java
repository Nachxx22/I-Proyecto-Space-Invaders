package Objects;
import DataStructures.List;
public class InvaderRow {
    private List<Invader> enemies;
    private int posX, posY, speed;
    private String lineClass;
    private boolean haveBoss;

    public InvaderRow(int posX, int posY, int speed, int size, int lvl) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.lineClass = "InvaderRow";
        this.haveBoss = false;

    }

    public List<Invader> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Invader> enemies) {
        this.enemies = enemies;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getSpeed() {
        return speed;
    }


    public String getLineClass() {
        return lineClass;
    }

    public void setLineClass(String lineClass) {
        this.lineClass = lineClass;
    }

    public boolean isHaveBoss() {
        return haveBoss;
    }

    public void setHaveBoss(boolean haveBoss) {
        this.haveBoss = haveBoss;
    }

    public void arrangeRow() {
        int Dist = 0;
        for(int i = 0; i < this.getEnemies().length(); i++) {
            this.getEnemies().get(i).setPosX(Dist);
            Dist += 35 + this.getEnemies().get(i).getWidth();
        }
        Dist = (840 - this.getEnemies().get(this.getEnemies().length()-1).getPosX() - this.getEnemies().get(this.getEnemies().length()-1).getWidth())/2;
        for(int i = 0; i < this.getEnemies().length(); i++) {
            this.getEnemies().get(i).setPosX(Dist + this.getEnemies().get(i).getPosX());
        }
    }
}
