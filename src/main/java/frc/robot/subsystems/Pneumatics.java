// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  public Compressor compressor;
  public DoubleSolenoid cylinder;
  
  /** Creates a new Pneumatics. */
  public Pneumatics() {
    compressor = new Compressor();
    cylinder = new DoubleSolenoid(0, 1);
  }

  public void forward() {
    cylinder.set(DoubleSolenoid.Value.kForward);
  }

  public void reverse() {
    cylinder.set(DoubleSolenoid.Value.kReverse);
  }

  public void off() {
    cylinder.set(DoubleSolenoid.Value.kOff);
  }

  public void collectair() {
    compressor.start();
    compressor.setClosedLoopControl(true);
  }

  public void stopcollectair() {
    compressor.stop();
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
