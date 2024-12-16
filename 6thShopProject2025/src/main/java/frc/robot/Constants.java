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
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class TankConstants{
    public static final int leftFRONT_ID = 1;//correct
    public static final int leftBACK_ID = 2;//correct
  
    public static final int rightFRONT_ID = 4;//correct
    public static final int rightBACK_ID = 3;//correct

  }
  public static class  RollerConstants {
    public static final int ROLLER_MOTOR_ID = 12;//placeholder value
  }

  public static class  PivotConstants {
    public static final int PIVOT_MOTOR_ID = 12;//placeholder value
    public static final double PIVOT_P = 0.01;//placeholder value
    public static final double PIVOT_I = 0;//placeholder value
    public static final double PIVOT_D = 0;//placeholder value

    public static final double CLOSED = 0;//placeholder value
    public static final double FLOOR = 1;//placeholder value
    public static final double DROPBOX = .5;//placeholder value



  }
}

