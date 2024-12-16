// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.TankConstants;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankSubsystem extends SubsystemBase {

  // declaring each motor
  private final WPI_TalonSRX leftFRONT;
  private final WPI_TalonSRX leftBACK;
  private final WPI_TalonSRX rightFRONT;
  private final WPI_TalonSRX rightBACK;

  // creating var to hold speed value for each side
  private double leftSpeed;
  private double rightSpeed;

  // creating var to break system
  private boolean motorBreak;

  /** Creates a new ExampleSubsystem. */
  public TankSubsystem() {

    // left motor pre-settings

    // setting Motor ID's
    leftFRONT = new WPI_TalonSRX(TankConstants.leftFRONT_ID);
    leftBACK = new WPI_TalonSRX(TankConstants.leftBACK_ID);

    leftBACK.follow(leftFRONT); // mimic front to back motor

    // set to Neutral so it is ready to move
    leftFRONT.setNeutralMode(NeutralMode.Coast);
    leftBACK.setNeutralMode(NeutralMode.Coast);

    // right motor pre-settings

    // setting Motor ID's
    rightFRONT = new WPI_TalonSRX(TankConstants.rightFRONT_ID);
    rightBACK = new WPI_TalonSRX(TankConstants.rightBACK_ID);

    rightBACK.follow(rightFRONT); // mimic front to back motor

    // set to Neutral so it is ready to move
    rightFRONT.setNeutralMode(NeutralMode.Coast);
    rightBACK.setNeutralMode(NeutralMode.Coast);

  }

  
  public void altDrive(double leftAxis, double rightAxis) {
    // System.out.println(rightAxis);
    if (leftAxis == 0. && rightAxis != 0.) {
      setMotors(-rightAxis, rightAxis);
    }

    else if (leftAxis != 0. && rightAxis == 0.) {
      setMotors(leftAxis, leftAxis);
    }

    else {
      setMotors((leftAxis - rightAxis) / 2.0, (leftAxis + rightAxis) / 2.0);
    }
  }

  /**
   * Sets the leftMotors and rightMotors speed and direction.
   *
   * @param leftSpeed  The raw motor speed to set the rollers to (typically
   *                   between -1.0 and 1.0).
   * @param rightSpeed The raw motor speed to set the rollers to (typically
   *                   between -1.0 and 1.0).
   */
  public void setMotors(double leftSpeed, double rightSpeed) {

    // left Motor speed set
    leftFRONT.set(-1 * leftSpeed);

    // right Motor speed set
    // System.out.println(rightSpeed);
    rightFRONT.set(rightSpeed);

  }

  /**
   * Sets the leftMotors and rightMotors brakes.
   *
   * @param motorBreak boolean for if break
   */
  public void breakMotors(boolean motorBreak) {

    // left Motor speed set
    leftFRONT.setNeutralMode(NeutralMode.Brake);
    leftBACK.setNeutralMode(NeutralMode.Brake);

    // right Motor speed set
    rightFRONT.setNeutralMode(NeutralMode.Brake);
    rightBACK.setNeutralMode(NeutralMode.Brake);

  }

}
