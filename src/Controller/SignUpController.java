package Controller;

import View.SignUpView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController extends Controller{
    private SignUpView signUpView;

    public void start(){
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            root = fxmlLoader.load(getClass().getResource("SignUpView.fxml").openStream());
            Scene scene = new Scene (root);
            window = new Stage();
            window.setScene(scene);
            window.show();
            signUpView = fxmlLoader.getController();
        }
        catch (IOException e){}
        signUpView.signUpButton = (Button)root.lookup("#signUpButton");
        signUpView.start(new ButtonSignUpClickedHandler());
    }

    public class ButtonSignUpClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            if (signUpView.filledSignUp()){
                if(!mainModel.createUser(signUpView.usernameTextBox.getText(),signUpView.passwordTextBox.getText(),signUpView.birthdayDatePicker.getValue().toString(),signUpView.firstNameTextBox.getText(),
                        signUpView.lastNameTextBox.getText(), signUpView.cityTextBox.getText(), signUpView.emailTextBox.getText()))
                {
                    signUpView.errorusernameLable.setVisible(true);
                    signUpView.errorusernameLable.setText("Username already exists");
                }
                else{
                    window.close();
                    mainController.signInSuccessfuly(signUpView.usernameTextBox.getText());
                    signUpView.showAlert("Sign up successfuly");


                }
            }

        }
    }
}
