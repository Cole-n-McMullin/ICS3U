package autonomous;

import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.robotics.subsumption.Behavior;

/**Soundsnsr
 * 16/06/2017
 * @author Cole McMullin
 * class that ends the program if a loud sound is detected.
 */
public class Soundsnsr implements Behavior {
	boolean suppressed = false;
	private SoundSensor snad;
	
	/**
	 * constructor
	 * @param ss sound sensor
	 */
	public Soundsnsr(SoundSensor ss){
		this.snad = ss;
	}
	
	/**
	 * allows the action to happen if the sound sensor regesters a loud sound
	 */
	@Override
	public boolean takeControl() {
		if (snad.readValue() > 80){
			return true;
		}
		return false;
	}
	
	/**
	 * ends the program
	 */
	@Override
	public void action() {
		suppressed = false;
		System.exit(0);
		while(!suppressed)
			Thread.yield();
	}
	
	/**
	 * when called it stops / prevents the action from happening
	 */
	@Override
	public void suppress() {
		suppressed = true;
	}

}
