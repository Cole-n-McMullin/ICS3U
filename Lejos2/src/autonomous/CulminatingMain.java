package autonomous;

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
/**CulminatingMain
 * 16/06/2017
 * @author Cole McMullin
 *program that looks for and sorts boxes based on colour; collecting light coloured boxes, and ignoring dark coloured boxes.
 */
public class CulminatingMain {

	public static void main(String[] args) {
		//program starts on a button press
		Button.waitForAnyPress();
		
		//declares sensors
		UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S1);
		SoundSensor snad = new SoundSensor(SensorPort.S3, true);
		LightSensor light = new LightSensor(SensorPort.S2);
		
		//declares behaviors
		Behavior sound = new Soundsnsr(snad);
		Behavior ultrasonic = new Ultrasonicsnsr(ultra);
		//this is called weight because i was having trouble refactoring it to be named something more descriptive.
		Behavior weight = new Accel(ultra, light);
		Behavior drive = new DriveForward();
		
		//creates arbitrator
		Behavior [] behaviors = {drive, ultrasonic,/**/weight,/**/ sound};
		Arbitrator arby = new Arbitrator(behaviors);
		arby.start();
		
	}


}
