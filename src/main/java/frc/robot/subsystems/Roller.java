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
  /** Creates a new ExampleSubsystem. */
  public Roller() {}
  // 0-Read for intake 1- Intaking 2-Has ball 3-Output
  private int rollerState = 0;
  SparkMax rollerMotor = new SparkMax(Constants.OperatorConstants.rightMotorPort, SparkLowLevel.MotorType.kBrushless);

  public void changeState()
  {
    rollerState += 1;
    if (rollerState == 4){
      rollerState = 0;
    }
  }

  public void setRollerVoltage(){
    if (rollerState == 0 || rollerState == 2){
      rollerMotor.setVoltage(rollerState);
    }
    else if (rollerState == 1){
      rollerMotor.setVoltage(12);
    }
    else{
      rollerMotor.setVoltage(-12);
    }
   
  }

}
