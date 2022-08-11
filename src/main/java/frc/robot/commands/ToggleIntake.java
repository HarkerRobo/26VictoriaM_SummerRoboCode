package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends InstantCommand{
    public ToggleIntake(){
        addRequirements(Drivetrain.getInstance());
    }

    public void initialize(){
        Intake.getInstance().toggle();
    }
    public void execute(){
        OI.getInstance().getDriver().getRightTrigger(); 
    }

    
}
