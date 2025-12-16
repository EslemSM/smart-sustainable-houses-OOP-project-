// AirConditioner.java
package Main.devices;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;

public class AirConditioner extends SmartDevice {
    public AirConditioner(String name) {
        super(name, true);
    }

    @Override
    protected void onTurnOn() {
        System.out.println(name + " is now running (AC ON).");
    }

    @Override
    protected void onTurnOff() {
        System.out.println(name + " is now stopped (AC OFF).");
    }

    @Override
    public double getPowerUsage() {
        if (!isOn) return 0.0;
        EnergyMode mode = EnergyManager.getInstance().getMode();
        switch(mode) {
            case HIGH:   return 20.0;
            case MEDIUM: return 15.0;
            case ECO:    return 10.0;
        }
        return 0.0;
    }
}
