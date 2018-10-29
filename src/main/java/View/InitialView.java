package View;

import Controller.InitialController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//import java.awt.*;

public class InitialView {

    @FXML
    public Button signInButton;
    public Button signUpButton;
    public Button signInAsGuest;
    public TextField usernameTextBox;
    public TextField passwordTextBox ;
    public Label invalidLoginLabel ;

    public void start(InitialController.ButtonSignInClickedHandler buttonSignInClickedHandler,
                      InitialController.ButtonSignUpClickedHandler buttonSignUpClickedHandler,
                      InitialController.ButtonSignInAsGuestClickedHandler buttonSignInAsGuestClickedHandler){
        signInButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonSignInClickedHandler);
        signUpButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonSignUpClickedHandler);
        signInAsGuest.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonSignInAsGuestClickedHandler);
        invalidLoginLabel.setVisible(false);
    }

    public boolean checkFieldsEmpty(){
        if(usernameTextBox.getText().equals("") || passwordTextBox.getText().equals(""))
            return true;
        return false;
    }





}
