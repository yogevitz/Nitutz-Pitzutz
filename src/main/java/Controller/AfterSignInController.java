package Controller;

import View.AfterSignInView;
import javafx.event.Event;
import javafx.event.EventHandler;

public class AfterSignInController extends Controller {
    private AfterSignInView afterSignInView;
    private String currentUser="";
    int x=4;

    public AfterSignInController(){
        super("AfterSignIn2.fxml");
        afterSignInView = fxmlLoader.getController();
        afterSignInView.start(new ButtonUpdateMyUserClickedHandler(),new ButtonSearchUserClickedHandler(),new ButtonDeleteClickedHandler());

    }
    @Override
    public void start() {
        window.show();
        window.setTitle("Vacation4U");

        if (currentUser.equals(""))
        {
            afterSignInView.deleteMyUserButton.setVisible(false);
            afterSignInView.updateMyUserButton.setVisible(false);
            afterSignInView.userNameLable.setText("Guest");
        }
        else afterSignInView.userNameLable.setText(currentUser);
        //afterSignInView.updateMyUserButton = (Button)root.lookup("#updateMyUserButton");
        //afterSignInView.searchUserButton = (Button)root.lookup("#searchUserButton");
        //afterSignInView.deleteMyUserButton = (Button)root.lookup("#deleteMyUserButton");



    }

    public void setCurrentUser(String currentUser){
        this.currentUser=currentUser;
    }

    public class ButtonUpdateMyUserClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            //window.close();
            mainController.update(afterSignInView.userNameLable.getText());
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
            mainModel.delete(currentUser);
            window.close();
            mainController.activeInitialController();
            afterSignInView.showAlert("The user has been deleted");
        }
    }

    public String getCurrentUser(){
        return currentUser;
    }
}
