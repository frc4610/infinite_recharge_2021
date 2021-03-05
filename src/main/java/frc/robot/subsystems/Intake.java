// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private CANSparkMax IntakeMotor;
  /** Creates a new Intake. */
  public Intake() {
    IntakeMotor = new CANSparkMax(5, MotorType.kBrushless);
  }

  public void intakepc() {
    IntakeMotor.set(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
