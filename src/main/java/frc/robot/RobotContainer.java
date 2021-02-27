// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Drive;

import frc.robot.subsystems.DriveBase;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TurretMove;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj2.command.Command;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final static DriveBase driveBase = new DriveBase();
  private final static Turret turret = new Turret();

  private final static Drive tDrive = new Drive(driveBase);
  private final static TurretMove turretMove = new TurretMove(turret);

  public static Joystick driver = new Joystick(0);
  public static Joystick operator = new Joystick(1);
  public static JoystickButton operatorLeftBumper = new JoystickButton(operator, 5);
  public static JoystickButton operatorRightBumper = new JoystickButton(operator, 6);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public static void initMotor(TalonFX driveFrontL, double peak) {

      driveFrontL.configPeakOutputForward(peak);
      driveFrontL.configPeakOutputReverse(-peak);
      driveFrontL.setNeutralMode(NeutralMode.Brake);

  }

  public static void startDrive() {
    tDrive.schedule(true);
  }

  public static void initMotor(TalonSRX turretmotor, double peak) {
    turretmotor.configPeakOutputForward(peak);
  }

  public static void startTurretMove() {
    turretMove.schedule(true);
  }
}
