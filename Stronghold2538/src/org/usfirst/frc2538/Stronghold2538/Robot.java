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
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2538.Stronghold2538.commands.*;
import org.usfirst.frc2538.Stronghold2538.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    //int session;
    //Image frame;
    
    CameraServer server;

    
    
    

    public static OI oi;
    public static Preferences prefs;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static driveSystem driveSystem;
    public static lift lift;
    public static BIM bIM;
    public static arm arm;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public Robot() {
        server = CameraServer.getInstance();
        server.setQuality(45);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");
    }
    


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
    prefs = Preferences.getInstance();
  //Ultrasonic ultra = RobotMap.driveSystemUltrasonic;
    RobotMap.gyro.reset();
    RobotMap.driveSystemEncoder1.reset();
   // ultra.setAutomaticMode(true); // turns on automatic mode
    //frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

    // the camera name (ex "cam0") can be found through the roborio web interface
   // session = NIVision.IMAQdxOpenCamera("cam0",
            //NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    //NIVision.IMAQdxConfigureGrab(session);
    
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveSystem = new driveSystem();
        lift = new lift();
        bIM = new BIM();
        arm = new arm();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new AutonomousCommandGroup();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	//NIVision.IMAQdxStopAcquisition(session);
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        RobotMap.driveSystemEncoder1.reset();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        //NIVision.IMAQdxStartAcquisition(session);
        RobotMap.driveSystemEncoder1.reset();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //NIVision.IMAQdxGrab(session, frame, 1);
        
        //CameraServer.getInstance().setImage(frame);
        //ADXRS450_Gyro gyro = RobotMap.gyro;
        //SmartDashboard.putDouble("angle", gyro.getAngle());
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
