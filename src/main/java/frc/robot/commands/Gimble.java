/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class Gimble extends Command {
  public Gimble() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_subsystem.turnCam(0,0);
  }

  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    final boolean leftStickLeftButton = OI.leftJoy.getRawButton(8);
    final boolean leftStickRightButton = OI.leftJoy.getRawButton(9);
    final boolean rightStickLeftButton = OI.leftJoy.getRawButton(3);
    final boolean rightStickRightButton = OI.leftJoy.getRawButton(2);
    double leftCamera = 0;
    double rightCamera = 0;

    if(leftStickLeftButton && leftCamera >= 0 && leftCamera <= 180) {
      leftCamera = -0.01;
    }
    
    if(leftStickRightButton && leftCamera >= 0 && leftCamera <= 180) {
      leftCamera = 0.01;
    }

    if(rightStickLeftButton && rightCamera >= 0 && rightCamera <= 180) {
      rightCamera = -0.01;
    }

    if(rightStickRightButton && rightCamera >= 0 && rightCamera <= 180) {
      rightCamera = 0.01;
    }

    Robot.m_subsystem.turnCam(leftCamera, rightCamera);
    System.out.println(leftCamera + " + " + rightCamera);
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
