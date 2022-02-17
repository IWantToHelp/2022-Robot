/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
//Motor Constants
    public static final int FrontRightID = 0;
    public static final int FrontLeftID = 3;
    public static final int BackRightID = 5;
    public static final int BackLeftID = 2;

//Controller Stick Constants
    public static final int XBOX_R_XAXIS = 4;
    public static final int XBOX_R_YAXIS = 5;
    public static final int XBOX_L_XAXIS = 0;
    public static final int XBOX_L_YAXIS = 1;
    public static final int XBOX_pin = 0;

    // auton drive PID constants
    public static final int kTimeoutMs = 20;
    public static final int kPIDLoopIdx = 0;//run primary loop
    public static final double kF = 0;
    public static final double kP = 0;
    public static final double kI = 0;
    public static final double kD = 0.5;

    public static final double vertDist = 8;
    public static final double x_dot = 1;



    // Intake Constants
    public static final int deviceIdIntake = 1;
    public static final double intakeMotorSpeed = 0.5;
    public static final int pistonID = 1;   
    public static final double ampSpike = .1;
    public static final double closestY = 100;
    public static final double closestX = 160;
    // turn PID constants
    public static final double turnkP = 0.02;
    public static final double turnkI = 0;
    public static final double turnkD = 0;

    // Vision constants
    public static final double goalHeight = 107;

    //PixyCamera Constants
    public static final int pixyWidth = 316;
    public static final int pixyHeight = 208;
    public static final int pixyHcenter = 158;
    public static final int pixyVerticalAngle = 20;
    public static final int pixyHorizontalAngle = 30;
    public static final int pixyRedSig = 1;
    public static final int pixyBlueSig = 2;
}
