/*----------------------------------------------------------------------------*/
/* Copyright (c) 2021 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableEntry;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSystem extends SubsystemBase {
  double x;
  double y;
  boolean area;
  /**
   * Creates a new limeLight.
   */
  public VisionSystem() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
  }

  /**
   * Turns the limelight's LEDs off
   */
  public void vLEDoff() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
  }

  /**
   * Turns the limelight's LEDs on
   */
  public void vLEDon() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
  }

  /**
   * Stores tx, ty, and tv values from the limelight pipeline
   */
  public void visionStoreValues() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry tv = table.getEntry("tv");
    x = tx.getDouble(0);
    y = ty.getDouble(0);
    area = tv.getDouble(0.0) == 1.0;
  }

  public double getXValue() {
    return x;
  }
  /**
   * Does the limelight have a valid target?
   * @return Whether or not the limelight can see any valid targets
   */
  public boolean hasValidTarget() {
    return area;
  }
  /**
   * Runs vision targeting to determine distance from target
   * 
   * @param h1 Disatnce from ground to camera's lens
   * @param h2 Distance from ground to target
   * @param a1 Angle, degrees, from ground to camera lens
   * @return Distance from the camera lens to the target
   */
  public double getDistance(double h1, double h2, double a1) {
    return (h2 - h1)/(Math.tan(a1+Math.toRadians(y)));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}