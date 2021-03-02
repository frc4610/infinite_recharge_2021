// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class encoder extends SubsystemBase {
  /** Creates a new encoder. */
  private Encoder encoderturret;

  public encoder() {
    encoderturret = new Encoder(1, 2, false);
    encoderturret.setDistancePerPulse(43.2);
    encoderturret.setSamplesToAverage(10);
    /*8192 counts per revolution
    2048 pulses per revolution (1 pulse = 1 cycle)
    43.2 degrees per revolution (18 teeth, driving/ 150 teeth, driven)
    (18/150 = 0.12) * 360 degrees = 43.2 degrees*/ 
  }

  public double getDistance() {
    return encoderturret.getDistance();
  }
  
  public void resetEncoder() {
    encoderturret.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
