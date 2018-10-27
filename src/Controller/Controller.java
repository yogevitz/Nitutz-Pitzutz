package Controller;

import Model.MainModel;
import javafx.stage.Stage;

public abstract class Controller{
    protected static MainModel mainModel;
    protected static MainController mainController;
    protected Stage window = new Stage();

    public static void setMainController (MainController other){
        mainController = other;
    }

    public static void setMainModel (MainModel other){
        mainModel = other;
    }

    public abstract void start();

}
