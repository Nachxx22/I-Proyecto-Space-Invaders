package State_Machine;

import java.awt.*;

public abstract class SuperStateMachine {
    private StateMachine stateMachine;

    public SuperStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public StateMachine getStateMachine() {
        return this.stateMachine;
    }

    public abstract void draw(Graphics2D g);
    public abstract void update(double delta);
    public abstract void init(Canvas canvas);
}