package org.usfirst.frc.team5962.robot.sensors;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotEncoder {

	Encoder encoderLeft;
	Encoder encoderRight;

	int numberOfEncoders = 2;
	boolean isInverted = false;
	
	public RobotEncoder() {
		encoderLeft = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		encoderRight = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		encoderLeft.setDistancePerPulse(0.069813);
		encoderRight.setDistancePerPulse(0.069813);
	}

	public void setNumberOfEncoders(int numberOfEncoders) {
		this.numberOfEncoders = numberOfEncoders;
	}
	
	

	public void reset() {
		encoderLeft.reset();
		encoderRight.reset();
	}

	public void invert() {
		isInverted = true;
	}
	
	public double getDistance() {
		SmartDashboard.putString("Left Encoder Distance", "" + encoderLeft.getDistance());
		SmartDashboard.putString("Right Encoder Distance", "" + encoderRight.getDistance());

		double distance = ((encoderLeft.getDistance() + encoderRight.getDistance()) / numberOfEncoders);
		
		SmartDashboard.putString("Both Encoder Distance", "" + distance);
		
		if(isInverted)
			distance = -distance;
		//SmartDashboard.putString("Encoder Distance", "" + distance);
		return distance;
	}
	
	public boolean isInverted() {
		return isInverted;
	}

	public void logValues() {
		System.out.println("encoder left = " + encoderLeft.getDistance());
		System.out.println("encoder right = " + encoderRight.getDistance());
	}
}
