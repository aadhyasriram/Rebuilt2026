// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Meters;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ClimberSubsystem;

public class RobotContainer {
  private final ClimberSubsystem m_climber = new ClimberSubsystem();
  private final CommandXboxController m_driverController = new CommandXboxController(0);
  public RobotContainer() {
    configureBindings();
    // Set the default command to force the elevator to go to 0.
    m_climber.setDefaultCommand(m_climber.setHeight(Meters.of(0)));
  }

  private void configureBindings() {
    // Schedule `setHeight` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.a().whileTrue(m_climber.setHeight(Meters.of(0.5)));
    m_driverController.b().whileTrue(m_climber.setHeight(Meters.of(1)));
    // Schedule `set` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.x().whileTrue(m_climber.set(0.3));
    m_driverController.y().whileTrue(m_climber.set(-0.3));
    
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
