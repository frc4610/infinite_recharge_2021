// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  private Compressor compressor;
  private DoubleSolenoid LIntake;
  private DoubleSolenoid RIntake;
  
  /** Creates a new Pneumatics. */
  public Pneumatics() {
    compressor = new Compressor();
    LIntake = new DoubleSolenoid(1, 0, 1);
    // RIntake = new DoubleSolenoid(2, 1, 2);
  }

  public void forward() {
    LIntake.set(DoubleSolenoid.Value.kForward);
    // RIntake.set(DoubleSolenoid.Value.kForward);
  }

  public void reverse() {
    LIntake.set(DoubleSolenoid.Value.kReverse);
    // RIntake.set(DoubleSolenoid.Value.kReverse);
  }

  public void off() {
    LIntake.set(DoubleSolenoid.Value.kOff);
    // RIntake.set(DoubleSolenoid.Value.kOff);
  }

  public void collectair() {
    compressor.setClosedLoopControl(true);
  }

  public void stopcollectair() {
    compressor.setClosedLoopControl(false);
  }

  public boolean pressureSwitch() {
    return compressor.getPressureSwitchValue();
  }

  public boolean compressorenabled() {
    return compressor.enabled();
  }

  public double compressorcurrent() {
    return compressor.getCompressorCurrent();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
