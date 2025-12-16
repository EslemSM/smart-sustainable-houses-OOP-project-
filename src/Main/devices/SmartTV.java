// SmartTV.java
package Main.devices;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;

public class SmartTV extends SmartDevice {
    public SmartTV(String name) {
        super(name, false);
    }

    @Override
    protected void onTurnOn() {
        System.out.println(name + " is turned ON (TV).");
    }

    @Override
    protected void onTurnOff() {
        System.out.println(name + " is turned OFF (TV).");
    }

    @Override
    public double getPowerUsage() {
        if (!isOn) return 0.0;
        EnergyMode mode = EnergyManager.getInstance().getMode();
        switch(mode) {
            case HIGH:   return 15.0;
            case MEDIUM: return 10.0;
            case ECO:    return 5.0;
        }
        return 0.0;
    }
}
