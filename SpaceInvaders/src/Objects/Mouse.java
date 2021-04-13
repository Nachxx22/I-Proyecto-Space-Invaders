package Objects;

import javax.swing.*;
import java.awt.*;

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
