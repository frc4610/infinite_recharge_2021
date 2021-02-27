// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Launcher extends SubsystemBase {
  public TalonFX upperFx;
  public TalonFX lowerFx;
  public CANSparkMax accelMax;
  

  /** Creates a new Launcher. */
  public Launcher() 
  {
    upperFx = new TalonFX(0);
    lowerFx = new TalonFX(1);
    accelMax = new CANSparkMax(2, MotorType.kBrushless);
    
  upperFx.configOpenloopRamp(2);
  lowerFx.configOpenloopRamp(2);
  accelMax.setOpenLoopRampRate(2);
  upperFx.setNeutralMode(NeutralMode.Coast);
  lowerFx.setNeutralMode(NeutralMode.Coast);
  accelMax.setIdleMode(IdleMode.kCoast);
  lowerFx.setInverted(true);
}

public void launch(ControlMode mode,double launchvalue) {
  upperFx.set(mode, launchvalue);
  lowerFx.set(mode, launchvalue);
  accelMax.set(.5);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
