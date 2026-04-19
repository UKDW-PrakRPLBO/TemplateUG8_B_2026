package org.rplbo.app.ug8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class UmbrellaApp extends Application {
    private static Stage primaryStage;
    public static String loggedInUser = "";

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        // Aplikasi dimulai dari layar login
        switchScene("login-view.fxml");
        primaryStage.setTitle("Umbrella Corp Terminal v1.1");
        primaryStage.show();
    }

    // Metode statis untuk berpindah halaman
    public static void switchScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(UmbrellaApp.class.getResource(fxml));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public static void main(String[] args) { launch(args); }
}