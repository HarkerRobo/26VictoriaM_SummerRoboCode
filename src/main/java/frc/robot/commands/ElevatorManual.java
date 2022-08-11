package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import harkerrobolib.commands.IndefiniteCommand;

public class ElevatorManual extends IndefiniteCommand{
    public ElevatorManual(){
        addRequirements(Intake.getInstance());
    }

    public void execute(){
        double output = OI.getInstance().getDriver().getRightY(); 
        if (output<0.1)
            output = 0.1; 
        Elevator.getInstance().setPercentOutput(output);
    }

    public void end(boolean interrupted){
        Elevator.getInstance().setPercentOutput(0);
    }
}
