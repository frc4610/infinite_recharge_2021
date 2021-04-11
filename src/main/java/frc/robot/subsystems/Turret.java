// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */
  private TalonSRX turretmotor;
  private double peak;
  @SuppressWarnings("not used")

  public Turret() {
    peak = 1;
    turretmotor = new TalonSRX(8);
    RobotContainer.initMotor(turretmotor, peak);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void move(ControlMode percentoutput, double d) {
    turretmotor.set(percentoutput, d);
  }

  public void spinturret(double position) {
    turretmotor.set(ControlMode.Position, position);
  }

  public double getTurretEncoderValue() {
    return turretmotor.getSelectedSensorPosition();
    // 4096 pulses/revolution / 43.2 degrees/revolution = 94.81 pulses/degree
  }

  public void resetEncoder() {
    turretmotor.setSelectedSensorPosition(0);
  }
}
