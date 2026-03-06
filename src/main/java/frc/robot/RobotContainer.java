// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.drive.DriveConstants;
import frc.robot.subsystems.drive.DriveIOSparkMax;
import frc.robot.subsystems.index.Index;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.Commands.RunIntake;
import frc.robot.subsystems.intake.Commands.SetIntake;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.shooter.hood;
import frc.robot.subsystems.shooter.Commands.RunFeed;
import frc.robot.subsystems.shooter.Commands.RunLaunch;
import frc.robot.subsystems.index.Index.*;
import frc.robot.subsystems.index.IndexConstants;
import frc.robot.subsystems.index.IndexIOTalonSRX;



public class RobotContainer {
  
  private Drive drive;
  private Intake intake;
  private Shooter shooter;
  private Index index;
  private CommandXboxController controller  = new CommandXboxController(0);
  private PneumaticHub hub = new PneumaticHub(31);
  
  public RobotContainer(boolean isReal) {
    
    drive = new Drive(new DriveIOSparkMax(DriveConstants.FRONT_LEFT_ID, DriveConstants.FRONT_RIGHT_ID, DriveConstants.BACK_LEFT_ID, DriveConstants.BACK_RIGHT_ID));
    intake = new Intake(hub);
    shooter = new Shooter(hub);
    index = new Index(new IndexIOTalonSRX());
    
    configureBindings();
  }

  private void configureBindings() {

    drive.setDefaultCommand(
        drive.arcadeDrive(
            () -> -controller.getRightX(),
            () -> controller.getLeftY()));

    controller.x().whileTrue(new RunIntake(intake, 1));
    controller.b().whileTrue(new SetIntake(intake, true));
    controller.rightTrigger(0.5).whileTrue(new RunFeed(shooter, 1));
    controller.y().whileTrue(new RunLaunch(shooter, 1));
    controller.y().whileTrue(index.setVolts(1.0));
    controller.povUp().whileTrue(new hood(shooter));

    controller.leftBumper().whileTrue(new RunIntake(intake, -1));
    controller.leftBumper().whileTrue(new RunFeed(shooter, -1));




  }

  public Command getAutonomousCommand() {
    return Commands.none();
  }
}
