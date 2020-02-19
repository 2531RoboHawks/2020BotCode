/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.OI;
import frc.robot.Robot;

public class Gimble extends Command {
  public Gimble() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.servoSystem);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

  
    // boolean rightStickLeftButton = OI.rightJoy.getRawButtonPressed(4);
    // boolean rightStickRightButton = OI.rightJoy.getRawButtonPressed(5);
    // boolean rightStickTopButton = OI.rightJoy.getRawButtonPressed(6);
    // boolean rightStickBottomButton = OI.rightJoy.getRawButtonPressed(7);


    // Robot.servoSystem.toDegree(leftStickLeftButton, leftStickRightButton);


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
