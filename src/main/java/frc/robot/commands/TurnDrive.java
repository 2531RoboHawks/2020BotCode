/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnDrive extends CommandGroup {

  DriverStation dStation = DriverStation.getInstance();

  public TurnDrive() {

    if (dStation.getLocation() == 0) {
      addSequential(new TimeDrive(2.8));
      addSequential(new TimeShoot(), 5);
      addSequential(new IntakeAuto(-0.5, 0), 5);
    }

    if (dStation.getLocation() == 1) {
      addSequential(new TimeDrive(2.8));
      addSequential(new TimeShoot(), 5);
      addSequential(new IntakeAuto(-0.5, 0), 5);
    }

    if (dStation.getLocation() == 2) {
      addSequential(new TimeDrive(2.8));
      addSequential(new TimeShoot(), 5);
      addSequential(new IntakeAuto(-0.5, 0), 5);
    }

  }
}
