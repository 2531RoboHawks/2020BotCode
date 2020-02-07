/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TimeDrive extends Command {
  private double time;
  private double startTime;
  private boolean end = false;
  public TimeDrive(double tTime) {
    requires(Robot.m_subsystem);
    this.time = tTime*1000;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startTime = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double currentTime = System.currentTimeMillis();

    if(currentTime - startTime < time) {
        Robot.m_subsystem.coastArcade(0, -0.3);
    } else {
      Robot.m_subsystem.rocStop();
      end = true;
    }
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return end;
  }

  // Called once after isFinished returns true
  @Override
  public void end() {
    Robot.m_subsystem.rocStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
