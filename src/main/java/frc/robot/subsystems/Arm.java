package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    PWMSparkMax armMotorPwmSparkMax = new PWMSparkMax(Constants.OperatorConstants.armMotorPort);
    public Arm () {}
   
    public void armUp(){
        armMotorPwmSparkMax.setVoltage(0.5);
    }
    public void armDown(){
        armMotorPwmSparkMax.setVoltage(-0.5);
    }
    public void armStop(){
        armMotorPwmSparkMax.setVoltage(0);
    }

}
