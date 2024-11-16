// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.PivotConstants;
import frc.robot.Constants.RollerConstants;

import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.SparkPIDController.ArbFFUnits;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PivotSubsystem extends SubsystemBase {
  static double speed;
  static double angle;
  private final CANSparkMax pivotMotor;
  static SparkPIDController pidController;
  public RelativeEncoder encoder;

  /** Creates a new ExampleSubsystem. */
  public PivotSubsystem() {
    angle = 0;
    pivotMotor = new CANSparkMax(RollerConstants.ROLLER_MOTOR_ID, MotorType.kBrushless);//neo
    pidController = pivotMotor.getPIDController();
    pidController.setP(PivotConstants.PIVOT_P);  // Proportional gain
    pidController.setI(PivotConstants.PIVOT_I);  // Integral gain
    pidController.setD(PivotConstants.PIVOT_D);  // Derivative gain
    
    encoder = pivotMotor.getEncoder();

  }

  /**
   * Example command factory method.
   *
   * @return a command
   */

  //sets the speed of the rollers

  
  public void setTargetState(Double pos) {
    pidController.setReference(pos, ControlType.kPosition, 0, 0, ArbFFUnits.kPercentOut);
    return;
}
public double getMotorPosition() {
  // Returns the position in rotations
  return encoder.getPosition();
}
  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */

   //sets the actuall speed of the rollers
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
