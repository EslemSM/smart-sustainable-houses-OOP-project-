// SecurityAlarm.java
package Main.devices;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;

public class SecurityAlarm extends SmartDevice {
    public SecurityAlarm(String name) {
        super(name, false);
    }

    @Override
    protected void onTurnOn() { // arming
        System.out.println(name + " is now ARMED.");
    }

    @Override
    protected void onTurnOff() { // disarming
        System.out.println(name + " is now DISARMED.");
    }

    @Override
    public String getStatus() {
        return isOn ? "Armed" : "Disarmed";
    }

    @Override
    public double getPowerUsage() {
        if (!isOn) return 0.0;
        EnergyMode mode = EnergyManager.getInstance().getMode();
        switch(mode) {
            case HIGH:   return 3.0;
            case MEDIUM: return 2.0;
            case ECO:    return 1.0;
        }
        return 0.0;
    }
}
