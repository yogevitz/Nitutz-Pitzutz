package Controller;

import View.InitialView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class InitialController extends Controller {
    private InitialView initialView;



    public void start(){

        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            root = fxmlLoader.load(getClass().getResource("MainViewForm.fxml").openStream());
            Scene scene = new Scene (root);
            window.setScene(scene);
            window.show();
            window.setTitle("Vacation4U");
            initialView = fxmlLoader.getController();
        }
        catch (IOException e){}
        //initialView.signInButton = (Button)root.lookup("#signInButton");
        //initialView.signUpButton = (Button)root.lookup("#signUpButton");
        //initialView.signInAsGuest = (Button)root.lookup("#signInAsGuest");
        initialView.start(new ButtonSignInClickedHandler(),new ButtonSignUpClickedHandler(),new ButtonSignInAsGuestClickedHandler());

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
                window.close();
                mainController.signInSuccessfuly(initialView.usernameTextBox.getText());
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
