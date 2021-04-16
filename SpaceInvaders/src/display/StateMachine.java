package display;

import java.awt.Canvas;
import java.awt.Graphics2D;

import DataStructures.SimplyLinkedList;
import Objects.Audio;

/**
 *
 */
public class StateMachine {
	private Canvas canvas;
	private SimplyLinkedList<SuperStateMachine> states = new SimplyLinkedList<SuperStateMachine>();
	private byte selectState;
	private Audio BackG,BackM;

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
		if(i == 0){
			if (BackM != null){
				BackM.Stop();
			}
			BackG = new Audio("SpaceInvaders/Tracks/Menu.wav");

		}
		if (i == 1){
			BackM = new Audio("SpaceInvaders/Tracks/Tank!.wav");
			if (BackG != null){
				BackG.Stop();
			}

		}
		for(int r = 0; r < canvas.getKeyListeners().length; r++)
			canvas.removeKeyListener(canvas.getKeyListeners()[r]);
		selectState = i;
		states.get(selectState).init(canvas);
	}
	public void StopM(){
		BackM.Stop();
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
