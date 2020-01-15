/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSystem extends Subsystem {

  private Spark backRight = new Spark(0);
  private Spark frontRight = new Spark(1);
  private Spark frontLeft = new Spark(2);
  private Spark backLeft = new Spark(3);

  private Talon centerMotor = new Talon(4);
  
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }

  public void mecanumDrive(double x, double y, double r) {

		// double a = Math.atan2(y, x);
		// double pFL = (Math.abs(Math.sin(a)) * y) - (Math.abs(Math.cos(a)) * x) + r;
		// double pFR = (Math.abs(Math.sin(a)) * y) - (Math.abs(Math.cos(a)) * x) + r;
		// double pBL = (Math.abs(Math.sin(a)) * y) + (Math.abs(Math.cos(a)) * x) + r;
		// double pBR = (Math.abs(Math.sin(a)) * y) + (Math.abs(Math.cos(a)) * x) + r;
		// frontLeft.set(pFL);
		// backLeft.set(-pBL);
		// frontRight.set(-pFR);
    // backRight.set(pBR);
    
    frontLeft.set(y - x - r);
    frontRight.set(y + x - r);

    backLeft.set(-y - x - r);
    backRight.set(-y + x - r);
}

public void rocker(double leftPow, double rightPow, double centerPow) {
  frontLeft.set(-leftPow);
  backLeft.set(-leftPow);
  frontRight.set(rightPow);
  backRight.set(rightPow);
  centerMotor.set(centerPow);
}

public void rockerArcade(double xPow, double yPow) {
  frontLeft.set(-yPow + -xPow);
  backLeft.set(-yPow + xPow);
  frontRight.set(yPow + -xPow);
  backRight.set(yPow + xPow);
}

public void mecStop() {
  mecanumDrive(0.0D, 0.0D, 0.0D);
}

public void rocStop() {
  rocker(0.0D, 0.0D, 0.0D);
}

}
