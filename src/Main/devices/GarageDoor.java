// GarageDoor.java
package Main.devices;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;

public class GarageDoor extends SmartDevice {
    public GarageDoor(String name) {
        super(name, false);
    }

    @Override
    protected void onTurnOn() {
        System.out.println(name + " is now OPEN.");
    }

    @Override
    protected void onTurnOff() {
        System.out.println(name + " is now CLOSED.");
    }

    @Override
    public double getPowerUsage() {
        if (!isOn) return 0.0;
        EnergyMode mode = EnergyManager.getInstance().getMode();
        switch(mode) {
            case HIGH:   return 5.0;
            case MEDIUM: return 4.0;
            case ECO:    return 2.0;
        }
        return 0.0;
    }
}
