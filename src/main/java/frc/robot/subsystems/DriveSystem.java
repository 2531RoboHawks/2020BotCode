/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSystem extends Subsystem {

  private Spark left0 = new Spark(0);
  private Spark left1 = new Spark(1);
  private Spark right0 = new Spark(2);
  private Spark right1 = new Spark(3);
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }

public void coast(double leftPow, double rightPow) {
  left0.set(-leftPow);
  left1.set(-leftPow);
  right0.set(rightPow);
  right1.set(rightPow);
}

public void coastArcade(double xPow, double yPow) {
  left0.set(-yPow + -xPow);
  left1.set(-yPow + -xPow);
  right0.set(yPow + xPow);
  right1.set(yPow + xPow);
}

public void rocStop() {
  coast(0.0D, 0.0D);
}

}
