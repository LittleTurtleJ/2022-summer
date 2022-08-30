// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.*;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain autoSubsystem = DriveTrain.getInstance();

  private final AutoDrive autoCommand = new AutoDrive();

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
  private void configureButtonBindings() {
    // Creates the buttons which are mapped via the numbers
    JoystickButton intakeIn = new JoystickButton(OI.getInstance().getController(), Constants.INTAKE_BUTTON);
    JoystickButton intakeOut = new JoystickButton(OI.getInstance().getController(), Constants.OUTTAKE_BUTTON);
    JoystickButton armUp = new JoystickButton(OI.getInstance().getController(), Constants.ARM_UP_BUTTON);
    JoystickButton armDown = new JoystickButton(OI.getInstance().getController(), Constants.ARM_DOWN_BUTTON);

    // Configs the buttons run commands when held
    intakeIn.whileHeld(new UseIntake(Constants.INTAKE_SPEED));
    intakeOut.whileHeld(new UseIntake(-Constants.INTAKE_SPEED));
    armUp.whileHeld(new UseArm(Constants.ARM_UP_SPEED));
    armDown.whileHeld(new UseArm(Constants.ARM_DOWN_SPEED));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoCommand;
  }
}
