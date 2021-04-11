// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBase extends SubsystemBase {
  private TalonFX driveFrontL;
  private TalonFX driveFrontR;
  private TalonFX driveBackL;
  private TalonFX driveBackR;
  
  /** Creates a new DriveBase. */
  public DriveBase() {
    driveFrontL = new TalonFX(11);
    driveFrontR = new TalonFX(1);
    driveBackL = new TalonFX(2);
    driveBackR = new TalonFX(3);
    driveFrontL.configOpenloopRamp(0.75);
    driveBackR.configOpenloopRamp(0.75);
    driveFrontR.configOpenloopRamp(0.75);
    driveBackL.configOpenloopRamp(0.75);
    driveBackL.follow(driveFrontL);
    driveBackR.follow(driveFrontR);
    driveFrontL.setInverted(true);
    driveBackL.setInverted(true);
  }

  public void move(ControlMode mode, double speedL, double speedR) {
    driveFrontR.set(mode, speedR);
    driveFrontL.set(mode, speedL);
  }

  public double motortemps() {
    return ((driveFrontL.getTemperature() + driveFrontR.getTemperature() + driveBackL.getTemperature()
        + driveBackR.getTemperature()) / 4);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
