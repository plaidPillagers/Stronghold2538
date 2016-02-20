# Lenny's Notes

##Subsystems:  
1. **BIM** (High priority)  
  * Line 36: Why do we have a drive system here?   
  * Line 38: Can we get a better name for this  
2. **RangeFinder** (Medium priority)  
  * We will hopefully be using Analoug rangfinders  
3. **Arm** (Low priority)   
  * Will this by used?  
  * Line 38: No  
  * Line 39: Stop this, stop this right now  
  * Need to figure out secondary joystick  
  * extendArm(): needs to set a speed in the else case  
  * retractArm(): needs to test out shaft encoders  
4. **DriveSystem** (High priority)
  * What is ultraForwardRange?  
  * Is the reason why the secondary joystick in Arm because you are making an instance of it in driveSystem?   
   (You should probably take any mention of secondaryStick out of DriveSystem and especially arcadeDriveSystem())  
  * You should give the meathod, backwards() a better name.  
  * Take me through autoGyroStraight()  
  * Your autoGyroTurn() meathod will only turn right. I guess you will get where you want to be eventually  
  * *REALLY IMPORTANT* line 127: if your angle >= turnAngle, you never tell it to stop
  * *REALLY IMPORTANT* line 139: if your ultraRange >= goal range, you never tell it to stop  
5. **Lift** (High priority)
  * How many joysticks do you plan to put on this thing?  
  * Looks good

##Commands: 
1.  **Arm** (Low priority)
  * It only extends the arm
2. **ArmExtendUp** (Low priority)
  * This needs to get fixed or deleated 
3. **AutonomousCommand** (High priority)
  * This needs to get built on or deleated
  * Currently being used in autonomousInit()
4. **AutonomousCommandGroup** (High priority)
  * Need to add in autonomousToGoal()
5. **BIM-Eject** (Medium priority)
  * You should maybe add  a Robot.BIM.wheelStop() into the end() method. (Or maybe not?)
6. **BIM-Intake** (Medium priority)
  * It's a thing!
7. **BIM-Stop** (Medium priority)
  * Is also a thing! 

  
  
