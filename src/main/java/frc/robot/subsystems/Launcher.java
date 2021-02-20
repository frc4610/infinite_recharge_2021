// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Launcher extends SubsystemBase {
  //public TalonFX upperFX;
  //public TalonFX lowerFx;
  public TalonSRX upperFx;
  public TalonSRX lowerFx;
  private double launchvalue;

  /** Creates a new Launcher. */
  public Launcher() 
  {
  //upperFX = new TalonFX(0);
  //lowerFx = new TalonFX(1);
    upperFx = new TalonSRX(7);
    lowerFx = new TalonSRX(8);
    
 upperFx.configOpenloopRamp(2);
 lowerFx.configOpenloopRamp(2);
 upperFx.setNeutralMode(NeutralMode.Coast);
 lowerFx.setNeutralMode(NeutralMode.Coast);
 lowerFx.setInverted(true);
}

public void launch() {
 upperFx.set(ControlMode.PercentOutput, launchvalue);
 lowerFx.set(ControlMode.PercentOutput, launchvalue);
  }

  public double getlaunchvalue()
  {
    return launchvalue = RobotContainer.driver.getRawAxis(3);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
