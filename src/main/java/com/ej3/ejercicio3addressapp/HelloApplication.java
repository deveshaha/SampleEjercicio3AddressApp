package com.ej3.ejercicio3addressapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final String APP_XML = "RootLayout.fxml";
    private static final String USER_MENU_XML = "hello-view.fxml";

    private AnchorPane menu;
    private BorderPane rootLayout;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("AddressApp");
        loadLayouts();
        Scene scene = new Scene(rootLayout);
        stage.setScene(scene);
        stage.show();
    }

    private void loadLayouts() throws IOException {
        rootLayout = new FXMLLoader(HelloApplication.class.getResource("RootLayout.fxml")).load();
        menu = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")).load();

        rootLayout.setCenter(menu);
    }


    public static void main(String[] args) {
        launch();
    }
}