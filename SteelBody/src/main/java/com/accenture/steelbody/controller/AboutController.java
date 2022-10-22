package com.accenture.steelbody.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AboutController {
    @FXML
    private void ReturnMain(ActionEvent event) {
        SwapScene.swapScene(event, "/com/accenture/steelbody/fxml/main.fxml");
    }
}
