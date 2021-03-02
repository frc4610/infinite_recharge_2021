// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;

public class TurretMove extends CommandBase {
  /** Creates a new TurretMove. */
  private Turret sTurret;
  private double actualangle;
  private double cwmovement;
  private double ccwmovement;

  public TurretMove(Turret turret) {
    // Use addRequirements() here to declare subsystem dependencies.
    sTurret = turret;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    sTurret.resetEncoder();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    actualangle = sTurret.getTurretEncoderValue();
    cwmovement = actualangle + (15 * 94.81);
    ccwmovement = actualangle - (15 * 94.81);
    if(RobotContainer.operatorLeftBumper.get()) {
      sTurret.move(ControlMode.PercentOutput, .1);
      //sTurret.spinturret(cwmovement);
    }
    else if(RobotContainer.operatorRightBumper.get()) {
      sTurret.move(ControlMode.PercentOutput, -.1);
      //sTurret.spinturret(-ccwmovement);
    }
    else {
      sTurret.move(ControlMode.PercentOutput, 0);
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
