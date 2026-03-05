package frc.robot.subsystems.intake.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.Intake;

public class SetIntake  extends Command{
    
    public final Intake intake;
    public final boolean state;

    public SetIntake(Intake intake, boolean state) {

        this.intake = intake;
        this.state = state;

   }

    @Override
    public void execute() {

        intake.setState(state);

    }

    @Override
    public void end(boolean interrupted) {

        intake.setState(false);

    }

}