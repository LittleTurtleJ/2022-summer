// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.networktables.*;

public class Limelight extends SubsystemBase {
  private static Limelight limelight;

  /** Creates a new Limelight. */
  public Limelight() {}

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static Limelight getInstance() {
    if (limelight == null) limelight = new Limelight();
    return limelight;
  }
}
