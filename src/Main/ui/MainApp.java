package Main.ui;

import Main.controller.CentralController;
import Main.energy.*;
import Main.home.*;
import Main.devices.SmartDevice;
import Main.security.*;
import Main.exceptions.DeviceNotFoundException;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.geometry.Insets;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    private static User currentUser;

    public static void launchMainApp(User user) {
        currentUser = user;
        new MainApp().start(new Stage());
    }

    public void start(Stage primaryStage) {

        // Setup core system
        Home home = DemoHomeFactory.createDemoHome();
        SolarPanel solar = new SolarPanel();
        BatteryStorage battery = new BatteryStorage(1000, 500);
        EnergyManager manager = new EnergyManager(solar, battery);
        CentralController controller = new CentralController(home, manager);

        // ✅ Custom exception usage (safe demo)
        try {
            SmartDevice demoDevice = home.getDeviceByName("Kitchen Light");
            demoDevice.turnOn();
        } catch (DeviceNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Energy panel
        Label batteryStatusLabel = new Label();
        Label solarStatusLabel = new Label();
        Label modeStatusLabel = new Label();
        HBox energyBox = new HBox(15, batteryStatusLabel, solarStatusLabel, modeStatusLabel);
        energyBox.setPadding(new Insets(5));

        // Global device section
        VBox globalBox = new VBox(5);
        TitledPane globalPane = new TitledPane("Global Devices", globalBox);
        VBox roomsBox = new VBox(10);
        ScrollPane scrollPane = new ScrollPane(roomsBox);
        scrollPane.setFitToWidth(true);

        List<Label> allModeLabels = new ArrayList<>();

        // Add global devices
        for (SmartDevice d : home.getGlobalDevices()) {
            if (currentUser.canAccessDevice(d)) {
                HBox ctrl = createDeviceControl(d);
                globalBox.getChildren().add(ctrl);
                allModeLabels.add((Label) ctrl.getChildren().get(3));
            }
        }

        // Add per-room devices
        for (Room room : home.getRooms()) {
            VBox devList = new VBox(5);
            for (SmartDevice d : room.getDevices()) {
                if (currentUser.canAccessDevice(d)) {
                    HBox ctrl = createDeviceControl(d);
                    devList.getChildren().add(ctrl);
                    allModeLabels.add((Label) ctrl.getChildren().get(3));
                }
            }
            if (!devList.getChildren().isEmpty()) {
                roomsBox.getChildren().add(new TitledPane(room.getName(), devList));
            }
        }

        // Layout
        VBox root = new VBox(
                10,
                new Label("Welcome: " + currentUser.getName()),
                energyBox,
                globalPane,
                scrollPane
        );
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 800, 600);

        // Load CSS
        scene.getStylesheets().add(
                getClass().getResource("style.css").toExternalForm()
        );

        primaryStage.setScene(scene);
        primaryStage.setTitle("Smart Sustainable Home");
        primaryStage.show();

        // Energy and automation refresh
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), ev -> {

                    double generated = solar.generateEnergy();
                    battery.charge(generated);

                    double totalUsage = 0;
                    for (SmartDevice d : home.getAllDevices()) {
                        totalUsage += d.getPowerUsage();
                    }
                    battery.discharge(totalUsage);
                    manager.decideMode();

                    // Update UI
                    batteryStatusLabel.setText(
                            String.format("Battery: %.2f%%", battery.getChargePercent())
                    );
                    solarStatusLabel.setText(
                            String.format("Solar Output: %.2f", solar.getCurrentOutput())
                    );
                    modeStatusLabel.setText("Mode: " + manager.getMode());

                    for (Label lbl : allModeLabels) {
                        lbl.setText(manager.getMode().toString());
                    }

                    // Apply automation rules
                    controller.tick(LocalTime.now(), currentUser);
                })
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    // Device display with ON/OFF and energy mode
    private HBox createDeviceControl(SmartDevice device) {

        Label nameLabel = new Label(device.getName());
        Label stateLabel = new Label(device.getStatus());
        Label modeLabel = new Label(
                EnergyManager.getInstance().getMode().toString()
        );

        Button toggleButton = new Button(
                device.isOn() ? "Turn Off" : "Turn On"
        );

        toggleButton.setOnAction(e -> {
            if (device.isOn()) device.turnOff();
            else device.turnOn();

            stateLabel.setText(device.getStatus());
            toggleButton.setText(
                    device.isOn() ? "Turn Off" : "Turn On"
            );
        });

        HBox box = new HBox(10, nameLabel, toggleButton, stateLabel, modeLabel);
        box.setPadding(new Insets(5));
        box.setSpacing(10);

        return box;
    }
}
