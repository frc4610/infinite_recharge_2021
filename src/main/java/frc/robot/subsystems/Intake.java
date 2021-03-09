// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Intake extends SubsystemBase 
{
  private CANSparkMax intakingNeo;
  private static DoubleSolenoid solenoidX;
  private static Compressor compressorX;
  
  public Intake() 
  {
    intakingNeo = new CANSparkMax(10, MotorType.kBrushless);
   solenoidX = new DoubleSolenoid(1, 1, 2);
   compressorX =new Compressor();
   
  }

  public void intaking(ControlMode mode, double speedx) 
  {
    intakingNeo.set(speedx);
  }

  public void solenoidMoveN()
  {
  solenoidX.set(Value.kOff);
  }

  public void solenoidMoveF()
  {
  solenoidX.set(Value.kForward);
  }
  public void solenoidMoveR()
  {
  solenoidX.set(Value.kReverse);
  }

  public void compressorStart()
  {
    compressorX.start();
  }

  public void compressorClose()
  {
    compressorX.stop();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
