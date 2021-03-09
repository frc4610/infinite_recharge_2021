// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase 
  {
  private Intake xIntake;
  

  
  
  /** Creates a new IntakeCommand. */
  public  IntakeCommand(Intake intake) 
    {
    xIntake = intake;
    }
    // Use addRequirements() here to declare subsystem dependencies.

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    if (RobotContainer.operatorAButton.get())
    {
      double lTriggerValue = .20;
      xIntake.intaking(ControlMode.PercentOutput, lTriggerValue);
    }
    else 
    {
      double lTriggerValueS = 0;
      xIntake.intaking(ControlMode.PercentOutput, lTriggerValueS);
    }


    if (RobotContainer.operatorLeftBumper.get())
    {
      xIntake.solenoidMoveR();
    }
    else if (RobotContainer.operatorRightBumper.get())
    {
      xIntake.solenoidMoveF();
    }
    else 
    {
      xIntake.solenoidMoveN();
    }
  

    if (RobotContainer.operatorXButton.get())
    {
      xIntake.compressorStart();
    }
    else if (RobotContainer.operatorBButton.get())
    {
      xIntake.compressorClose();
    }
    else 
    {
      xIntake.compressorClose();
    }

  }
  
 
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
  xIntake.intaking(ControlMode.PercentOutput, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
  return false;
  }

}

// Code that could be used: RobotContainer.operator.getRawAxis(7)