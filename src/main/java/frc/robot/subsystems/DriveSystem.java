/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
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
  private Servo leftCam = new Servo(4);
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }

  public void mecanumDrive(double x, double y, double r) {
    // System.out.println(frontLeft.get());

		double a = Math.atan2(y, x);
		double pFL = -(Math.abs(Math.sin(a)) * y) - (Math.abs(Math.cos(a)) * x) + r;
		double pFR = (Math.abs(Math.sin(a)) * y) - (Math.abs(Math.cos(a)) * x) + r;
		double pBL = -(Math.abs(Math.sin(a)) * y) + (Math.abs(Math.cos(a)) * x) + r;
		double pBR = (Math.abs(Math.sin(a)) * y) + (Math.abs(Math.cos(a)) * x) + r;
		frontLeft.set(pFL);
		backLeft.set(pBL);
		frontRight.set(pFR);
		backRight.set(pBR);
}

public void turnCam(double degrees1, double degrees2) {
  leftCam.set(leftCam.getAngle()/180 + degrees1);
}

public void stop() {
  mecanumDrive(0.0D, 0.0D, 0.0D);
}

}
