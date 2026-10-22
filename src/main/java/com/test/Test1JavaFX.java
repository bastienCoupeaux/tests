package com.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test1JavaFX {

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    public static class App extends Application {
        @Override
        public void start(Stage stage) {
            Label label = new Label("JavaFX " + System.getProperty("javafx.version")
                    + " sur Java " + System.getProperty("java.version") + " Voila le test");
            stage.setScene(new Scene(new StackPane(label), 400, 200));
            stage.setTitle("Test 1 - JavaFX");
            stage.show(); // hfhfhffhf
        }
    }
}
