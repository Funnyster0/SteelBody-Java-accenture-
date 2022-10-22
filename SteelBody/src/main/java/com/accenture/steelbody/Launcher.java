package com.accenture.steelbody;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Launcher extends Application
{

    @Override
    public void start(Stage stage)
    {
        try
        {
            String fxmlPath = "/com/accenture/steelbody/fxml/main.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load());
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Such file wasn't found!");
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        launch();
    }
}
