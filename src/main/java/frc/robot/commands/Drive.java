/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class Drive extends Command {
  private double deadzone;

  public Drive() {
    // Use requires() here to declare subsystem dependencies
    this.deadzone = 0.1D;
    requires(Robot.m_subsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {


    double py1 = OI.leftJoy.getRawAxis(0);
    double py2 = OI.leftJoy.getRawAxis(1);
    double py3 = OI.rightJoy.getRawAxis(0);



    if (Math.abs(py1) < this.deadzone) 
    {
      py1 = 0.0D;
    }

    if (Math.abs(py2) < this.deadzone) 
    {
      py2 = 0.0D;
    }

    if (py1 == 0.0D && py2 == 0.0D) 
    {
      Robot.m_subsystem.stop();
    } else {
      Robot.m_subsystem.mecanumDrive(py1, py2, py3);
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
    Robot.m_subsystem.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
