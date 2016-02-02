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

import org.omg.CORBA.PUBLIC_MEMBER;
import org.usfirst.frc2538.Stronghold2538.Robot;
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
public class arm extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController armScrew = RobotMap.armArmScrew;
    private final SpeedController armExtension = RobotMap.armArmExtension;
    private final RobotDrive robotDrive21 = RobotMap.armRobotDrive21;
    private final DigitalInput sheniqua = RobotMap.armSheniqua;
    private final DigitalInput josh = RobotMap.armJosh;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public boolean armExtended = false;
    public double armSpeed = Robot.oi.secondaryStick.getY();

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void extendArm() {
    	//armExtended = RobotMap.armSheniqua.get();
    	if (armExtended) {
			armScrew.set(0.0);
		}
    	else {
    	armScrew.set(armSpeed);
    	}
    }
    public void miniArmExtend() {
		
	}
    public void miniArmRetract() {
		
	}
    private void publicvoid() {
		// TODO Auto-generated method stub

	}
}

