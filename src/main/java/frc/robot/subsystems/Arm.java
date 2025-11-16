package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    PWMSparkMax armMotorPwmSparkMax = new PWMSparkMax(Constants.ArmConstants.armMotorPort);
    public Arm () {}
   
    public Command armUp(double Volts){
        return Commands.run(() -> armMotorPwmSparkMax.setVoltage(Volts), this);
    }
    public Command armDown(double Volts){
        return Commands.run(() -> armMotorPwmSparkMax.setVoltage(-Volts), this);
    }
    public Command armStop(){
        return Commands.run(() -> armMotorPwmSparkMax.setVoltage(0), this);
    }

}
