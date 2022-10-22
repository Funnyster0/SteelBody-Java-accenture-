package com.accenture.steelbody.controller;
import com.accenture.steelbody.Launcher;
import com.accenture.steelbody.container.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.EventObject;

public class SwapScene
{
    public static void swapScene(EventObject event, String fxmlFile)
    {
        try
        {
            FXMLLoader fxmlloader = new FXMLLoader(Launcher.class.getResource(fxmlFile));
            Scene scene = new Scene(fxmlloader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Such file wasn't found!");
        }
    }

}
