package display;

import java.awt.Canvas;
import java.awt.Graphics2D;

import DataStructures.LinkedList;

/**
 *
 */
public class StateMachine {
	private Canvas canvas;
	private LinkedList<SuperStateMachine> states = new LinkedList<SuperStateMachine>();
	private byte selectState;

	/**
	 *
	 * @param canvas
	 */
	public StateMachine(Canvas canvas) {
		this.canvas = canvas;
		SuperStateMachine menu = new Menu(this);
		SuperStateMachine game = new Game(this);

		states.add(menu);
		states.add(game);

	}

	/**
	 *
	 * @param g
	 */
	public void draw(Graphics2D g) {
		states.get(selectState).draw(g);
	}

	/**
	 * Metodo que actualiza el juego utilizando el statemachine.
	 * @param delta
	 */
	public void update(double delta) {
		states.get(selectState).update(delta);
	}

	/**
	 *
	 * @param i
	 */
	public void setState(byte i) {
		for(int r = 0; r < canvas.getKeyListeners().length; r++)
			canvas.removeKeyListener(canvas.getKeyListeners()[r]);
		selectState = i;
		states.get(selectState).init(canvas);
	}

	/**
	 *
	 * @return
	 */
	public Canvas getCanva() {

		return canvas;
	}

	/**
	 *
	 * @return
	 */
	public byte getStates() {
		return selectState;
	}
}
