// Thermostat.java
package Main.devices;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;

public class Thermostat extends SmartDevice {
    public Thermostat(String name) {
        super(name, false);
    }

    @Override
    protected void onTurnOn() {
        System.out.println(name + " is activated (Thermostat ON).");
    }

    @Override
    protected void onTurnOff() {
        System.out.println(name + " is deactivated (Thermostat OFF).");
    }

    @Override
    public double getPowerUsage() {
        if (!isOn) return 0.0;
        EnergyMode mode = EnergyManager.getInstance().getMode();
        switch(mode) {
            case HIGH:   return 10.0;
            case MEDIUM: return 7.0;
            case ECO:    return 3.0;
        }
        return 0.0;
    }
}
