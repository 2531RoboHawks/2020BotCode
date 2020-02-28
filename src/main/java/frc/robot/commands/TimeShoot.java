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

public class TimeShoot extends Command {
  boolean press = false;
  double time;
  double currentTime = System.currentTimeMillis();

  public TimeShoot(double time) {
    this.time = time * 1000;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    currentTime = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  boolean gone = false;
  boolean finished = false;

  @Override
  protected void execute() {
    if (Math.abs(System.currentTimeMillis() - currentTime) < time) {
      Robot.shootSystem.shoot(0.8);
    } else {
      Robot.intakeSystem.intake(-0.5, 0);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.shootSystem.stopShoot();
    finished = true;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
