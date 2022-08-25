// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.subsystems.BallCounter;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private Command m_testCommand;
  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    m_robotContainer.navX.calibrate();
    m_robotContainer.driveTrain.resetEncoders();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.  
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    //print pixy tracking information
<<<<<<< HEAD
    SmartDashboard.putNumber("Angle From Pixy: ", m_robotContainer.pixy2.getBlockXangle(0));//Just testing code for pixy angle
    SmartDashboard.putNumber("Pixy Block0 X-coor: ", m_robotContainer.pixy2.getBlockXcoordinates(0));
    SmartDashboard.putNumber("Pixy Block0 Y-coor: ", m_robotContainer.pixy2.getBlockYcoordinates(0));
    SmartDashboard.putNumber("Block Signature: ", m_robotContainer.pixy2.getBlockSignature(0));
    SmartDashboard.putNumber("Current Cargo Loaded", BallCounter.getBalls());
    }
=======
    SmartDashboard.putNumber("NavX-Yaw: ", m_robotContainer.navX.getYaw());
    SmartDashboard.putNumber("NavX-Roll: ", m_robotContainer.navX.getRoll());
    SmartDashboard.putNumber("NavX-Pitch: ", m_robotContainer.navX.getPitch());
    SmartDashboard.putNumber("NavX-Angle: ", m_robotContainer.navX.getAngle());
    SmartDashboard.putNumber("NavX-Yaw: ", m_robotContainer.navX.getYaw());
    SmartDashboard.putNumber("NavX-RawGyroY: ", m_robotContainer.navX.getRawGyroY());
    SmartDashboard.putNumber("Encoder Pos: ", m_robotContainer.driveTrain.getEncoderPosition());
    SmartDashboard.putNumber("Drive Error:", m_robotContainer.driveTrain.getDriveError());

    //SmartDashboard.putNumber("NavX-2D-Rotation: ", m_robotContainer.navX.getRotation2d());

    SmartDashboard.putNumber("Z-NavX displacement: ", m_robotContainer.navX.getDisplacementZ());
    SmartDashboard.putNumber("X-NavX displacement: ", m_robotContainer.navX.getDisplacementX());
    SmartDashboard.putNumber("Y-NavX displacement: ", m_robotContainer.navX.getDisplacementY());
  }
>>>>>>> 021e87b7e1414b5b45e22940761bb41568766b62

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    System.out.println("Teleop has started!");
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //print limeLight tracking information
    SmartDashboard.putNumber("Vertical Angle: ", m_robotContainer.limeLight.getV_angle());
    SmartDashboard.putNumber("Horizontal Angle: ", m_robotContainer.limeLight.getH_angle());
    SmartDashboard.putNumber("Z-direction Distance: ", m_robotContainer.limeLight.getZdistance());
    SmartDashboard.putNumber("X-direction Distnace", m_robotContainer.limeLight.getXdistance());
    SmartDashboard.putNumber("NavX-Yaw: ", m_robotContainer.navX.getYaw());
    SmartDashboard.putNumber("NavX-Roll: ", m_robotContainer.navX.getRoll());
    SmartDashboard.putNumber("NavX-Pitch: ", m_robotContainer.navX.getPitch());
    
    SmartDashboard.putNumber("Encoder Pos: ", m_robotContainer.driveTrain.getEncoderPosition());

    SmartDashboard.putNumber("Turret output", m_robotContainer.turret.getTurretPIDOutput());

    // SmartDashboard.putNumber("total balls", m_robotContainer.ballCounter.getBalls());
    SmartDashboard.putNumber("Turret Angle: ", m_robotContainer.turret.getTurretAngle());
  }

  @Override
  public void testInit() {
    m_testCommand = m_robotContainer.getTestCommand();
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
    if (m_testCommand != null) {
      m_testCommand.schedule();
    }
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    SmartDashboard.putNumber("NavX-Yaw: ", m_robotContainer.navX.getYaw());
    SmartDashboard.putNumber("NavX-Roll: ", m_robotContainer.navX.getRoll());
    SmartDashboard.putNumber("NavX-Pitch: ", m_robotContainer.navX.getPitch());
    SmartDashboard.putNumber("NavX-Angle: ", m_robotContainer.navX.getAngle());
    SmartDashboard.putNumber("NavX-Yaw: ", m_robotContainer.navX.getYaw());
    SmartDashboard.putNumber("NavX-RawGyroY: ", m_robotContainer.navX.getRawGyroY());
    SmartDashboard.putNumber("Encoder Pos: ", m_robotContainer.driveTrain.getEncoderPosition());
    SmartDashboard.putNumber("Drive Error:", m_robotContainer.driveTrain.getDriveError());

    SmartDashboard.putNumber("Z-NavX displacement: ", m_robotContainer.navX.getDisplacementZ());
    SmartDashboard.putNumber("X-NavX displacement: ", m_robotContainer.navX.getDisplacementX());
    SmartDashboard.putNumber("Y-NavX displacement: ", m_robotContainer.navX.getDisplacementY());
  }
}
