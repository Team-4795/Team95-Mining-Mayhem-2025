// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants;

public class Roller extends SubsystemBase {
  /** Creates a new Roller Subsystem. */
  SparkMax rollerMotor;
  public Roller() {
    rollerMotor = new SparkMax(Constants.RollerConstants.rightMotorPort, SparkLowLevel.MotorType.kBrushless);
  }
  // 0-Ready for intake 1- Intaking 2-Has ball 3-Output

  public void intake()
  {
    rollerMotor.setVoltage(Constants.DriverConstants.rollerVoltage);
  }
  public void outtake(){
    rollerMotor.setVoltage(-Constants.DriverConstants.rollerVoltage);
  }

  public void setRollerVoltage(){
    rollerMotor.setVoltage(0);
  }
  

}
