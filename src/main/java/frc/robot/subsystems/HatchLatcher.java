package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HatchLatcher extends SubsystemBase{
    private static HatchLatcher instance; 
    
    private DoubleSolenoid flower; 
    private DoubleSolenoid extender; 
    private static final int FL_ID_1 = 0; 
    private static final int FL_ID_2 = 1; 
    private static final int EX_ID_1 = 2; 
    private static final int EX_ID_2 = 3;
    
    private HatchLatcher(){
        flower = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FL_ID_1, FL_ID_2); 
        extender = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, EX_ID_1, EX_ID_2);
    }
    

    public void flowertoggle(){
        if (flower.get() == DoubleSolenoid.Value.kOff){
            flower.set(DoubleSolenoid.Value.kReverse);
        }
        if (flower.get() == DoubleSolenoid.Value.kReverse){
            flower.set(DoubleSolenoid.Value.kForward);
        }
        if (flower.get() == DoubleSolenoid.Value.kForward){
            flower.set(DoubleSolenoid.Value.kOff);
        }

    }

    public void extendertoggle(){
        if (extender.get() == DoubleSolenoid.Value.kOff){
            extender.set(DoubleSolenoid.Value.kReverse);
        }
        if (extender.get() == DoubleSolenoid.Value.kReverse){
            extender.set(DoubleSolenoid.Value.kForward);
        }
        if (extender.get() == DoubleSolenoid.Value.kForward){
            extender.set(DoubleSolenoid.Value.kOff);
        }

    }


    public static HatchLatcher getInstance(){
        if (instance == null){
            instance = new HatchLatcher();
        }
        return instance;
    }
}
