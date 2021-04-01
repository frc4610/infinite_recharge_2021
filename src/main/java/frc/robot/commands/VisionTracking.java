// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.VisionSystem;

public class VisionTracking extends CommandBase {
  private VisionSystem vSystem;
  /** Creates a new VisionTracking. */
  public VisionTracking(VisionSystem visionSystem) {
    vSystem = visionSystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    vSystem.vLEDoff();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.driverAButton.get()) {
      vSystem.vLEDon();
    }
    else {
      vSystem.vLEDoff();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    vSystem.vLEDoff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
