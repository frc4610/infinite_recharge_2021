// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveBase;

public class Drive extends CommandBase {
  private DriveBase tDriveBase;
  /** Creates a new Drive. */
  public Drive(DriveBase drivebase) {
    tDriveBase = drivebase;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double joyValueL = RobotContainer.driver.getRawAxis(1);
    double joyValueR = RobotContainer.driver.getRawAxis(5);
    if(RobotContainer.driver.getRawAxis(2) > 0.1) {
      tDriveBase.move(ControlMode.PercentOutput, -joyValueL/4, -joyValueR/4);
    }
    else {
      tDriveBase.move(ControlMode.PercentOutput, -joyValueL/2, -joyValueR/2);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    tDriveBase.move(ControlMode.PercentOutput, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
