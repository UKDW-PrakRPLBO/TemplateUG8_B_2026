package org.rplbo.app.ug8.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import org.rplbo.app.ug8.UmbrellaApp;
import org.rplbo.app.ug8.UmbrellaDBManager;

public class LoginController {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblStatus;

    @FXML
    private void handleLogin(ActionEvent event) {
        String user = txtUsername.getText();
        String pass = txtPassword.getText();

        UmbrellaDBManager db = new UmbrellaDBManager();
        String fullName = db.validateUser(user, pass);

        if (fullName != null) {
            // Simpan nama user ke "Session" global di App
            UmbrellaApp.loggedInUser = fullName;
            try {
                UmbrellaApp.switchScene("umbrella-view.fxml");
            } catch (Exception e) { e.printStackTrace(); }
        } else {
            lblStatus.setText("AUTHENTICATION FAILED: UNKNOWN ENTITY");
        }
    }
}