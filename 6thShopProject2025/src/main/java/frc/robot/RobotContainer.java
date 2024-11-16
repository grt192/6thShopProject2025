// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;

import frc.robot.Constants.PivotConstants;

import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import frc.robot.subsystems.TankSubsystem;

public class RobotContainer {

  // Subsystems defined
  private final TankSubsystem tankSubsystem;

  // Controls defined
  private final PivotSubsystem pivotSubsystem;
  private final CommandPS4Controller mechController;
  private final RollerSubsystem rollerSubsystem;
  public double joyConLeft;
  public double joyConRight;

  public RobotContainer() {

    // Subsystem created
    tankSubsystem = new TankSubsystem();
    rollerSubsystem = new RollerSubsystem();
    pivotSubsystem = new PivotSubsystem();
    // Configure Bindings
    mechController = new CommandPS4Controller(0); // Use PS4 controller
    joyConLeft = 0;
    joyConRight = 0;
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandPS4Controller
   * PS4}/{@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    tankSubsystem.setDefaultCommand(new RunCommand(() -> {
      this.joyConLeft = mechController.getLeftY(); // Left Y-axis for PS5 controller
      this.joyConRight = mechController.getRightY(); // Right Y-axis for PS5 controller

      tankSubsystem.setMotors(joyConLeft, joyConRight);
    }, tankSubsystem));
    
    //if pressed circle, run rollers
    mechController.circle().onTrue(Commands.runOnce(() -> rollerSubsystem.setSpeed(0.5), rollerSubsystem));
    //if not pressed circle, run rollers
    mechController.circle().onFalse(Commands.runOnce(() -> rollerSubsystem.setSpeed(0), rollerSubsystem));

    mechController.triangle().onTrue(Commands.runOnce(() -> pivotSubsystem.setTargetState(PivotConstants.CLOSED), rollerSubsystem));
    mechController.square().onTrue(Commands.runOnce(() -> pivotSubsystem.setTargetState(PivotConstants.FLOOR), rollerSubsystem));
    mechController.cross().onTrue(Commands.runOnce(() -> pivotSubsystem.setTargetState(PivotConstants.DROPBOX), rollerSubsystem));

  }

  // /**
  // * Use this to pass the autonomous command to the main {@link Robot} class.
  // *
  // * @return the command to run in autonomous
  // */
  // public Command getAutonomousCommand() {
  // // An example command will be run in autonomous
  // return Autos.exampleAuto(m_exampleSubsystem);
  // }
}