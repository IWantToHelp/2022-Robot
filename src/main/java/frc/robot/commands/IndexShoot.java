// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.BallCounterSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.RobotContainer;

public class IndexShoot extends CommandBase {
  /** Creates a new IndexShoot. */
  private final IndexerSubsystem index;
  private int counter;
  public IndexShoot(IndexerSubsystem index) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.index = index;
    addRequirements(index);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    counter = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      index.runLowerIndexer(Constants.indexMotorSpeedBottom);
      index.runUpperIndexer(Constants.indexMotorSpeedTop);
      counter++;
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    index.stopIndexer();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(counter>10){
      return true;
    }
    else{
      return false;
    }
  }
}
