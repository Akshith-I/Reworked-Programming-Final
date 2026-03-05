package frc.robot.subsystems.shooter.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter.Shooter;

public class RunLaunch extends Command {
    
    private final Shooter shooter;
    private final double speed;


    public RunLaunch(Shooter shooter, double speed) {

        this.shooter = shooter;
        this.speed = speed;


    }

    @Override
    public void execute() {

        shooter.setLaunch(speed);

    }

    @Override
    public void end(boolean interrupted) {

        shooter.setLaunch(0);

    }
 
}

