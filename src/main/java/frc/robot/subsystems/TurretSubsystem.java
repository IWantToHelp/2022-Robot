// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import frc.robot.Constants;

public class TurretSubsystem extends SubsystemBase {
  /** Creates a new TurretSubsystem. */
  private final TalonFX turretMotor = new TalonFX(Constants.turrentMotorID);

  //turretPID variables
  private double turretError;
  private double turretPrevError;
  private double turretP;
  private double turretI;
  private double turretD;
  private double turretOutput;

  public TurretSubsystem() {
    turretError = 0;
    turretPrevError = 0;
    turretP = 0;
    turretI = 0;
    turretD = 0;
    turretOutput = 0;
  }

  public double turretPID(double limelightInput){

    turretError = limelightInput;
    turretP = turretError;
    turretI += turretError;
    turretD = turretError - turretPrevError;
    turretPrevError = turretError;

    turretOutput = Constants.turretkP*turretP + Constants.turretkI*turretI + Constants.turretkD*turretD;

    return turretOutput;
  }

  public void turnTurret(double input){//find out which way the turret turns for positive and negative, needs hardware for testing.

    turretMotor.set(ControlMode.PercentOutput, input);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}