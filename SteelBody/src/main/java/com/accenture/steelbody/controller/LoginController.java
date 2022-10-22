package com.accenture.steelbody.controller;

import com.accenture.steelbody.DatabaseWorker;
import com.accenture.steelbody.Status;
import com.accenture.steelbody.container.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class LoginController {

    @FXML
    private TextField email;
    @FXML
    private  PasswordField password1;
    @FXML
    private  TextField name;
    @FXML
    private  PasswordField password;

    @FXML
    void ReturnMain(ActionEvent event) {
        SwapScene.swapScene(event, "/com/accenture/steelbody/fxml/main.fxml");
    }

    @FXML
    void onEnter(ActionEvent event) {
        SwapScene.swapScene(event, "/com/accenture/steelbody/fxml/enter.fxml");
    }

    @FXML
    void onLogin(ActionEvent event) {
        if (password.getText().equals(password1.getText()))
        {
            User currentUser = new User();
            currentUser.setName(name.getText());
            currentUser.setEmail(email.getText());
            currentUser.setPassword(password.getText());
            Status.STATUS = currentUser.getStatus();
            Status.NAME = currentUser.getName();
            Status.ID = currentUser.getId();
            DatabaseWorker dbw = new DatabaseWorker();
            if (dbw.open()) {
                dbw.insert(currentUser);
                dbw.close();
            }
            System.out.println("Welcome, " + currentUser.getName() + "!");
            SwapScene.swapScene(event, "/com/accenture/steelbody/fxml/main.fxml");
        }
    }
}
