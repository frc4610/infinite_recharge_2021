// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBase extends SubsystemBase {
  private TalonFX driveFrontL;
  private TalonFX driveFrontR;
  private TalonFX driveBackL;
  private TalonFX driveBackR;
  private double peak;

  /** Creates a new DriveBase. */
  public DriveBase() {
    peak = 1; // What is "Peak"?
    driveFrontL = new TalonFX(0);
    driveFrontR = new TalonFX(1);
    driveBackL = new TalonFX(2);
    driveBackR = new TalonFX(3);
    driveBackL.follow(driveFrontL);
    driveBackR.follow(driveFrontR);
    driveFrontL.setInverted(true);
    driveBackL.setInverted(true);
    RobotContainer.initMotor(driveFrontL, peak);
    RobotContainer.initMotor(driveFrontR, peak);
    RobotContainer.initMotor(driveBackL, peak);
    RobotContainer.initMotor(driveBackR, peak);
  }
    
  public void move(ControlMode mode, double speedL, double speedR) {
    driveFrontR.set(mode, speedL);
    driveFrontL.set(mode, speedR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
