package frc.robot.subsystems.index;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Index extends SubsystemBase{
    
    private final IndexIO io;

    public Index(IndexIO io) {

        this.io = io;

    }

    public Command setVolts(double volts) {
    return this.run(() -> {io.setVolts(volts);}).finallyDo(() -> {io.setVolts(0.0);});
  
    }

}
