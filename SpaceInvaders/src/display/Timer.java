package display;

/**
 *
 */
public class Timer {
	private long prevTime;

	/**
	 *
	 */
	public Timer() {
		prevTime = System.currentTimeMillis();
	}

	/**
	 *
	 */
	public void resetTimer() {
		prevTime = System.currentTimeMillis();
	}

	/**
	 *
	 * @param timer
	 * @return
	 */
	public boolean timerEvent(int timer) {
		if(System.currentTimeMillis()-getPrevTime() > timer) {
			resetTimer();
			return true;
		}
		
		return false;
	}

	/**
	 *
	 * @return
	 */
	public long getPrevTime() {
		return prevTime;
	}

	/**
	 *
	 * @param prevTime
	 */
	public void setPrevTime(long prevTime) {
		this.prevTime = prevTime;
	}


		

}
