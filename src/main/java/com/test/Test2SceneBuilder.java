package com.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test2SceneBuilder {

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    public static class App extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("/hello.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Test 2 - Scene Builder");
            stage.show();
        }
    }
}
