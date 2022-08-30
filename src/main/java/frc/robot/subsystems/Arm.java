// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private static Arm arm;

  // Creates the motor
  CANSparkMax motor = new CANSparkMax(Constants.ARM_NEO_PORT, MotorType.kBrushless);

  public Arm() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Spins the motor at the specified speed
  public void spinArm(double speed) {
    motor.set(speed);
  }

  public static Arm getInstance() {
    if (arm == null)
      arm = new Arm();
    return arm;
  }
}
