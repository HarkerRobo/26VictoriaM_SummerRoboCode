package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase{
    private static Intake instance; 
    
    private HSTalon motor; 
    private static final int CAN_ID = 0; 
    private static final boolean inverted = false; 
    private DoubleSolenoid solenoid; 
    private static final int ID_1 = 0; 
    private static final int ID_2 = 0; 

    private boolean intake; 

    private Intake(){
        motor = new HSTalon(CAN_ID); 
        motor.setInverted(inverted);
        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, ID_1, ID_2); 
        intake = false; 
    }

    public  HSTalon getMotor(){
        return motor;
    }
    public void setPercentOutput(double output){
        if (output>=0.3)
            intake = true; 
        else intake = false; 
        motor.set(ControlMode.PercentOutput, output);
    }

    public boolean getIntake(){
        return intake;
    }
    public void toggle(){
        if (solenoid.get() == DoubleSolenoid.Value.kOff){
            solenoid.set(DoubleSolenoid.Value.kReverse);
        }
        if (solenoid.get() == DoubleSolenoid.Value.kReverse){
            solenoid.set(DoubleSolenoid.Value.kForward);
        }
        if (solenoid.get() == DoubleSolenoid.Value.kForward){
            solenoid.set(DoubleSolenoid.Value.kOff);
        }

    }

    public static Intake getInstance(){
        if (instance == null){
            instance = new Intake();
        }
        return instance;
    }

}