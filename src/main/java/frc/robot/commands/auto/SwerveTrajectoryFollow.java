//Created by Spectrum3847
package frc.robot.commands.auto;

import java.util.function.Supplier;

import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.commands.PPSwerveControllerCommand;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import frc.robot.Robot;
import frc.robot.constants.SwerveConstants;
import frc.robot.subsystems.Swerve.Swerve;

/** This class is just a wrapper for SwerveControllerCommand to make it easier to call for our swerve drive.
 *  Units in Meters
 */
public class SwerveTrajectoryFollow extends PPSwerveControllerCommand {
  static Swerve swerve = Robot.swerve;
  PathPlannerTrajectory m_trajectory;
    
  /** Creates a new SwerveTrajectoryFollow. 
    * @param trajectory The trajectory to follow.
    * @param desiredRotation The angle that the drivetrain should be facing at the end. This is sampled at each
    *     time step.
  */
  public SwerveTrajectoryFollow(PathPlannerTrajectory trajectory, Supplier<Rotation2d> desiredRotation) {
    super(trajectory, swerve::getPose, SwerveConstants.swerveKinematics, 
        swerve.xController, swerve.yController, swerve.thetaController,  
        swerve::setModuleStates, swerve);

    /*edu.wpi.first.wpilibj2.command.SwerveControllerCommand.SwerveControllerCommand(
      Trajectory trajectory, 
      Supplier<Pose2d> pose, 
      SwerveDriveKinematics kinematics, 
      PIDController xController, 
      PIDController yController, 
      ProfiledPIDController thetaController, 
      Supplier<Rotation2d> desiredRotation, 
      Consumer<SwerveModuleState[]> outputModuleStates, 
      Subsystem... requirements)*/
    //Example: https://github.com/Team364/BaseFalconSwerve/blob/338c0278cb63714a617f1601a6b9648c64ee78d1/src/main/java/frc/robot/autos/exampleAuto.java
  
    m_trajectory = trajectory;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    super.initialize();
    swerve.resetOdometry(m_trajectory.getInitialPose());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    super.execute();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return super.isFinished();
  }
}
