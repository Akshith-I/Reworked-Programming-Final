package frc.robot.subsystems.drive;

import edu.wpi.first.math.geometry.Pose2d;

public interface DriveIO {
    
    public static class DriveIOInputs {

        public Pose2d robotPose = new Pose2d();

        public double rightVoltOutput = 0.0;
        public double leftVoltOutput = 0.0;

        public double rightVelocityMPS = 0.0;
        public double leftVelocityMPS = 0.0;

        public double rightPositionMeters = 0.0;
        public double leftPositioMeters = 0.0;
    
        public double[] rightCurrentAmps = new double[0];
        public double[] leftCurrentAmps = new double[0];
    }

    public void arcadeDrive(double left, double right);


}
