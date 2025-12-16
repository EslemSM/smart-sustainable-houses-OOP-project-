// DoorLock.java
package Main.devices;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;

public class DoorLock extends SmartDevice {
    public DoorLock(String name) {
        super(name, false);
    }

    @Override
    protected void onTurnOn() { // locking
        System.out.println(name + " is now LOCKED.");
    }

    @Override
    protected void onTurnOff() { // unlocking
        System.out.println(name + " is now UNLOCKED.");
    }

    @Override
    public String getStatus() {
        return isOn ? "Locked" : "Unlocked";
    }

    @Override
    public double getPowerUsage() {
        if (!isOn) return 0.0;
        // constant draw when locked
        return 0.5;
    }
}
