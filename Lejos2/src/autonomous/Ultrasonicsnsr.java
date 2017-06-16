package autonomous;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

/**Ultrasonicsnsr
 * 16/06/2017
 * @author Cole McMullin
 *class that drives the robot forward so that the box is directly in front of it within the range of the light sensor.
 */
public class Ultrasonicsnsr implements Behavior {
	boolean suppressed = false;
	private UltrasonicSensor ultra;
	int[] dist = new int[8];
	
	/**
	 * constructor
	 * @param us ultasonic sensor
	 */
	public Ultrasonicsnsr(UltrasonicSensor us){
		this.ultra = us;
	}

	/**
	 * allows the action to happen if the robot is within 100cm of a box
	 */
	@Override
	public boolean takeControl() {
		ultra.getDistances(dist);
		if( dist[0] < 100){
			return true;
		}
		return false;
	}

	/**
	 * drives the robot up to the box 
	 */
	@Override
	public void action() {
		suppressed = false;
		System.out.println("Ultrasonic");
		Motor.B.stop();
		Motor.B.setSpeed(360);
		Motor.C.setSpeed(360);
		Motor.B.forward();
		Motor.C.forward();
		while (!(dist[0] < 15)){
			ultra.getDistances(dist);
		}
		Motor.B.stop(true);
		Motor.C.stop();
		//moves the robot forward so that the light sensor will be able to tell the colour of the box
		Motor.B.rotate(90, true);
		Motor.C.rotate(90);
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
