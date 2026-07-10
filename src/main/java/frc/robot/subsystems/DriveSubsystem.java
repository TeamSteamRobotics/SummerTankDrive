// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private DifferentialDrive drive;
  private PWMTalonFX leftLeader;
  private PWMTalonFX leftFollower;
  private PWMTalonFX rightLeader;
  private PWMTalonFX rightFollower; 

  double speed;
  double turnRate;
  public DriveSubsystem() {
    leftLeader    = new PWMTalonFX(1);
    leftFollower  = new PWMTalonFX(2);
    rightLeader   = new PWMTalonFX(3);
    rightFollower = new PWMTalonFX(4);

    leftLeader.addFollower(leftFollower);
    rightLeader.addFollower(rightFollower);
    rightLeader.setInverted(true);

    drive = new DifferentialDrive(leftLeader::set, rightLeader::set);
  }

  public void setSpeed(double setValue){
    speed = setValue;
  }

  public void setTurnRate(double setValue){
    turnRate = setValue;
  }

  @Override
  public void periodic() {
    drive.arcadeDrive(speed, turnRate);
    // This method will be called once per scheduler run
  }
}
