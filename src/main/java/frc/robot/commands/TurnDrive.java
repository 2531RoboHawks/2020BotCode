/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;

public class TurnDrive extends CommandGroup {
  
  
  public TurnDrive() {
    addSequential(new TimeDrive(10));
    addParallel(new TurnToAngle(RobotMap.gyro.getAngle()+10));
     
  }
}
