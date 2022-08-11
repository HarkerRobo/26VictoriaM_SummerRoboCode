package frc.robot.commands;
import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;

/**
 * Moves a motor at a desired speed for a cettain amount of time 
 */

public class ManualDrive extends IndefiniteCommand{

    public ManualDrive(){
         addRequirements(Drivetrain.getInstance());
    }

    public void execute(){
        double turn = OI.getInstance().getDriver().getLeftX(); 
        double speed = OI.getInstance().getDriver().getLeftY(); 
        Drivetrain.getInstance().setArcadeDrive(speed, turn);
    }

    public void end(boolean interrupted){
        Drivetrain.getInstance().setArcadeDrive(0,0);
    }
}

//Operating interface - HS Gamepad, Xbox Gamepad, drive and operator as controllers 
//ArcadeDriveManual command 