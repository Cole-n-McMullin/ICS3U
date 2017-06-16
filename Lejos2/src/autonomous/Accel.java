package autonomous;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

/**Accel
 * 16/06/2017
 * @author Cole McMullin
 *class that sorts boxes based on colour; collecting light coloured boxes, and ignoring dark coloured boxes.
 */
//this is called Accel because i was having trouble refactoring it to be named something more descriptive. 
public class Accel implements Behavior {
	boolean suppressed = false;
	private UltrasonicSensor ultra;
	private LightSensor light;
	int[] dist = new int[8];
	
	/**
	 * constructor
	 * @param us ultasonic sensor
	 * @param ls light sensor
	 */
	public Accel(UltrasonicSensor us, LightSensor ls){
		this.ultra = us;
		this.light = ls;
	}
	
	/**
	 * allows the action to happen if the robot is within 15cm of a box
	 */
	@Override
	public boolean takeControl() {
		ultra.getDistances(dist);
		if (dist[0] < 15 && dist[0] != 0){
			return true;
		}
		return false;
	}
	
	/**
	 * collects the box if it is white and turns away from the box if it is black
	 */
	@Override
	public void action() {
		suppressed = false;
		System.out.println("Accel");

		Motor.B.rotate(90, true);
		Motor.C.rotate(90);
		boolean lgtval = false;

		while(!lgtval){
			if (light.getLightValue() > 40){
				Motor.A.rotate(-105);
				Motor.B.rotate(-150);
				Motor.C.rotate(360);
				Motor.A.rotate(105);
				Delay.msDelay(500);
				Motor.C.rotate(90);
				Motor.A.setSpeed(45);
				Motor.A.rotate(-105);
				Motor.C.rotate(90);
				lgtval = true;
			}
			else if (light.getLightValue() < 40 && light.getLightValue() > 25){
				Motor.B.setSpeed(720);
				Motor.B.rotate(360);
				Motor.B.setSpeed(360);
				lgtval = true;

			}
		}
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
