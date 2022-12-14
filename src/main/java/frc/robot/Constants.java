// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Motor Ports
    public static final int TALON_L_LEADER_PORT = 3;
    public static final int TALON_L_FOLLOWER_PORT = 1;
    public static final int TALON_R_LEADER_PORT = 2;
    public static final int TALON_R_FOLLOWER_PORT = 5;
    public static final int ARM_NEO_PORT = 4;
    public static final int BALL_INTAKE_MOTOR = 5;

    // Ports on computer
    public static final int CONTROLLER_PORT = 0;

    // Button Map
    public static final int INTAKE_BUTTON = 1;
    public static final int OUTTAKE_BUTTON = 2;
    public static final int ARM_UP_BUTTON = 5;
    public static final int ARM_DOWN_BUTTON = 6;

    // Motor Rotation Speed
    public static final double INTAKE_SPEED = 0.7;
    public static final double ARM_UP_SPEED = 0.7;
    public static final double ARM_DOWN_SPEED = -0.1;
}
