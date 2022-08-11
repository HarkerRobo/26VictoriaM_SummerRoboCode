package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class WristRoller extends SubsystemBase{
    private static WristRoller instance; 

    private HSTalon motor; 
    private static final int id = 0; 
    private static final boolean inverted = false; 

    private WristRoller(){
        motor = new HSTalon(id); 
        motor.setInverted(inverted); 
    }
    public void setPercentOutput(double output){
        motor.set(ControlMode.PercentOutput, output);
    }
    public static WristRoller getInstance(){
        if (instance == null){
            instance = new WristRoller();
        }
        return instance;
    }
}
