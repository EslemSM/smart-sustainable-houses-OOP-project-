// Light.java
package Main.devices;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;

public class Light extends SmartDevice {
    public Light(String name) {
        super(name, false);
    }

    @Override
    protected void onTurnOn() {
        System.out.println(name + " is turned ON.");
    }

    @Override
    protected void onTurnOff() {
        System.out.println(name + " is turned OFF.");
    }

    @Override
    public double getPowerUsage() {
        if (!isOn) return 0.0;
        EnergyMode mode = EnergyManager.getInstance().getMode();
        switch(mode) {
            case HIGH:   return 5.0;
            case MEDIUM: return 3.0;
            case ECO:    return 1.0;
        }
        return 0.0;
    }
}
