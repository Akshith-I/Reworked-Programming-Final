package frc.robot.subsystems.drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    
    private final DriveIO io;
    
    public Drive(DriveIO io) {
        this.io = io;
    }

    private Field2d field = new Field2d();
    private DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(new Rotation2d(), 0, 0, new Pose2d(0, 0, new Rotation2d()));

    public void arcadeDrive(double speed, double rotation) {
        speed = MathUtil.applyDeadband(speed, 0.2);
        rotation = MathUtil.applyDeadband(rotation, 0.2);

        double right = speed - rotation;
        double left = speed + rotation;

        left *= DriveConstants.maxSpeed;
        right *= DriveConstants.maxSpeed;

        io.arcadeDrive(left, right);
    }

    public Command arcadeDrive(DoubleSupplier xSpeedDoubleSupplier, DoubleSupplier zRotationSupplier) {

        return new RunCommand(() -> {
            this.arcadeDrive(xSpeedDoubleSupplier.getAsDouble(), zRotationSupplier.getAsDouble());
        }, this);

    }

    public void periodic() {
        
    }

}
