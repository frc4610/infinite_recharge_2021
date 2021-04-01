// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.VisionSystem;

public class TurretMove extends CommandBase {
  /** Creates a new TurretMove. */
  private Turret sTurret;
  private VisionSystem visionSystem;
  private double actualangle;
  private double error;

  public TurretMove(Turret turret, VisionSystem vSystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    sTurret = turret;
    visionSystem = vSystem;
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
    visionSystem.visionStoreValues();
    error = visionSystem.getXValue()/50;
    SmartDashboard.putNumber("Turret Error", error);
    if(RobotContainer.driverLeftBumper.get() & actualangle < 17007 & !RobotContainer.driverAButton.get()) {
      sTurret.move(ControlMode.PercentOutput, .35);
    }
    else if(RobotContainer.driverRightBumper.get() & actualangle > 0 & !RobotContainer.driverAButton.get()) {
      sTurret.move(ControlMode.PercentOutput, -.35);
    }
    else if(RobotContainer.driverAButton.get() & Math.abs(error) > 0.05 & actualangle >= 0 & actualangle <= 17007) {
      visionSystem.vLEDon();
      sTurret.move(ControlMode.PercentOutput, -error );
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
