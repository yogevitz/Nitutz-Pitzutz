package View;

import Controller.AfterSignInController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AfterSignInView {

    @FXML
    public Button updateMyUserButton;
    public Button searchUserButton;
    public Button deleteMyUserButton;
    public Label userNameLable;

    public void start(AfterSignInController.ButtonUpdateMyUserClickedHandler buttonUpdateMyUserClickedHandler,
                      AfterSignInController.ButtonSearchUserClickedHandler buttonSearchUserClickedHandler,
                      AfterSignInController.ButtonDeleteClickedHandler buttonDeleteClickedHandler){
        updateMyUserButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonUpdateMyUserClickedHandler);
        searchUserButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonSearchUserClickedHandler);
        deleteMyUserButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonDeleteClickedHandler);
    }

    public void showAlert(String alertMessage){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(alertMessage);
        alert.show();
    }









}
