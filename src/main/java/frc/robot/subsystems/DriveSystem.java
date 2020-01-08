package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
   
    //set up motors
    private WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(1);
    private WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(2);
    private WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(3);
    private WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(4);
    
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
}