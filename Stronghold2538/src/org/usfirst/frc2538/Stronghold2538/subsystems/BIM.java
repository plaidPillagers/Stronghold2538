// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2538.Stronghold2538.subsystems;

import org.usfirst.frc2538.Stronghold2538.RobotMap;
import org.usfirst.frc2538.Stronghold2538.commands.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class BIM extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController bIMwheels = RobotMap.bIMBIMwheels;
    private final SpeedController bIMwheels2 = RobotMap.bIMBIMwheels2;
    private final RobotDrive robotDrive21 = RobotMap.bIMRobotDrive21;
    private final SpeedController bIMmove = RobotMap.bIMBIMmove;
    private final SpeedController speedController2 = RobotMap.bIMSpeedController2;
    private final RobotDrive robotDrive22 = RobotMap.bIMRobotDrive22;
    private final DigitalInput bimDown = RobotMap.bIMbimDown;
    private final DigitalInput bimUp = RobotMap.bIMbimUp;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public double intakeSpeed = 1;
    public double ejectSpeed = -1;
    public boolean bimLowered = false;
    public boolean bimRaised = false;
    public void wheelIntake() {
    	bIMwheels.set(intakeSpeed);
    	bIMwheels2.set(intakeSpeed);
    }
    public void wheelEject() {
    	bIMwheels.set(ejectSpeed);
    	bIMwheels2.set(ejectSpeed);
    }
    public void wheelStop() {
    	bIMwheels.set(0.0);
    	bIMwheels2.set(0.0);
    }
    public void bimRotation(double speed) {
    	bimLowered = RobotMap.bIMbimDown.get();
    	bimRaised = RobotMap.bIMbimUp.get();
    	if (speed < 0) {
    		if (bimRaised) {
    			bIMmove.set(0);
    		}
    		else {
				bIMmove.set(speed);
			}
				
		}
    	else {
			if (bimLowered) {
				bIMmove.set(0);
			}
			else {
				bIMmove.set(speed);
			}
		}
    }
    public void moveUp() {
    	bimRotation(-0.25);
    }
    public void moveDown() {
    	bimRotation(0.25);
    }
}

