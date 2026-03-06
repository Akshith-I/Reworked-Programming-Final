package frc.robot.subsystems.drive;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class DriveIOSparkMax implements DriveIO {
    
    public SparkMax frontLeft;
    public SparkMax frontRight;
    public SparkMax backLeft;
    public SparkMax backRight;

    public DriveIOSparkMax(int fl, int fr, int bl, int br) {

        frontLeft = new SparkMax(fl, MotorType.kBrushless);
        frontRight = new SparkMax(fr, MotorType.kBrushless);
        backLeft = new SparkMax(bl, MotorType.kBrushless);
        backRight = new SparkMax(br, MotorType.kBrushless);

        SparkMaxConfig rightConfig = new SparkMaxConfig();
        SparkMaxConfig leftConfig = new SparkMaxConfig();
        SparkMaxConfig rightFrontConfig = new SparkMaxConfig();
        SparkMaxConfig leftFrontConfig = new SparkMaxConfig();

        rightConfig.idleMode(IdleMode.kCoast);
        leftConfig.idleMode(IdleMode.kCoast);
        rightFrontConfig.idleMode(IdleMode.kCoast);
        leftFrontConfig.idleMode(IdleMode.kCoast);

        rightConfig.smartCurrentLimit(50);
        leftConfig.smartCurrentLimit(50);
        rightFrontConfig.smartCurrentLimit(50);
        leftFrontConfig.smartCurrentLimit(50);

        rightConfig.inverted(false);
        leftConfig.inverted(true);
        rightFrontConfig.inverted(false);
        leftFrontConfig.inverted(true);

        rightConfig.follow(frontRight);
        leftConfig.follow(frontLeft);

        frontLeft.configure(leftFrontConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        frontRight.configure(rightFrontConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        backLeft.configure(rightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        backRight.configure(rightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        
    }
    
    public void arcadeDrive(double left, double right) {
        frontLeft.set(left);
        frontRight.set(right);
    }
    
}


