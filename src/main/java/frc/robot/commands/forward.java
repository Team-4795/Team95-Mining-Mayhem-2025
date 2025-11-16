// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class forward extends Command{
  /** Example static factory for an autonomous command. */
  static DriveTrain driveTrain;
  static Command moveForward;
  static Command turn180;
  static Command slowlyTurn;
  static Command stop;

  public forward(DriveTrain subsystem, double STUPIDPARAMETERBECAUSETHOMASWANTEDIT) {
    addRequirements(subsystem);
    driveTrain = subsystem;

    moveForward = Commands.run(() -> driveTrain.moveDriveTrain(STUPIDPARAMETERBECAUSETHOMASWANTEDIT, STUPIDPARAMETERBECAUSETHOMASWANTEDIT), driveTrain);
    turn180 = Commands.run(() -> driveTrain.moveDriveTrain(STUPIDPARAMETERBECAUSETHOMASWANTEDIT, -STUPIDPARAMETERBECAUSETHOMASWANTEDIT), driveTrain);
    moveForward = Commands.run(() -> driveTrain.moveDriveTrain(STUPIDPARAMETERBECAUSETHOMASWANTEDIT+0.1, STUPIDPARAMETERBECAUSETHOMASWANTEDIT), driveTrain);
    stop = Commands.run(() -> driveTrain.moveDriveTrain(0, 0), driveTrain);


  }

public static Command moveforward() {
  return Commands.sequence(  
  driveTrain.moveDriveTrain(1, 1),
  Commands.waitSeconds(1),
  driveTrain.moveDriveTrain(0, 0));
}
  


}
