// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BeltSubsystem extends SubsystemBase {

  // declaring each motor
  private final WPI_TalonSRX mainBeltMotor;

  /** Creates a new ExampleSubsystem. */
  public BeltSubsystem() {

    mainBeltMotor = new WPI_TalonSRX(5);
    mainBeltMotor.setNeutralMode(NeutralMode.Coast); // turning braking to Coast

  }

  /**
   * Sets the leftMotors and rightMotors speed and direction.
   *
   * @param speed The raw motor speed to set the rollers to (typically
   *              between -1.0 and 1.0).
   */
  public void setBelt(double speed) {
    mainBeltMotor.set(speed);

  }

  /**
   * Sets the leftMotors and rightMotors brakes.
   *
   * @param motorBreak boolean for if break
   */
  public void breakRoller(boolean motorBreak) {
    if (motorBreak) {
      mainBeltMotor.set(0);
      mainBeltMotor.setNeutralMode(NeutralMode.Brake);
    } else if (!motorBreak) {
      mainBeltMotor.setNeutralMode(NeutralMode.Coast);
    }

  }

}
