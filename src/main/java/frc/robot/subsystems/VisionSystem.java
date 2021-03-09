// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSystem extends SubsystemBase {
  /** Creates a new VisionSystem. */
  public VisionSystem() 
  {
    //Just sets up table..
    NetworkTable table = NetworkTableInstance.getDefault().getTable("LimeLight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    //This reads values perodicly...
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double a = ta.getDouble(0.0);

    //Puts read values onto SmartDashboard...
    SmartDashboard.putNumber("LimeLight", x);
    SmartDashboard.putNumber("LimeLight", y);
    SmartDashboard.putNumber("LimeLight", a);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
