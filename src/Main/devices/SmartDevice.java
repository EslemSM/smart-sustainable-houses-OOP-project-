// SmartDevice.java
package Main.devices;
import Main.energy.EnergyManager;

public abstract class SmartDevice {
    protected String name;
    protected boolean isOn;
    protected boolean highConsumption;

    public SmartDevice(String name, boolean highConsumption) {
        this.name = name;
        this.highConsumption = highConsumption;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getStatus() {
        if (isOn) {
            return "ON";
        }
        return "OFF";
    }

    public void turnOn() {
        if (isOn) return;
        EnergyManager manager = EnergyManager.getInstance();
        if (highConsumption && manager.getBattery().getChargePercent() < 20) {
            System.out.println("Cannot turn on " + name + ". Battery too low.");
            return;
        }
        isOn = true;
        onTurnOn();
    }

    public void turnOff() {
        if (!isOn) return;
        isOn = false;
        onTurnOff();
    }

    protected abstract void onTurnOn();
    protected abstract void onTurnOff();
    public abstract double getPowerUsage();
}
