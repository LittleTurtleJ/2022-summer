// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends SubsystemBase {
    // Class Specific Constants
    public static final double DEADBAND = 0.05;
    public static final double MAX_OUTPUT = 1.0;
    public static final double VOLT_COMP = 6.0;
    public static final double AMP_LIMIT = 40.0;
    public double amount = 0.0; // Might be constant

    private static DriveTrain driveTrain;

    // Creates motors w/ ports and then drivetrain
    WPI_TalonFX talonRLeader = new WPI_TalonFX(Constants.TALON_R_LEADER_PORT);
    WPI_TalonFX talonRFollower = new WPI_TalonFX(Constants.TALON_R_FOLLOWER_PORT);
    WPI_TalonFX talonLLeader = new WPI_TalonFX(Constants.TALON_L_LEADER_PORT);
    WPI_TalonFX talonLFollower = new WPI_TalonFX(Constants.TALON_L_FOLLOWER_PORT);

    DifferentialDrive drivetrain = new DifferentialDrive(talonLLeader, talonRLeader);

    // Creates a new DriveTrain and sets the deadband and max output according to drivetrain constants
    public DriveTrain() {
        // Makes the followers follow the leader and inverts the right side
        talonLFollower.follow(talonLLeader);
        talonRFollower.follow(talonRLeader);
        talonRLeader.setInverted(true);
        talonRFollower.setInverted(true);

        drivetrain.setDeadband(DEADBAND);
        drivetrain.setMaxOutput(MAX_OUTPUT);

        applyChanges();
        setDriveEncoder(0);
    }

    // Method to drive in arcade style, throttle joystick is the reversed one
    public void arcadeDrive(double throttle, double turn) {
        drivetrain.arcadeDrive(throttle, turn, false);
    }

    // This is very bad code for auto, included purely for demonstration
    public void autoDrive(long time) {
        long t = System.currentTimeMillis();
        long end = t + time;

        while(System.currentTimeMillis() < end) {
            SmartDashboard.putNumber("Time", amount++);
            arcadeDrive(0.5, 0);
        }
    }

    // Stops all motors
    public void stop() {
        talonLLeader.set(0);
        talonRLeader.set(0);
    }

    public void setDriveEncoder(int value) {
        talonLLeader.setSelectedSensorPosition(value);
        talonRLeader.setSelectedSensorPosition(value);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    private void applyChanges() {
        // Resets motors to factory default
        talonRLeader.configFactoryDefault();
        talonRFollower.configFactoryDefault();
        talonLLeader.configFactoryDefault();
        talonLFollower.configFactoryDefault();
    
        //sets voltage compensation (very important!)
        talonRLeader.configVoltageCompSaturation(VOLT_COMP);
        talonRFollower.configVoltageCompSaturation(VOLT_COMP);
        talonLLeader.configVoltageCompSaturation(VOLT_COMP);
        talonLFollower.configVoltageCompSaturation(VOLT_COMP);
    
        // Enables voltage compensation
        talonRLeader.enableVoltageCompensation(true);
        talonRFollower.enableVoltageCompensation(true);
        talonLLeader.enableVoltageCompensation(true);
        talonLFollower.enableVoltageCompensation(true);
      
        //sets input current limit to motors
        talonRLeader.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, AMP_LIMIT, AMP_LIMIT, 0));
        talonRFollower.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, AMP_LIMIT, AMP_LIMIT, 0));
        talonLLeader.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, AMP_LIMIT, AMP_LIMIT, 0));
        talonLFollower.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, AMP_LIMIT, AMP_LIMIT, 0));
    
        talonRLeader.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        talonLLeader.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
      }

    public static DriveTrain getInstance() {
        if (driveTrain == null) driveTrain = new DriveTrain();
        return driveTrain;
    }

    public WPI_TalonFX getLLeader() {
        return talonLLeader;
    }

    public WPI_TalonFX getRLeader() {
        return talonRLeader;
    }

    public WPI_TalonFX getLFollow() {
        return talonLFollower;
    }

    public WPI_TalonFX getRFollow() {
        return talonRFollower;
    }
}
