// copy right (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Roller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class AutoCommand extends Command{
  /** Example static factory for an autonomous command. */
  DriveTrain driveTrain;
  Arm arm;
  Roller roller;

  static Command moveArm;

  double driveTrainSpeed = 0;
  double armSpeed = 0;
  double rollerSpeed = 0;

  public AutoCommand(DriveTrain drivetrain, Arm arm,Roller roller, double Speed,double armSpeed,double rollerSpeed) {
    addRequirements(drivetrain);
    addRequirements(arm);
    addRequirements(roller);

    this.driveTrain = drivetrain;
    this.driveTrainSpeed = Speed;
    this.armSpeed = armSpeed;
    this.rollerSpeed = rollerSpeed;
    this.arm = arm;
    this.roller = roller;
  }

  public Command autoSequence(int driveTrainPlan) {
    if (driveTrainPlan == 1){
      // Auto Plan 1
      //Commands.sequence(command1,
      //command2,
      //command3...)

      return Commands.sequence(
        
        this.arm.armUp(this.armSpeed),
        Commands.waitSeconds(2),
        this.arm.armStop(),
        Commands.waitSeconds(3),
        this.arm.armDown(this.armSpeed),
        this.driveTrain.powerDriveTrain(-this.driveTrainSpeed, -this.driveTrainSpeed),
        Commands.waitSeconds(2),
        this.driveTrain.powerDriveTrain(this.driveTrainSpeed, this.driveTrainSpeed),
        Commands.waitSeconds(0.3),
        this.arm.armStop(),
        //Moves Backward
        Commands.waitSeconds(1 /*Distance To ball y*/ / Constants.autoConstants.distancePerSecond-2),
        //Turns 90 degress
        this.driveTrain.powerDriveTrain(this.driveTrainSpeed, this.driveTrainSpeed),
        Commands.waitSeconds(0.3),
        this.driveTrain.powerDriveTrain(this.driveTrainSpeed, -this.driveTrainSpeed),
        Commands.waitSeconds(90/Constants.autoConstants.degreesPerSecond),
        this.driveTrain.powerDriveTrain(-this.driveTrainSpeed, this.driveTrainSpeed),
        Commands.waitSeconds(0.3),
        //Moving to mid
        this.roller.intake(1),
        this.driveTrain.powerDriveTrain(this.driveTrainSpeed, this.driveTrainSpeed),
        Commands.waitSeconds(1 /*Distance To ball x*// Constants.autoConstants.distancePerSecond),
        this.driveTrain.powerDriveTrain(-this.driveTrainSpeed, -this.driveTrainSpeed),
        Commands.waitSeconds(0.3),
        this.roller.setRollerVoltage(0),
        this.driveTrain.powerDriveTrain(-this.driveTrainSpeed, -this.driveTrainSpeed),
        Commands.waitSeconds(1 /*Distance To ball x*// Constants.autoConstants.distancePerSecond),
        this.driveTrain.powerDriveTrain(this.driveTrainSpeed, this.driveTrainSpeed),
        Commands.waitSeconds(0.3),
        this.driveTrain.powerDriveTrain(this.driveTrainSpeed, -this.driveTrainSpeed),
        Commands.waitSeconds(90/Constants.autoConstants.degreesPerSecond),
        this.driveTrain.powerDriveTrain(-this.driveTrainSpeed, this.driveTrainSpeed),
        Commands.waitSeconds(0.3),

        this.roller.outtake(0.2),
        Commands.waitSeconds(0.3),
        this.driveTrain.powerDriveTrain(-this.driveTrainSpeed, this.driveTrainSpeed),
        this.roller.setRollerVoltage(0),
        Commands.waitSeconds(90/Constants.autoConstants.degreesPerSecond),
        this.driveTrain.powerDriveTrain(this.driveTrainSpeed, -this.driveTrainSpeed),
        Commands.waitSeconds(0.3),

        this.driveTrain.powerDriveTrain(this.driveTrainSpeed, this.driveTrainSpeed),
        Commands.waitSeconds(2),
        this.driveTrain.powerDriveTrain(0, 0)
      );
    }
    else if (driveTrainPlan == 2){
      return Commands.sequence(
        this.arm.armUp(this.armSpeed),
        Commands.waitSeconds(2),
        this.arm.armStop(),
        Commands.waitSeconds(3),
        this.arm.armDown(this.armSpeed),
        this.driveTrain.powerDriveTrain(-this.driveTrainSpeed, -this.driveTrainSpeed),
        Commands.waitSeconds(2),
        this.arm.armStop(),
        //Moves Backward
        Commands.waitSeconds(1 /*Distance To ball y*/ / Constants.autoConstants.distancePerSecond),
        //Turns 90 degress
        this.driveTrain.powerDriveTrain(this.driveTrainSpeed, -this.driveTrainSpeed),
        Commands.waitSeconds(90/Constants.autoConstants.degreesPerSecond),
        //Moving to mid
        this.driveTrain.powerDriveTrain(this.driveTrainSpeed, this.driveTrainSpeed),
        Commands.waitSeconds(1 /*Distance To ball x*// Constants.autoConstants.distancePerSecond),
        this.driveTrain.powerDriveTrain(0, 0)
      );
    }
    /*else{
      return Commands.sequence(
        this.arm.armUp(this.armSpeed),
        Commands.waitSeconds(2),
        this.arm.armDown(this.armSpeed),
        Commands.waitSeconds(2)
      );
    }
    */
  }
    
  


}
