package frc.robot;

import frc.robot.commands.ToggleExtender;
import frc.robot.commands.ToggleFlower;
import frc.robot.commands.ToggleIntake;
import harkerrobolib.wrappers.XboxGamepad;

public class OI{
    private static OI instance; 
    
    private  XboxGamepad driver; 
    private int ID = 0; 
    private OI(){
        driver = new XboxGamepad(ID); 
        initBindings();
    } 
    public static OI getInstance(){
        if (instance == null){
            instance = new OI();
        }
        return instance;
    }
    public XboxGamepad getDriver(){
        return driver;  
    }

    public void initBindings(){
        driver.getButtonA().whenPressed(new ToggleIntake());
        driver.getButtonB().whenPressed(new ToggleFlower()); 
        driver.getButtonX().whenPressed(new ToggleExtender()); 

    }
    
}