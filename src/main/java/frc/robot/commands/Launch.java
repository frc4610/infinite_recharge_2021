// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Launcher;
import edu.wpi.first.wpilibj.Timer;

public class Launch extends CommandBase {
  private Launcher launcher;
  private Feed feed;
  private Timer timer;
  /** Creates a new LaunchPC. */
  public Launch(Launcher launch, Feed feeder) {
    launcher = launch;
    feed = feeder;
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double triggerValue = (RobotContainer.operator.getRawAxis(3)/1.25 + .2);
    if(RobotContainer.operator.getRawAxis(3) > 0) {
      launcher.launch(ControlMode.PercentOutput, triggerValue);
      timer.start();
      if(timer.get()  > 2) {
        feed.move(ControlMode.PercentOutput, .8, .8);
      }
    }
    else {
      feed.move(ControlMode.PercentOutput, 0, 0);
      launcher.launch(ControlMode.PercentOutput, .2);
      timer.reset();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
