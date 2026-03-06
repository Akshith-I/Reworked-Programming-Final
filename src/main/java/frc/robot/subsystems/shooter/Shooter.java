package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;

import static frc.robot.subsystems.shooter.ShooterConstants.*;


public class Shooter {
    
    TalonFX rightLaunch = new TalonFX(rightLauncherID);
    TalonFX leftLaunch = new TalonFX(leftLauncherID);
    TalonSRX feeder = new TalonSRX(feedRollerID);

    Solenoid hood;

    public Shooter(PneumaticHub hub) {

        hood = hub.makeSolenoid(SolenoidID);

        rightLaunch.getConfigurator().apply(new TalonFXConfiguration());
        leftLaunch.getConfigurator().apply(new TalonFXConfiguration());
    
        feeder.configFactoryDefault();

        hood.set(false);
    }


    public void setLaunch(double speed) {

        leftLaunch.set(speed * maxLaunchSpeed);

    }    

    public void setFeederSpeed(double speed) {

        feeder.set(ControlMode.PercentOutput, -speed * maxFeedSpeed);

    }

    public double getLaunchingSpeed() {

        return ((leftLaunch.get() + rightLaunch.get())/2);

    }

    public double getFeedSpeed(double speed) {

        return feeder.getMotorOutputPercent();

    }

    public void setHood(boolean state) {
        
        hood.set(state);

    }

    public boolean getHood() {

        return hood.get();

    }

}