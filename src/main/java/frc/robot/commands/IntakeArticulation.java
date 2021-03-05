// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatics;

public class IntakeArticulation extends CommandBase {
  private Pneumatics pneumatics;
  private Intake intake;
  /** Creates a new IntakeArticulation. */
  public IntakeArticulation(Pneumatics air, Intake intakes) {
    pneumatics = air;
    intake = intakes;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.driverLeftBumper.get()) {
      pneumatics.forward();
    }
    else if(RobotContainer.driverRightBumper.get()) {
      pneumatics.reverse();
    }
    else if(RobotContainer.operatorAButton.get()) {
      intake.intakepc();
    }
    else {
      pneumatics.off();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
