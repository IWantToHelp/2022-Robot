// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.BallCounter;
import frc.robot.subsystems.Indexer;
import frc.robot.RobotContainer;

public class IndexShoot extends CommandBase {
  /** Creates a new IndexShoot. */
  private final Indexer index;
  private int ballCount;
  public IndexShoot(Indexer index) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.index = index;
    addRequirements(index);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ballCount = RobotContainer.ballCounter.getBalls();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(ballCount == RobotContainer.ballCounter.getBalls()){
      index.runLowerIndexer(Constants.indexMotorSpeedBottom);
      index.runUpperIndexer(Constants.indexMotorSpeedTop);
    }
    //ballCount = RobotContainer.ballCounter.getBalls();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    index.stopIndexer();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(ballCount != RobotContainer.ballCounter.getBalls()){
      return true;
    }else{
      return false;
    }
  }
}
