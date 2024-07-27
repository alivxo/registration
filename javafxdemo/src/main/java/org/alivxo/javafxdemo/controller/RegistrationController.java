package org.alivxo.javafxdemo.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.alivxo.javafxdemo.service.RegistrationService;


public class RegistrationController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    private final RegistrationService registrationService;

    public RegistrationController() {
        this.registrationService = new RegistrationService();
    }

    @FXML
    public void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();

        if (username == null || username.isEmpty() || password == null || password.isEmpty() || email == null || email.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Registration Failed", "All fields are required.");
            return;
        }

        try {
            if (registrationService.register(username, password, email)) {
                showAlert(Alert.AlertType.INFORMATION, "Registration Successful", "User registered successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Registration Failed", "Could not register user. Username or email may already be taken.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Registration Failed", "An error occurred while registering the user.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}



