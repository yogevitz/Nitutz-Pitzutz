package Controller;

import View.AfterSignInView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class AfterSignInController extends Controller {
    private AfterSignInView afterSignInView;
    private String currentUser="";

    @Override
    public void start() {

        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            root = fxmlLoader.load(getClass().getResource("AfterSignIn2.fxml").openStream());
            Scene scene = new Scene (root);
            window.setScene(scene);
            window.show();
            window.setTitle("Vacation4U");
            afterSignInView = fxmlLoader.getController();
            if (currentUser.equals(""))
            {
                afterSignInView.userNameLable.setText("Guest");
                //afterSignInView.
            }
            else afterSignInView.userNameLable.setText(currentUser);
            //afterSignInView.updateMyUserButton = (Button)root.lookup("#updateMyUserButton");
            //afterSignInView.searchUserButton = (Button)root.lookup("#searchUserButton");
            //afterSignInView.deleteMyUserButton = (Button)root.lookup("#deleteMyUserButton");
            afterSignInView.start(new ButtonUpdateMyUserClickedHandler(),new ButtonSearchUserClickedHandler(),new ButtonDeleteClickedHandler());
        }
        catch(IOException e) {}


    }

    public void setCurrentUser(String currentUser){
        this.currentUser=currentUser;
    }

    public class ButtonUpdateMyUserClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            //window.close();
            mainController.update(currentUser);
        }
    }

    public class ButtonSearchUserClickedHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            //window.close();
            mainController.search();
        }
    }

    public class ButtonDeleteClickedHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            //window.close();
            mainController.delete();
        }
    }

    public String getCurrentUser(){
        return currentUser;
    }
}
