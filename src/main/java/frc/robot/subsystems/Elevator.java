package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase{
    private static Elevator instance; 

    private HSTalon motor_master; 
    private HSTalon motor_follower; 
    private VictorSPX motor1; 
    private VictorSPX motor2; 

    private static final int MM_ID = 0; 
    private static final int MF_ID = 0; 
    private static final int M1_ID = 0; 
    private static final int M2_ID = 0; 
    

    private static final boolean invert_m = false; 
    private static final boolean invert_f = false; 
    private static final boolean invert_1 = false; 
    private static final boolean invert_2 = false;

    private Elevator(){
        motor_master = new HSTalon(MM_ID); 
        motor_follower = new HSTalon(MF_ID); 
        motor1 = new VictorSPX(M1_ID); 
        motor2 = new VictorSPX(M2_ID);

        motor_follower.follow(motor_master); 
        motor1.follow(motor_master); 
        motor2.follow(motor_master); 

        motor_master.setInverted(invert_m); 
        motor_follower.setInverted(invert_f);
        motor1.setInverted(invert_1);
        motor2.setInverted(invert_2);


    }

    public HSTalon getMotorM(){

        return motor_master; 
    }
    public HSTalon getMotorF(){

        return motor_follower; 
    }
    public VictorSPX getMotor1(){
    
        return motor1; 
    }
    public VictorSPX getMotor2(){
        return motor2; 
    }

    public void setPercentOutput(double output){
        motor_master.set(ControlMode.PercentOutput, output);
    }

    public static Elevator getInstance(){
        if (instance == null){
            instance = new Elevator();
        }
        return instance;
    }


    
}
