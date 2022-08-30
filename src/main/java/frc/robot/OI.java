// Imports and package
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

// Class
public class OI {
    // Class specific constants
    private static final int DRIVE_THROTTLE_AXIS = 1;
    private static final int DRIVE_TURN_AXIS = 2;
    private static final double POWER = 5;

    private static OI oi;
    private XboxController controller;

    private OI() { // This runs on class init
        controller = new XboxController(Constants.CONTROLLER_PORT);
    }

    public XboxController getController() {
        return controller;
    }

    public double getThrottleAxis() {
        return -Math.pow(controller.getRawAxis(DRIVE_THROTTLE_AXIS), POWER);   
    }

    public double getTurnAxis() {
        return Math.pow(controller.getRawAxis(DRIVE_TURN_AXIS), POWER);
    }

    /* Singleton: if you call OI object, this methos will use an object that already exists,
    and if none exists it will create a new instance of the object. Now you can say "getInstance"
    instead of creating a new instance every time you need one (Copied)*/
    public static OI getInstance() {
        if (oi == null) oi = new OI(); // This does work as an 'if' statement
        return oi;
    }
}
