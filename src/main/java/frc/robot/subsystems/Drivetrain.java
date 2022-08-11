package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

/**
 * Sample subsystem structure 
 * @since Agusut 9, 2021
 */
public class Drivetrain extends SubsystemBase {
    //singleton variable 
    //private static Drivetrain instance; 
    //contains instance of Drivetrain type 
 

    //4 motor ids, 4 private instance variables 
    private static Drivetrain instance; 
    //instance vairable for the motor 
    //private HSTalon motor;

    private HSTalon motorlm; 
    private HSTalon motorrm; 
    private VictorSPX motorlf; 
    private VictorSPX motorrf; 

    //constant for motor device id 
    //handles motor initilization 
    private static final int MOTOR_ID_LM = 0;
    private static final int MOTOR_ID_RM = 1;
    private static final int MOTOR_ID_LF = 2;
    private static final int MOTOR_ID_RF = 3;
    
    private static final boolean invert_lm = false; 
    private static final boolean invert_rm = false; 
    private static final boolean invert_rf = false; 
    private static final boolean invert_lf = false; 
    

    private Drivetrain(){
        motorlm = new HSTalon(MOTOR_ID_LM);
        motorrm = new HSTalon(MOTOR_ID_RM);
        motorlf = new VictorSPX(MOTOR_ID_LF);
        motorrf = new VictorSPX(MOTOR_ID_RF);

        motorlf.follow(motorlm); 
        motorrf.follow(motorrm);

        motorlm.setInverted(invert_lm); 
        motorlf.setInverted(invert_lf);
        motorrm.setInverted(invert_rm);
        motorrf.setInverted(invert_rf);
    }

    //getter method for the motor 
    public HSTalon getMotorLM(){
        //LM and RM 
        return motorlm; 
    }
    public HSTalon getMotorRM(){
        //LM and RM 
        return motorrm; 
    }
    public VictorSPX getMotorLF(){
        //LM and RM 
        return motorlf; 
    }
    public VictorSPX getMotorRF(){
        //LM and RM 
        return motorrf; 
    }
    
    public void setArcadeDrive(double turn, double speed){
        motorlm.set(ControlMode.PercentOutput, turn+speed); 
        motorrm.set(ControlMode.PercentOutput, turn-speed);
        
    }

    //returns the samplesubsystem instance 
    public static Drivetrain getInstance(){
        if (instance == null){
            instance = new Drivetrain();
        }
        return instance;
    }


}