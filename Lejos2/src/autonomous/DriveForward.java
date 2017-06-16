package autonomous;

import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

/**DriveForward
 * 16/06/2017
 * @author Cole McMullin
 *class that makes the robot drive and turn to look for boxes.
 */
public class DriveForward implements Behavior {
	boolean suppressed = false;
	
	/**
	 * allows the action to happen if no other things are happening
	 */
	@Override
	public boolean takeControl() {
		return true;
	}


	/**
	 * drives forward
	 */
	@Override
	public void action() {
		suppressed = false;
		System.out.println("Drive");
		Motor.B.setSpeed(360);
		Motor.B.rotate(360,true);
		Motor.C.rotate(360);
		//starts turning so that the ultrasonic sensor can find a cup later
		Motor.B.setSpeed(72);
		Motor.B.forward();
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
