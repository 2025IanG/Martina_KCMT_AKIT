// Copyright 2021-2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot.subsystems.drive;

// import com.ctre.phoenix6.BaseStatusSignal;
// import com.ctre.phoenix6.StatusCode;
// import com.ctre.phoenix6.StatusSignal;
// import com.ctre.phoenix6.configs.Pigeon2Configuration;
// import com.ctre.phoenix6.hardware.Pigeon2;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.SPI.Port;

/** IO implementation for NavX */
public class GyroIONavX implements GyroIO {
  private final AHRS navX = new AHRS(Port.kMXP);
  private final double yaw = navX.getYaw();
  private final double yawVelocity = navX.getRate();

  public GyroIONavX() {}

  @Override
  public void updateInputs(GyroIOInputs inputs) {
    inputs.connected = navX.isConnected();
    inputs.yawPosition = Rotation2d.fromDegrees(yaw);
    inputs.yawVelocityRadPerSec = Units.degreesToRadians(yawVelocity);
  }
}
