// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2538.Stronghold2538.subsystems;


import org.usfirst.frc2538.Stronghold2538.*;
import org.usfirst.frc2538.Stronghold2538.commands.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class driveSystem extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Encoder encoder1 = RobotMap.driveSystemEncoder1;
    private final CANTalon leftFrontMotor = RobotMap.driveSystemLeftFrontMotor;
    private final CANTalon leftRearMotor = RobotMap.driveSystemLeftRearMotor;
    private final CANTalon rightFrontMotor = RobotMap.driveSystemRightFrontMotor;
    private final CANTalon rightRearMotor = RobotMap.driveSystemRightRearMotor;
    private final RobotDrive robotDrive41 = RobotMap.driveSystemRobotDrive41;
    private final AnalogInput ultrasonic = RobotMap.driveSystemUltrasonic;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //private final I2C ultrasonic = RobotMap.ultrasonic;
    private final ADXRS450_Gyro gyro = RobotMap.gyro;
    private final Accelerometer accelerometer = RobotMap.accelerometer;
   public boolean isInverted = false;
   public final double JOYSTICK_TOLERANCE = .05;
   public double ultraRange = 0;
   public double angle = 0;
   public final double gyroScaling = .03; 
   public final double ultraForwardRange = 77.65;
   public double rightTurnAngle = 43;
   public double leftTurnAngle = -35;
   public final double turnSpeed = .25;
   public final double goalRange = 5;
   public double encoderDistance = 0;
   public double distanceToGoal = -130;
   public double distanceToTurn = -215.8;
   public double ultraDistance = 0;
   public double accelerometerZ;
  
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new arcadeDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
//    static RobotDrive drive;
	public void arcadeDriveSystem(){
		Joystick driveJoystick = Robot.oi.driveStick;
		double yAccel = RobotMap.accelerometer.getY();
		double zAccel = RobotMap.accelerometer.getZ();
		
		//encoderDistance = encoder1.getDistance();
		double yValue = driveJoystick.getY();
		double xValue = driveJoystick.getX();
		double throttle = driveJoystick.getZ() * (-.25) + .75;
		SmartDashboard.putDouble("y", yValue);
		SmartDashboard.putDouble("x", xValue);
		SmartDashboard.putDouble("encoder value", encoder1.getDistance()*.876 + 1);
		ultraDistance = ultrasonic.getAverageVoltage() / .0098;
		SmartDashboard.putDouble("ultraDistance", ultraDistance);
		SmartDashboard.putDouble("ultraVoltage", ultrasonic.getVoltage());
		SmartDashboard.putDouble("yAccel", yAccel);
		SmartDashboard.putDouble("zAccel", zAccel);
		//getThrottle is actually getZ on madcats joystick
		robotDrive41.arcadeDrive((backwards(minimumTolerance(yValue)) * throttle), reverseTurn(minimumTolerance(xValue)) * throttle);
		
	}
	private double minimumTolerance(double magnitude) {
    	if (magnitude < JOYSTICK_TOLERANCE && magnitude > -JOYSTICK_TOLERANCE) {
			return 0;
		}
    	else {
    		return magnitude;
		}
    }
	public double backwards(double yValue){
		if(isInverted){
			return - yValue;
		}
		return yValue;
	}
	public double reverseTurn(double xValue){
		if (isInverted) {
			return -xValue;
		}
		return xValue;
	}
	public boolean autoGyroStraight() {
		angle = gyro.getAngle();
		//ultraRange = ultrasonic.getRangeInches();
		SmartDashboard.putDouble("analogGyro", angle);
		SmartDashboard.putDouble("ultrasonic", ultraRange);
		//remove gyro
		if (ultraRange > ultraForwardRange) {	
			robotDrive41.arcadeDrive(-0.5, -angle * gyroScaling);
			return false;
		}
		else{
			return true;
		}
	}
	public void resetGyro() {
		gyro.reset();
	}
	public void setRightAngle(double angle) {
		rightTurnAngle = angle;
	}
	public boolean autoGyroRightTurn() {
		angle = gyro.getAngle();
		SmartDashboard.putDouble("gyroTurnAngle", angle);
		if (angle < rightTurnAngle) {
			robotDrive41.arcadeDrive(0.0, .9);
			return false;
		}
		else {
			return true;
		}
	}
	public void setLeftAngle(double angle) {
		leftTurnAngle = angle;
	}
	public boolean autoGyroLeftTurn() {
		angle = gyro.getAngle();
		SmartDashboard.putDouble("gyroTurnAngle", angle);
		if (angle > leftTurnAngle) {
			//check how to turn left
			robotDrive41.arcadeDrive(0.0, -.9);
			return false;
		}
		else {
			return true;
		}
	}
	public boolean autoDriveForward() {
		//ultraRange = ultrasonic.getRangeInches();
		SmartDashboard.putDouble("ultrasonic", ultraRange);
		if (ultraRange < goalRange) {
			robotDrive41.arcadeDrive(.3, 0);
			return false;
		}
		else {
			return true;
		}
	}
	public void stopDriving() {
		robotDrive41.arcadeDrive(0.0, 0.0);
	}
	public void driveForward() {
		robotDrive41.arcadeDrive(.6, 0.0);
	}
	public boolean autoGoalEncoders() {
		encoderDistance = encoder1.getDistance()*.876;
		if (encoderDistance > distanceToGoal) {
			robotDrive41.arcadeDrive(-.7, 0.0);
			return false;
		}
		else {
			robotDrive41.arcadeDrive(0.0, 0.0);
			return true;
		}
	}
	public boolean autoStraightEncoders(double speed) {
		encoderDistance = encoder1.getDistance()*.876;
		if (encoderDistance > distanceToTurn) {
			SmartDashboard.putDouble("drivestraight encoder", encoderDistance);
			robotDrive41.arcadeDrive(speed, .3);
			return false;
		}
		else {
			robotDrive41.arcadeDrive(0.0, 0.0);
			SmartDashboard.putDouble("drive stopped encoder", encoderDistance);
			return true;
		}
	}
	public void setDistanceBeforeTurn(double distanceBeforeTurn) {
		distanceToTurn = distanceBeforeTurn;
		
		// TODO Auto-generated method stub
		
	}
	public void setDistanceToGoal(double distanceToGoal2) {
		distanceToGoal = distanceToGoal2;
		// TODO Auto-generated method stub
		
	}
	public boolean accelerometerToGoal() {
		accelerometerZ = accelerometer.getZ();
		if (accelerometerZ <= 1.01) {
			driveForward();
			return false;
		}
		else {
			stopDriving();
			return true;
		}
	}
}
