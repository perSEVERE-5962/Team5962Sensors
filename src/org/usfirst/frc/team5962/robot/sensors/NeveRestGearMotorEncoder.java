package org.usfirst.frc.team5962.robot.sensors;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NeveRestGearMotorEncoder {

	Encoder neveRestEncoder;
	
	boolean isInverted = false;
	
	public NeveRestGearMotorEncoder() {
		
		neveRestEncoder = new Encoder(6, 7, true, Encoder.EncodingType.k4X);
		//Determines distance of the string by 2*pi*(1) / 420;
		neveRestEncoder.setDistancePerPulse(.0149);

	}
	
	public void reset() {
		neveRestEncoder.reset();
	}
	
	public void invert() {
		isInverted = true;
	}
	
	public double getDistance() {
		SmartDashboard.putString("Neve Rest Encoder Distance", "" + neveRestEncoder.getDistance());

		double distance = neveRestEncoder.getDistance();
		if(isInverted)
			distance = -distance;
		return distance;
	}
}
