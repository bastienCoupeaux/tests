package com.test;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label label;

    @FXML
    private void onClick() {
        label.setText("Scene Builder fonctionne !");
    }
}
