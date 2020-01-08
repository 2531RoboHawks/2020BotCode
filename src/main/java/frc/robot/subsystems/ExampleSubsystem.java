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
public class ExampleSubsystem extends Subsystem {
  private Spark backRight = new Spark(0);
  private Spark frontRight = new Spark(1);
  private Spark frontLeft = new Spark(2);
  private Spark backLeft = new Spark(3);
  private Servo leftCam = new Servo(4);
  private Servo rightCam = new Servo(6);
  private DigitalOutput light = new DigitalOutput(0);

  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }

  public void mecanumDrive(double stickOne, double stickTwo, double p1, double p2) {
    // System.out.println(frontLeft.get());

    frontLeft.set(stickTwo - stickOne -p1 + p2 );
    frontRight.set(stickTwo + stickOne -p1 + p2);

    backLeft.set(-stickTwo - stickOne -p1 + p2);
    backRight.set(-stickTwo + stickOne -p1 + p2);
    

    
}

public void turnCam(double degrees1, double degrees2) {
  leftCam.set(leftCam.getAngle()/180 + degrees1);
  rightCam.set(rightCam.getAngle()/180 + degrees2);
  light.set(true);
  System.out.println(leftCam.getAngle() + degrees1 + " " + rightCam.getAngle() + degrees2);
}

public void stop() {
  mecanumDrive(0.0D, 0.0D, 0.0D, 0.0D);
}

}
