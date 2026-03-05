package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.subsystems.intake.IntakeConstants.*;

public class Intake extends SubsystemBase {
    
    TalonSRX frontRoller = new TalonSRX(frontRollerID);

    Solenoid intake;

    public Intake(PneumaticHub hub) {

        intake = hub.makeSolenoid(feederSolenoid);
        
        frontRoller.configFactoryDefault();

        intake.set(false);

    }   

    public void setSpeed(double speed) {

        frontRoller.set(ControlMode.PercentOutput, speed * maxIntakeSpeed);

    }

    public double getSpeed() {

        return frontRoller.getMotorOutputPercent();

    }

    public void setState(boolean state) {

        intake.set(state);


    }

    public boolean getState() {

        return intake.get();

    }


}
