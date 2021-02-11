// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */
  private TalonSRX turretmotor;
  private TalonSRX turretmotorback;
  private double peak;

  public Turret() {
    peak = .25;
    turretmotor = new TalonSRX(4);
    turretmotor = turretmotorback;
    turretmotorback.setInverted(true);
  }

  public void move(ControlMode mode, double name) {
    turretmotor.set(mode, name);
    turretmotorback.set(mode, name);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void move(ControlMode percentoutput, boolean torf) {
    turretmotor.set(percentoutput, peak);
  }

  public void moveinv(ControlMode percentoutput, boolean torf) {
    turretmotorback.set(percentoutput, -peak);
  }
}
