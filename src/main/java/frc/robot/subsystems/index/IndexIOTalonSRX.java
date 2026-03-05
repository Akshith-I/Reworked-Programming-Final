package frc.robot.subsystems.index;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.subsystems.index.IndexConstants.*;

public class IndexIOTalonSRX implements IndexIO{
    
    TalonSRX rightIndexer = new TalonSRX(IndexConstants.RIGHT_INDEXER_ID);
    TalonSRX leftIndexer = new TalonSRX(IndexConstants.LEFT_INDEXER_ID);

    

    public IndexIOTalonSRX() {

        rightIndexer.configFactoryDefault();
        leftIndexer.configFactoryDefault();


    }


        public void setVolts(double volts) {

            rightIndexer.set(ControlMode.Current, volts);
            leftIndexer.set(ControlMode.Current, volts);

        }

    
    
}
