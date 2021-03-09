// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Drive;
import frc.robot.commands.IntakeArticulation;
import frc.robot.commands.Launch;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Pneumatics;
import frc.robot.commands.TurretMove;
import frc.robot.subsystems.Turret;


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
  private final static Drive tDrive = new Drive(driveBase);

  private final static Turret turret = new Turret();
  private final static TurretMove turretMove = new TurretMove(turret);

  private final static Pneumatics pneumatics = new Pneumatics();
  private final static Intake intake = new Intake();
  private final static IntakeArticulation intakeArticulation = new IntakeArticulation(pneumatics, intake);

  private final static Launcher launcher = new Launcher();
  private final static Feed feed = new Feed();
  private final static Launch launch = new Launch(launcher, feed);

  
  public static Joystick driver = new Joystick(0);
  public static JoystickButton driverLeftBumper = new JoystickButton(driver, 5);
  public static JoystickButton driverRightBumper = new JoystickButton(driver, 6);
  
  public static Joystick operator = new Joystick(1);
  public static JoystickButton operatorAButton = new JoystickButton(operator, 0);
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

  public static void initMotor(TalonSRX turretmotor, double peak) {

    turretmotor.configPeakOutputForward(peak);
    turretmotor.configPeakOutputReverse(-peak);
    turretmotor.setNeutralMode(NeutralMode.Brake);
  }
  public static void initMotor(TalonFX driveFrontL, double peak)
  {
    driveFrontL.configPeakOutputForward(peak);
    driveFrontL.configPeakOutputReverse(-peak);
    driveFrontL.setNeutralMode(NeutralMode.Brake);
  }

  public static void startDrive() {
    tDrive.schedule(true);
  }

  public static void startTurretMove() {
    turretMove.schedule(true);
  }

  public static void startLaunch() {
    launch.schedule(true);
  }

  public static void startIntakeArticulation() {
    intakeArticulation.schedule(true);
  }

}
