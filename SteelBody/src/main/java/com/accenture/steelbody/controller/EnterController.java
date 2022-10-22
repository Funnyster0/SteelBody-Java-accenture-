package com.accenture.steelbody.controller;

import com.accenture.steelbody.DatabaseWorker;
import com.accenture.steelbody.Launcher;
import com.accenture.steelbody.Status;
import com.accenture.steelbody.container.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class EnterController {

    @FXML
    private Button Login;

    @FXML
    private TextField login;

    @FXML
    private Button mainButton;

    @FXML
    private PasswordField password;

    @FXML
    void ReturnMain(ActionEvent event) {
        SwapScene.swapScene(event, "/com/accenture/steelbody/fxml/main.fxml");
    }

    @FXML
    void onLogin(ActionEvent event) {
        SwapScene.swapScene(event, "/com/accenture/steelbody/fxml/login.fxml");
    }

    @FXML
    void onEnter(ActionEvent event) {
        DatabaseWorker dbw = new DatabaseWorker();
        if (dbw.open())
        {
            ArrayList<User> data = dbw.onEnterQuery();
            dbw.close();
            String loginData = login.getText();
            String passData = password.getText();
            User currentUser = null;
            boolean verified = false;
            for (User i : data) {
                if (loginData.equals(i.getEmail()) && passData.equals(i.getPassword())) {
                    verified = true;
                    currentUser = i;
                    break;
                }
            }
            if (verified)
            {
                Status.STATUS = currentUser.getStatus();
                Status.NAME = currentUser.getName();
                Status.ID = currentUser.getId();
                System.out.println("Welcome, " + currentUser.getName() + "!");
                SwapScene.swapScene(event, "/com/accenture/steelbody/fxml/main.fxml");
            }
            else
            {
                System.out.println("No such account! Please, try again!");
            }
        }
        else
        {
            System.out.println("Query failed!");
        }

    }
}
