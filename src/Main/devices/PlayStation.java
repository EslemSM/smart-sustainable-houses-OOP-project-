// PlayStation.java
package Main.devices;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;

public class PlayStation extends SmartDevice {
    public PlayStation(String name) {
        super(name, true);
    }

    @Override
    protected void onTurnOn() {
        System.out.println(name + " is now turned ON (PlayStation).");
    }

    @Override
    protected void onTurnOff() {
        System.out.println(name + " is now turned OFF (PlayStation).");
    }

    @Override
    public double getPowerUsage() {
        if (!isOn) return 0.0;
        EnergyMode mode = EnergyManager.getInstance().getMode();
        switch(mode) {
            case HIGH:   return 18.0;
            case MEDIUM: return 12.0;
            case ECO:    return 6.0;
        }
        return 0.0;
    }
}
