package de.fhkoeln.gm.ki.remoteControl;

import java.io.NotActiveException;
import java.util.Arrays;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/***
 * Some initial setup, also useful to keep the Bot's state at a certain baseline.
 * Singleton nightmare ho!
 * 
 * To ensure this works, you need LejOS NXJ
 * (http://www.lejos.org/nxj-downloads.php)
 * If you're having trouble with LejOS, try  installing a 32bit JDK
 * 
 * @author Sascha Schewe
 *
 */
public class BotMonitor {
	
	public static UltrasonicSensor USS;
	private int minUSSWarningrange=50;
	private int USSWarningrange= 200;
	private boolean initialized=false;
	
	private static BotMonitor self;	
	private BotMonitor(){}
	
	public static BotMonitor getInstance(){
		if(self==null)
			self = new BotMonitor();
		return self;
	}
	/**
	 * Will initialize the BotMonitor if a bot is connected
	 * @param force whether to force a reinitialization
	 * @return whether the BM was successfully initialized
	 */
	public boolean initialize(boolean force){
		if(!Connector.isConnected()||initialized&&!force)
			return false;
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
		Motor.C.resetTachoCount();
		Motor.A.setStallThreshold(5, 2);
		Motor.B.setStallThreshold(5, 2);
		Motor.C.setStallThreshold(5, 2);
		USS = new UltrasonicSensor(SensorPort.S1);
		USS.continuous();
		USS.getDistance();
		USS.getDistance();
		USS.getDistance();
		USS.getDistance();
		USS.getDistance();		
		initialized=true;
		return initialized;
	}
	
	/***
	 * Checks whether the Sensor is still able to detect anything.
	 * Smaller range than actual sensor max range to ensure the issue is raised 
	 * early enough to correct before it causes false sensor readings.
	 * @return Distance < USSWarningrange
	 * @throws NotActiveException if BotMonitor not initialized
	 */
	public boolean checkSensorRange() throws NotActiveException{
		if(!initialized)
			throw new NotActiveException("Botmonitor not initialized");
		int test = USS.getDistance();
		return test <USSWarningrange&&test>minUSSWarningrange;
	}
	
		
	/***
	 * Attempts to reset the Arm to its original position
	 */
	public void resetArm(){
		if(!initialized)
			return;
		Motor.A.rotateTo(0);
		Motor.B.rotateTo(0);
		Motor.C.rotateTo(0);
		Motor.A.rotateTo(0);
		Motor.B.rotateTo(0);
		Motor.C.rotateTo(0);
	}

}
