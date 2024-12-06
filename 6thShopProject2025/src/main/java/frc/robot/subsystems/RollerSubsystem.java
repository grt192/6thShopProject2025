// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.RollerConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class RollerSubsystem extends SubsystemBase {
  static double speed;
  private final CANSparkMax rollerMotor;
  private NetworkTableInstance networkTablesInstance;
  private NetworkTable networkTable;
  private NetworkTableEntry networkTableEntry;
  public RelativeEncoder encoder;

  /** Creates a new ExampleSubsystem. */
  public RollerSubsystem() {
    speed = 0;
    rollerMotor = new CANSparkMax(RollerConstants.ROLLER_MOTOR_ID, MotorType.kBrushless);
    networkTablesInstance = NetworkTableInstance.getDefault();
    networkTable = networkTablesInstance.getTable("networkTable");
    networkTableEntry = networkTable.getEntry("networkTableEntry");
    //networkTableEntry.setDouble(0); 
    encoder = rollerMotor.getEncoder();
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */

  //sets the speed of the rollers
  public void setSpeed(double newSpeed){
    rollerMotor.set(newSpeed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println(encoder.getPosition());
    networkTableEntry.setDouble(encoder.getPosition()); 
  }

}
