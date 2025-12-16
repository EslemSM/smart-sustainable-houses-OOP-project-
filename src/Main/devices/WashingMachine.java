// WashingMachine.java
package Main.devices;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;

public class WashingMachine extends SmartDevice {
    public WashingMachine(String name) {
        super(name, true);
    }

    @Override
    protected void onTurnOn() {
        System.out.println(name + " is now started (Washing Machine ON).");
    }

    @Override
    protected void onTurnOff() {
        System.out.println(name + " is now stopped (Washing Machine OFF).");
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
