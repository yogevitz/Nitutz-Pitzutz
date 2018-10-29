package Controller;

import View.InitialView;
import javafx.event.Event;
import javafx.event.EventHandler;

public class InitialController extends Controller {
    private InitialView initialView;

    public InitialController(){
        super("MainViewForm.fxml");
        initialView = fxmlLoader.getController();
        initialView.start(new ButtonSignInClickedHandler(),new ButtonSignUpClickedHandler(),new ButtonSignInAsGuestClickedHandler());

    }


    public void start(){

        window.show();
        window.setTitle("Vacation4U");
        //initialView.signInButton = (Button)root.lookup("#signInButton");
        //initialView.signUpButton = (Button)root.lookup("#signUpButton");
        //initialView.signInAsGuest = (Button)root.lookup("#signInAsGuest");

    }

    public class ButtonSignInClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            initialView.invalidLoginLabel.setVisible(false);

            if (initialView.checkFieldsEmpty() || !mainModel.validateUserNameAndPassword(initialView.usernameTextBox.getText(),initialView.passwordTextBox.getText()))
            {
                initialView.invalidLoginLabel.setVisible(true);
            }
            else
            {
                mainController.signInSuccessfuly(initialView.usernameTextBox.getText());
                initialView.usernameTextBox.setText("");
                initialView.passwordTextBox.setText("");
                window.close();

            }
        }
    }

    public class ButtonSignUpClickedHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.signUp();
        }
    }

    public class ButtonSignInAsGuestClickedHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.signInSuccessfuly("");
        }
    }


}
