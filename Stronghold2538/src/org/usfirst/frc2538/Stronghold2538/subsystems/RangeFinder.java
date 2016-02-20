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

import java.sql.Time;

import org.usfirst.frc2538.Stronghold2538.RobotMap;
import org.usfirst.frc2538.Stronghold2538.commands.*;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class RangeFinder extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	
    }
    
    private I2C newRangeFinder;
	private byte[] buffer = new byte[4];
	private static int count = 4;
	private static long echoTime = 0;
	private int rangeCM;
	
	// diagnostic
	public boolean successfulWrite;
	public boolean successfulRead;

	// register addresses, must be in hexadecimle
	private static int writeRegisterAddress = 0xE0; //224
	private static int readRegisterAddress = 0xE1; //225
	
	// write commands
	private static int writeData = 81;
	private static int writeDataHex = 0x51;
	
	// read commands


	public RangeFinder() {
		//224 came from past code it may need to be in hex
		newRangeFinder = new I2C(I2C.Port.kOnboard, writeRegisterAddress);
	}


	public void startSensor() {
		successfulWrite = !newRangeFinder.write(writeRegisterAddress, writeDataHex);
		echoTime = System.currentTimeMillis() + 100;
	}
	
	public int getRangeCM() {
		if (System.currentTimeMillis() >= echoTime) {
			successfulRead = !newRangeFinder.read(readRegisterAddress, count, buffer);
			successfulWrite = !newRangeFinder.write(writeRegisterAddress, writeDataHex);
			rangeCM = buffer[2] * 256 + buffer[3];
			echoTime = System.currentTimeMillis() + 100;
		}
		return rangeCM;
		//return I2C.Port.kOnboard.getValue();
	}
	
	//public void displayDiagnostics() {
		//SmartDashboard.pu
	//}
	

}

