// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatics;

public class IntakeArticulation extends CommandBase {
  private Intake intake;
  private Pneumatics pneumatics;
  /** Creates a new IntakeArticulation. */
  public IntakeArticulation(Pneumatics p, Intake intakes) {
    intake = intakes;
    pneumatics = p;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.driver.getRawAxis(3) > 0) {
      intake.intakepc(-.5);
    }
    else if(RobotContainer.driverLeftBumper.get()) { 
      pneumatics.forward();
    }
    else if(RobotContainer.driverRightBumper.get()) {
      pneumatics.reverse();
    }
    else {
      intake.intakepc(0);
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
