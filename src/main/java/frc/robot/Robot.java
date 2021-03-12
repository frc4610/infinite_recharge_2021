// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Drive;
import frc.robot.commands.IntakeArticulation;
import frc.robot.commands.Launch;
import frc.robot.commands.TurretMove;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Turret;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveBase driveBase;
  public Drive drive;
  public static Turret turret;
  public TurretMove turretMove;
  public static Launcher launcher;
  public Launch launch;
  public static Pneumatics pneumatics;
  public IntakeArticulation intakeArticulation;
  private Command m_autonomousCommand;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    driveBase = new DriveBase();
    turret = new Turret();
    pneumatics = new Pneumatics();
    launcher = new Launcher();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    //schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule(true);
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    RobotContainer.startDrive();
    RobotContainer.startTurretMove();
    RobotContainer.startLaunch();
    RobotContainer.startIntakeArticulation();
    pneumatics.collectair();
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Turret Encoder Value", turret.getTurretEncoderValue());
    SmartDashboard.putBoolean("Compr. Enabled", pneumatics.compressorenabled());
    SmartDashboard.putBoolean("Pressure Switch", pneumatics.pressureSwitch());
    SmartDashboard.putNumber("Compr. Current", pneumatics.compressorcurrent());
    SmartDashboard.putNumber("Avr. Motor Temp.", driveBase.motortemps());
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}