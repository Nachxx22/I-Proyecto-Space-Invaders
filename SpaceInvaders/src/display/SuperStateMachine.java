package display;

import java.awt.Canvas;
import java.awt.Graphics2D;

/**
 *
 */
public abstract class SuperStateMachine {
	private StateMachine stateMachine;

	/**
	 *
	 * @param stateMachine
	 */
	public SuperStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	/**
	 *
	 * @return
	 */
	public StateMachine getStateMachine() {
		return this.stateMachine;
	}

	public abstract void draw(Graphics2D g);
	public abstract void update(double delta);
	public abstract void init(Canvas canvas);
}
