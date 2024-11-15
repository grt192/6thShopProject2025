// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.RollerConstants;
import com.ctre.phoenix6.signals.MotorTypeValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerSubsystem extends SubsystemBase {
  static double speed;
  private final CANSparkMax rollerMotor;
  /** Creates a new ExampleSubsystem. */
  public RollerSubsystem() {
    speed = 0;
    rollerMotor = new CANSparkMax(RollerConstants.ROLLER_MOTOR_ID, MotorType.kBrushless);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */

  //sets the speed of the rollers
  public static void setSpeed(double newSpeed){
    speed = newSpeed;
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
    rollerMotor.set(speed);
  }

}
