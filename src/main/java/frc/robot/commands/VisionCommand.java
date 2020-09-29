/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class VisionCommand extends Command {
  public VisionCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean targets = Robot.camera.hasTargets();
    System.out.println(targets);

    if(targets) {
      double yaw = Robot.camera.getBestTargetYaw();
      double pitch = Robot.camera.getBestTargetPitch();
      double area = Robot.camera.getBestTargetArea();

      System.out.println("yaw = " + yaw + " pitch = " + pitch + " area = " + area);

      if(true) {
        TimeDrive fDrive = new TimeDrive(100, 10, 10);
        TimeDrive bDrive = new TimeDrive(100, -10, -10);

        if(yaw >= 0) {
          bDrive.end();
          bDrive.close();
          fDrive.execute();
        } else if(yaw < -1) {
          fDrive.end();
          fDrive.close();
          bDrive.execute();
        }
      }
    }
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
