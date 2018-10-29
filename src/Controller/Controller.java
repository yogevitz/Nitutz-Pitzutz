package Controller;

import Model.MainModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller{
    protected static MainModel mainModel;
    protected static MainController mainController;
    protected Stage window = new Stage();
    Parent root = null;
    FXMLLoader fxmlLoader = new FXMLLoader();
    Scene scene;

    public static void setMainController (MainController other){
        mainController = other;
    }

    public static void setMainModel (MainModel other){
        mainModel = other;
    }

    public abstract void start();

    public Controller(String fxml){
        try {
            root = fxmlLoader.load(getClass().getResource(fxml).openStream());
            scene = new Scene (root);
            window.setScene(scene);
        }
        catch (IOException e){e.printStackTrace();}
    }

}
