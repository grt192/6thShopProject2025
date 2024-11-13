// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerSubsystem extends SubsystemBase {
  double speed;
  private final CANSparkMax rollerMotor;
  /** Creates a new ExampleSubsystem. */
  public RollerSubsystem() {
    speed = 0;
    rollerMotor = new CANSparkMax();
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */

  public void setSpeed(double newSpeed){
    speed = newSpeed;
  }
  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    set.motor(speed)//set motor power
  }

}
