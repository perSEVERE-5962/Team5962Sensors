package org.usfirst.frc.team5962.robot.sensors;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BagMotorEncoder {

	Encoder bagMotorEncoder;
	
	boolean isInverted = false;
	
	public BagMotorEncoder() {
		
		bagMotorEncoder = new Encoder(4, 5, true, Encoder.EncodingType.k4X);
		//Determine by (2 * pi * (.5)) / 1024
		bagMotorEncoder.setDistancePerPulse(.003068);
	}
	
	public void reset() {
		bagMotorEncoder.reset();

	}
	
	public void isInverted() {
		isInverted = true;
	}
	
	public double getDistance() {
		SmartDashboard.putString("Bag Motor Encoder Distance", "" + bagMotorEncoder.getDistance());

		double distance = bagMotorEncoder.getDistance();
		if(isInverted)
			distance = -distance;
		return distance;
	}
}
