package Controller;

import View.SignUpView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class SignUpController extends Controller{
    private SignUpView signUpView;

    public SignUpController(){
        super("SignUpView.fxml");
        signUpView = fxmlLoader.getController();
        signUpView.start(new ButtonSignUpClickedHandler());
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                mainController.activeInitialController();
            }
        });
    }
    public void start(){
        window.show();
        window.setTitle("Sign Up");
        //signUpView.signUpButton = (Button)root.lookup("#signUpButton");

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
                    signUpView.errorusernameLable.setText("Already exists");
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
