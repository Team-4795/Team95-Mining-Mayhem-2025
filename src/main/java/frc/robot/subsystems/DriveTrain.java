package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.XboxController;

import java.lang.Object;

import org.ejml.dense.row.linsol.LinearSolver_FDRB_to_FDRM;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    PWMTalonSRX pwmMotorControllerLeftMotor = new PWMTalonSRX(Constants.OperatorConstants.rightMotorPort);
    PWMTalonSRX pwmMotorControllerRightMotor = new PWMTalonSRX(Constants.OperatorConstants.leftMotorPort);
    DifferentialDrive differentialDrive = new DifferentialDrive(pwmMotorControllerLeftMotor,pwmMotorControllerRightMotor);

    public DriveTrain() {}

    @Override
    public void periodic()
    {
        differentialDrive.arcadeDriveIK(xboxController.getLeftY(), xbox_Controller.getLeftX(), false);
    }
}
