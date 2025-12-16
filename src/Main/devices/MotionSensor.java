// MotionSensor.java
package Main.devices;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;

public class MotionSensor extends SmartDevice {
    public MotionSensor(String name) {
        super(name, false);
    }

    @Override
    protected void onTurnOn() {
        System.out.println(name + " is activated (MotionSensor ON).");
    }

    @Override
    protected void onTurnOff() {
        System.out.println(name + " is deactivated (MotionSensor OFF).");
    }

    @Override
    public double getPowerUsage() {
        if (!isOn) return 0.0;
        EnergyMode mode = EnergyManager.getInstance().getMode();
        switch(mode) {
            case HIGH:   return 1.0;
            case MEDIUM: return 1.0;
            case ECO:    return 0.5;
        }
        return 0.0;
    }
}
