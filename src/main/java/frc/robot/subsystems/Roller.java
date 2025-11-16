// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;

public class Roller extends SubsystemBase {
  /** Creates a new Roller Subsystem. */
  SparkMax rollerMotor;
  public Roller() {
    rollerMotor = new SparkMax(Constants.RollerConstants.rollerID, SparkLowLevel.MotorType.kBrushless);
  }
  // 0-Ready for intake 1- Intaking 2-Has ball 3-Output

  public Command intake(double modifier)
  {
    return Commands.run(() -> rollerMotor.setVoltage(Constants.DriverConstants.rollerVoltage*modifier), this);
  }
  public Command outtake(double modifier){
    return Commands.run(() -> rollerMotor.setVoltage(-Constants.DriverConstants.rollerVoltage*modifier), this);
  }

  public Command setRollerVoltage(double voltage){
    return Commands.run(() -> rollerMotor.setVoltage(voltage), this);
  }
  

}
