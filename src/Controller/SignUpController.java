package Controller;

import View.SignUpView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
            window.setTitle("Sign Up");
            signUpView = fxmlLoader.getController();
            signUpView.signUpButton.setText("Sign Up");
        }
        catch (IOException e){}
        //signUpView.signUpButton = (Button)root.lookup("#signUpButton");
        signUpView.start(new ButtonSignUpClickedHandler());
    }

    /*
    public void update(String userName){
        start();
        signUpView.signUpButton.setText("Update");
        List<String> list = mainModel.searchUserByUserName(userName);
        if (!list.isEmpty()){
            signUpView.setTxtFields(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6));
        }
        else{
           signUpView.setTxtFields("","","","","","","");
        }
    }
    */

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
                    signUpView.showAlert("Sign up successfully");


                }
            }

        }
    }
}
