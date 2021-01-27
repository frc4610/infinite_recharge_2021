// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBase extends SubsystemBase {
  private VictorSPX driveFrontL;
  private VictorSPX driveFrontR;
  private VictorSPX driveBackL;
  private VictorSPX driveBackR;
  private double peak;

  /** Creates a new DriveBase. */
  public DriveBase() {
    peak = 1;
    driveFrontL = new VictorSPX(0);
    driveFrontR = new VictorSPX(1);
    driveBackL = new VictorSPX(2);
    driveBackR = new VictorSPX(3);
    driveBackL.follow(driveFrontL);
    driveBackR.follow(driveFrontR);
    driveFrontR.setInverted(true);
    driveBackR.setInverted(true);
    RobotContainer.initMotor(driveFrontL, peak);
    RobotContainer.initMotor(driveFrontR, peak);
    RobotContainer.initMotor(driveBackL, peak);
    RobotContainer.initMotor(driveBackR, peak);
  }
    
  public void move(ControlMode mode, double speedL, double speedR) {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
