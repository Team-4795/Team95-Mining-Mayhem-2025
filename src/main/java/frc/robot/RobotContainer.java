// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.ExampleCommand;
<<<<<<< Updated upstream
import frc.robot.subsystems.Arm;
=======
>>>>>>> Stashed changes
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Roller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain driveTrain = new DriveTrain();
<<<<<<< Updated upstream
  private final Roller roller = new Roller();
  private final Arm arm = new Arm();
  private final AutoCommand autoCommand = new AutoCommand(driveTrain, arm, roller,0.5 , 0.5, 0.5);
=======
>>>>>>> Stashed changes

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  private final CommandXboxController operatorController =
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandXboxController
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is presserd,
    // cancelling on release.

    driveTrain.setDefaultCommand(driveTrain.arcadeDriveCommand(m_driverController.getLeftY(), m_driverController.getLeftX()));
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    operatorController.leftBumper().whileTrue(arm.armUp(Constants.ArmConstants.defaultArmVoltage));
    operatorController.rightBumper().whileTrue(arm.armDown(Constants.ArmConstants.defaultArmVoltage));
    arm.setDefaultCommand(arm.armStop());
    
    driveTrain.setDefaultCommand(
      Commands.run(
        () -> driveTrain.arcadeDrive(m_driverController.getLeftY(), m_driverController.getLeftX()), 
        driveTrain));

    roller.setDefaultCommand(roller.setRollerVoltage(0));

    m_driverController.leftTrigger().whileTrue(roller.intake(1));

    m_driverController.rightTrigger().whileTrue(roller.outtake(1));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return autoCommand.autoSequence(Constants.autoConstants.autoPlan);
  }
}
