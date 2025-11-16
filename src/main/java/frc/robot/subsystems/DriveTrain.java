package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    PWMTalonSRX pwmMotorControllerLeftMotor = new PWMTalonSRX(Constants.DriveTrainConstants.rightMotorPort);
    PWMTalonSRX pwmMotorControllerRightMotor = new PWMTalonSRX(Constants.DriveTrainConstants.leftMotorPort);
    DifferentialDrive differentialDrive = new DifferentialDrive(pwmMotorControllerLeftMotor,pwmMotorControllerRightMotor);

    public DriveTrain() {}

    public void arcadeDrive(double xRotation,double zRotation){
        differentialDrive.arcadeDrive(xRotation, zRotation, false);
    }

    public void moveDriveTrain(double leftSpeed,double rightSpeed){
        differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }

    public Command powerDriveTrain(double Speed1,double Speed2){
        return Commands.run(() -> this.moveDriveTrain(Speed1, Speed2), this);
    }
}
