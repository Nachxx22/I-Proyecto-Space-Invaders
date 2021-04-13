package Objects;
import java.awt.Canvas;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.SwingUtilities;

public class Mouse {
    private Canvas cursor;
    private Point pos;
    public Mouse(Canvas game){
        cursor = game;
    }
    public void updatePosition(){
        pos = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(pos, cursor);
    }
    public int getMouseX(){
        return pos.x;
    }

    public boolean mouseClicked() {
        return true;
    }
}
