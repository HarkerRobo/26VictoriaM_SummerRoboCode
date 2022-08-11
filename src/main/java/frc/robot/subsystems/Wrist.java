package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Wrist extends SubsystemBase{
    public static Wrist instance; 

    private HSTalon master; 
    private VictorSPX follower; 
    
    private static final int id1 = 0; 
    private static final int id2 = 0; 

    private static final boolean invert1 = false; 
    private static final boolean invert2 = false; 

    private Wrist(){
        master = new HSTalon(id1); 
        follower = new VictorSPX(id2); 

        follower.follow(master); 

        master.setInverted(invert1); 
        master.setInverted(invert2);
    }

    public void setPercentOutput(double output){
        master.set(ControlMode.PercentOutput, output);
    }

   public static Wrist getInstance(){
        if (instance == null){
            instance = new Wrist();
        }
        return instance;
    }
}
