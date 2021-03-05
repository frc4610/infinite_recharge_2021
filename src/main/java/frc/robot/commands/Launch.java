
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Launcher;
  public class Launch extends CommandBase {
    private Launcher launcher;
    private Feed feed;
    /** Creates a new Launch. */
    public Launch(Launcher launch, Feed feeder) {
      launcher = launch;
      feed = feeder;
      // Use addRequirements() here to declare subsystem dependencies.
    }

      // Called when the command is initially scheduled.
      @Override
    public void initialize() {}
      // Called every time the scheduler runs while the command is scheduled.
      @Override
    public void execute() {
      double triggerValue = RobotContainer.driver.getRawAxis(3);
      launcher.launch(ControlMode.PercentOutput, triggerValue);
      if(RobotContainer.driver.getRawAxis(3) >= 0) {
        feed.move(ControlMode.PercentOutput, 1, 1);
      }
      else {
        feed.move(ControlMode.PercentOutput, 0, 0);
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