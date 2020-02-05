/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ControlPanel extends Command {

  public ControlPanel() {
    requires(Robot.canSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean powerButton = OI.leftJoy.getRawButton(3);

    if(powerButton) 
    {
      Robot.canSystem.spinControlPanel();
    } else {
      Robot.canSystem.stopControlPanel();
    }

    double red = (Math.round(RobotMap.m_colorSensor.getColor().red * 10.0))/10.0;
    double green = (Math.round(RobotMap.m_colorSensor.getColor().green * 10.0))/10.0;
    double blue = (Math.round(RobotMap.m_colorSensor.getColor().blue * 10.0))/10.0;
    
    String gameData;
gameData = DriverStation.getInstance().getGameSpecificMessage();
if(gameData.length() > 0)
{
  switch (gameData.charAt(0))
  {
    case 'R' :
      //Blue
      if(red == 0.2 && green == 0.4 && blue == 0.4) {
        Robot.canSystem.stopControlPanel();
      } else {
        Robot.canSystem.spinControlPanel();
      }

      break;
    case 'Y' :
      //Green
      if(red == 0.2 && green == 0.6 && blue == 0.2) {
        Robot.canSystem.stopControlPanel();
      } else {
        Robot.canSystem.spinControlPanel();
      }

      break;
    case 'B' :
      //Red
      if(red == 0.5 && green == 0.4 && blue == 0.1) {
        Robot.canSystem.stopControlPanel();
      } else {
        Robot.canSystem.spinControlPanel();
      }

      break;
    case 'G' :
      //Yellow
      if(red == 0.3 && green == 0.6 && blue == 0.1) {
        Robot.canSystem.stopControlPanel();
      } else {
        Robot.canSystem.spinControlPanel();
      }

      break;
    default :
      System.out.println("Invalid");
      break;
  }
}

    // System.out.println(red + " " + green + " " + blue);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end() {
    Robot.canSystem.stopControlPanel();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
