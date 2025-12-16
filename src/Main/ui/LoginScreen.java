package Main.ui;

import Main.security.User;
import Main.security.UserAuthService;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("Smart Sustainable Home - Login");
        Label userLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        Label statusLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim().toLowerCase();
            String password = passwordField.getText().trim();

            User user = UserAuthService.authenticate(username, password);

            if (user != null) {
                System.out.println("✅ Login successful: " + user.getName());
                MainApp.launchMainApp(user);
                primaryStage.close();
            } else {
                statusLabel.setText("❌ Invalid credentials. Try again.");
            }
        });

        VBox layout = new VBox(10,
                titleLabel,
                userLabel, usernameField,
                passLabel, passwordField,
                loginButton,
                statusLabel);

        layout.setPadding(new javafx.geometry.Insets(20));

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}