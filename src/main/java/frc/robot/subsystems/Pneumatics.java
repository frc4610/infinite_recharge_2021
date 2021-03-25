// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  public DoubleSolenoid cylinder;

  /** Creates a new Pneumatics. */
  public Pneumatics() {
    cylinder = new DoubleSolenoid(1, 0);
    cylinder.set(Value.kForward);
  }

  public void actuate() {
    cylinder.toggle();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
