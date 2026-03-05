package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.shooter.Shooter;

public class hood extends Command{
    
    public final Shooter shooterSub;


    public hood(Shooter hood) {

        this.shooterSub = hood;

    }

    @Override
    public void initialize() {

        shooterSub.setHood(!shooterSub.getHood());

    }


    @Override
    public boolean isFinished() {

        return true;

    }


}
