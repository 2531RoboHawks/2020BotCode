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

public class ShootCommand extends Command {
  private double startTime;

  public ShootCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.shootSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double currentTime = System.currentTimeMillis();

    if (OI.leftJoy.getRawButton(3)) {
      Robot.servoSystem.toDegree(180, 0);

      if (currentTime - startTime > 1000) {
        Robot.shootSystem.shoot(1);
      } else {
        Robot.shootSystem.stopShoot();
      }
    } else {
      Robot.servoSystem.toDegree(0, 180);
      startTime = System.currentTimeMillis();
      Robot.shootSystem.stopShoot();
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
