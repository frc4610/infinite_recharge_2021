// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feed extends SubsystemBase {
  private VictorSPX feedupper;
  private VictorSPX feedlower;
  /** Creates a new Feed. */
  public Feed() {
    feedupper = new VictorSPX(6);
    feedlower = new VictorSPX(7);
  }

  public void move(ControlMode mode, double speedU, double speedL) {
    feedupper.set(ControlMode.PercentOutput, speedU);
    feedlower.set(ControlMode.PercentOutput, speedL);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
