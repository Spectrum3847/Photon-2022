package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ArcadeDrive;
import frc.robot.constants.Constants;

public class Drive extends SubsystemBase{
    public WPI_TalonSRX leftLeaderMotor;
    public WPI_TalonSRX rightLeaderMotor;
    public WPI_VictorSPX leftMotor;
    public WPI_VictorSPX rightMotor;    
    public DifferentialDrive drivetrain;

    public Drive(){
        leftLeaderMotor = new WPI_TalonSRX(Constants.CanIDs.driveLeftLeader);
        rightLeaderMotor = new WPI_TalonSRX(Constants.CanIDs.driveRightLeader);
        leftMotor = new WPI_VictorSPX(Constants.CanIDs.driveLeft);
        rightMotor = new WPI_VictorSPX(Constants.CanIDs.driveRight);

        leftLeaderMotor.configFactoryDefault();
        rightLeaderMotor.configFactoryDefault();
        leftMotor.configFactoryDefault();
        rightMotor.configFactoryDefault();

        //rightLeaderMotor.setInverted(true);

        MotorControllerGroup m_left = new MotorControllerGroup(leftLeaderMotor, leftMotor);
        MotorControllerGroup m_right = new MotorControllerGroup(rightLeaderMotor, rightMotor);

        drivetrain = new DifferentialDrive(m_left, m_right);

        setDefaultCommand(new ArcadeDrive());

    }

    public void arcadeDrive(double xSpeed, double zRotation){
        zRotation = zRotation * 0.75;
        drivetrain.arcadeDrive(xSpeed, zRotation);
    }
    
}
