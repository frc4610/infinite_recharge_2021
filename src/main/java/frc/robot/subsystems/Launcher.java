// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Launcher extends SubsystemBase {
  public TalonFX upperFx;
  public TalonFX lowerFx;
  

  /** Creates a new Launcher. */
  public Launcher() 
  {
    upperFx = new TalonFX(0);
    lowerFx = new TalonFX(1);
    
  upperFx.configOpenloopRamp(2);
  lowerFx.configOpenloopRamp(2);
  upperFx.setNeutralMode(NeutralMode.Coast);
  lowerFx.setNeutralMode(NeutralMode.Coast);
  lowerFx.setInverted(true);
}

public void launch(ControlMode mode,double launchvalue) {
  upperFx.set(mode, launchvalue);
  lowerFx.set(mode, launchvalue);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
