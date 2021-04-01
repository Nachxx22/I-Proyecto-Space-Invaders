package State_Machine;

import DataStructures.SimpleLinkedList;
import ScreenDisplay.Game;
import ScreenDisplay.GameScreen;

import java.awt.*;

public class StateMachine {
    private Canvas canvas;
    private SimpleLinkedList<SuperStateMachine> states = new SimpleLinkedList<SuperStateMachine>();
    private byte selectState;

    public StateMachine(Canvas canvas) {
        this.canvas = canvas;

        SuperStateMachine game = new GameScreen(this);

        states.add(game);
    }

    public void draw(Graphics2D g) {
        states.get(selectState).draw(g);
    }

    public void update(double delta) {
        states.get(selectState).update(delta);
    }

    public void setState(byte i) {
        for(int r = 0; r < canvas.getKeyListeners().length; r++)
            canvas.removeKeyListener(canvas.getKeyListeners()[r]);
        selectState = i;
        states.get(selectState).init(canvas);
    }

    public byte getStates() {
        return selectState;
    }
}
