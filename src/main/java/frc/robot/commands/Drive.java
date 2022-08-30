// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {
  /** Creates a new Drive. */
  public Drive() {
    addRequirements(DriveTrain.getInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Gets Throttle/Turn speed from OI and runs command in DriveTrain
    double throttle = OI.getInstance().getThrottleAxis();
    double turn = OI.getInstance().getTurnAxis();

    DriveTrain.getInstance().arcadeDrive(throttle, turn);
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
