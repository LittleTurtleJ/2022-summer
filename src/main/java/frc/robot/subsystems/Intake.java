// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private static Intake intake;

  // Creates the motor
  CANSparkMax leader = new CANSparkMax(Constants.BALL_INTAKE_MOTOR, MotorType.kBrushless);

  public Intake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed) {
    leader.set(speed);
  }

  public static Intake getInstance() {
    if (intake == null) intake = new Intake();
    return intake;
  }
}
