// EnergyManager.java
package Main.energy;

public class EnergyManager {
    private static EnergyManager instance;
    private SolarPanel solarPanel;
    private BatteryStorage battery;
    private EnergyMode mode;

    public EnergyManager(SolarPanel solarPanel, BatteryStorage battery) {
        this.solarPanel = solarPanel;
        this.battery = battery;
        this.mode = EnergyMode.MEDIUM;
        instance = this;
    }

    public static EnergyManager getInstance() {
        return instance;
    }

    public BatteryStorage getBattery() {
        return battery;
    }

    public SolarPanel getSolarPanel() {
        return solarPanel;
    }

    public EnergyMode getMode() {
        return mode;
    }

    // Decide the current energy mode based on battery level
    public void decideMode() {
        double percent = battery.getChargePercent();
        EnergyMode newMode = mode;
        if (percent > 70) {
            newMode = EnergyMode.HIGH;
        } else if (percent < 40) {
            newMode = EnergyMode.ECO;
        } else {
            newMode = EnergyMode.MEDIUM;
        }
        if (newMode != mode) {
            mode = newMode;
            System.out.println("Energy mode changed to: " + mode);
        }
    }
}
