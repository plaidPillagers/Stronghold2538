// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2538.Stronghold2538;
    

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Ultrasonic driveSystemUltrasonic;
    public static Encoder driveSystemEncoder1;
    public static CANTalon driveSystemLeftFrontMotor;
    public static CANTalon driveSystemLeftRearMotor;
    public static CANTalon driveSystemRightFrontMotor;
    public static CANTalon driveSystemRightRearMotor;
    public static RobotDrive driveSystemRobotDrive41;
    public static SpeedController liftscissors1;
    public static SpeedController liftscissors2;
    public static RobotDrive liftRobotDrive21;
    public static DigitalInput liftUp;
    public static DigitalInput liftDown;
    public static SpeedController bIMBIMwheels;
    public static SpeedController bIMBIMwheels2;
    public static RobotDrive bIMRobotDrive21;
    public static SpeedController bIMBIMmove;
    public static SpeedController bIMSpeedController2;
    public static RobotDrive bIMRobotDrive22;
    public static DigitalInput bIMbimDown;
    public static DigitalInput bIMbimUp;
    public static SpeedController armArmScrew;
    public static SpeedController armArmExtension;
    public static RobotDrive armRobotDrive21;
    public static DigitalInput armSheniqua;
    public static DigitalInput armJosh;
    public static Encoder armarmEncoder;
    public static Encoder armarmExtentionEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static ADXRS450_Gyro gyro;

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveSystemUltrasonic = new Ultrasonic(6, 7);
        LiveWindow.addSensor("driveSystem", "Ultrasonic ", driveSystemUltrasonic);
        
        driveSystemEncoder1 = new Encoder(8, 9, false, EncodingType.k4X);
        LiveWindow.addSensor("driveSystem", "Encoder 1", driveSystemEncoder1);
        driveSystemEncoder1.setDistancePerPulse(0.02617994);
        driveSystemEncoder1.setPIDSourceType(PIDSourceType.kRate);
        driveSystemLeftFrontMotor = new CANTalon(0);
        LiveWindow.addActuator("driveSystem", "LeftFrontMotor", driveSystemLeftFrontMotor);
        
        driveSystemLeftRearMotor = new CANTalon(5);
        LiveWindow.addActuator("driveSystem", "LeftRearMotor", driveSystemLeftRearMotor);
        
        driveSystemRightFrontMotor = new CANTalon(2);
        LiveWindow.addActuator("driveSystem", "RightFrontMotor", driveSystemRightFrontMotor);
        
        driveSystemRightRearMotor = new CANTalon(3);
        LiveWindow.addActuator("driveSystem", "RightRearMotor", driveSystemRightRearMotor);
        
        driveSystemRobotDrive41 = new RobotDrive(driveSystemLeftFrontMotor, driveSystemLeftRearMotor,
              driveSystemRightFrontMotor, driveSystemRightRearMotor);
        
        driveSystemRobotDrive41.setSafetyEnabled(true);
        driveSystemRobotDrive41.setExpiration(0.1);
        driveSystemRobotDrive41.setSensitivity(0.5);
        driveSystemRobotDrive41.setMaxOutput(1.0);

        liftscissors1 = new Victor(0);
        LiveWindow.addActuator("lift", "scissors1", (Victor) liftscissors1);
        
        liftscissors2 = new Victor(1);
        LiveWindow.addActuator("lift", "scissors2", (Victor) liftscissors2);
        
        liftRobotDrive21 = new RobotDrive(liftscissors1, liftscissors2);
        
        liftRobotDrive21.setSafetyEnabled(true);
        liftRobotDrive21.setExpiration(0.1);
        liftRobotDrive21.setSensitivity(0.5);
        liftRobotDrive21.setMaxOutput(1.0);

        liftUp = new DigitalInput(0);
        LiveWindow.addSensor("lift", "Up", liftUp);
        
        liftDown = new DigitalInput(1);
        LiveWindow.addSensor("lift", "Down", liftDown);
        
        bIMBIMwheels = new Talon(3);
        LiveWindow.addActuator("BIM", "BIMwheels", (Talon) bIMBIMwheels);
        
        bIMBIMwheels2 = new Talon(2);
        LiveWindow.addActuator("BIM", "BIMwheels2", (Talon) bIMBIMwheels2);
        
        bIMRobotDrive21 = new RobotDrive(bIMBIMwheels2, bIMBIMwheels);
        
        bIMRobotDrive21.setSafetyEnabled(true);
        bIMRobotDrive21.setExpiration(0.1);
        bIMRobotDrive21.setSensitivity(0.5);
        bIMRobotDrive21.setMaxOutput(1.0);

        bIMBIMmove = new VictorSP(8);
        LiveWindow.addActuator("BIM", "BIMmove", (VictorSP) bIMBIMmove);
        
        bIMSpeedController2 = new Talon(9);
        LiveWindow.addActuator("BIM", "Speed Controller 2", (Talon) bIMSpeedController2);
        
        bIMRobotDrive22 = new RobotDrive(bIMBIMmove, bIMSpeedController2);
        
        bIMRobotDrive22.setSafetyEnabled(true);
        bIMRobotDrive22.setExpiration(0.1);
        bIMRobotDrive22.setSensitivity(0.5);
        bIMRobotDrive22.setMaxOutput(1.0);

        bIMbimDown = new DigitalInput(4);
        LiveWindow.addSensor("BIM", "bimDown", bIMbimDown);
        
        bIMbimUp = new DigitalInput(5);
        LiveWindow.addSensor("BIM", "bimUp", bIMbimUp);
        
        armArmScrew = new VictorSP(4);
        LiveWindow.addActuator("arm", "ArmScrew", (VictorSP) armArmScrew);
        
        armArmExtension = new VictorSP(5);
        LiveWindow.addActuator("arm", "ArmExtension", (VictorSP) armArmExtension);
        
        armRobotDrive21 = new RobotDrive(armArmScrew, armArmExtension);
        
        armRobotDrive21.setSafetyEnabled(true);
        armRobotDrive21.setExpiration(0.1);
        armRobotDrive21.setSensitivity(0.5);
        armRobotDrive21.setMaxOutput(1.0);

        armSheniqua = new DigitalInput(2);
        LiveWindow.addSensor("arm", "Sheniqua", armSheniqua);
        
        armJosh = new DigitalInput(3);
        LiveWindow.addSensor("arm", "Josh", armJosh);
        
        armarmEncoder = new Encoder(10, 11, true, EncodingType.k4X);
        LiveWindow.addSensor("arm", "armEncoder ", armarmEncoder);
        armarmEncoder.setDistancePerPulse(1.0);
        armarmEncoder.setPIDSourceType(PIDSourceType.kRate);
        armarmExtentionEncoder = new Encoder(12, 13, true, EncodingType.k4X);
        LiveWindow.addSensor("arm", "armExtentionEncoder ", armarmExtentionEncoder);
        armarmExtentionEncoder.setDistancePerPulse(1.0);
        armarmExtentionEncoder.setPIDSourceType(PIDSourceType.kRate);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
    }
}
