package org.usfirst.frc.team5962.robot.sensors;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AMT103_V {

	Encoder AMT103;
	
	boolean isInverted = true;
	
	public AMT103_V() {
		
		AMT103 = new Encoder(8, 9, true, Encoder.EncodingType.k4X);
		//Determines by (2 * pi * (.5)) / (48 tickes per revolution 1,1,1,1)
		AMT103.setDistancePerPulse(.06545);
	}
	
	public void reset() {
		AMT103.reset();
	}
	
	public void invert() {
		isInverted = true;
	}
	
	public double getDistance() {
		SmartDashboard.putString("AMT103 Encoder Distance", "" + AMT103.getDistance());

		double distance = AMT103.getDistance();
		if(isInverted)
			distance = -distance;
		return distance;
	}
}
