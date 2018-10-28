package Controller;

import View.UpdateView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class UpdateController extends Controller {

    private UpdateView updateView;
    private String currentUser;

    @Override
    public void start() {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            root = fxmlLoader.load(getClass().getResource("Update.fxml").openStream());
            Scene scene = new Scene (root);
            window = new Stage();
            window.setScene(scene);
            window.show();
            window.setTitle("Update");
            updateView = fxmlLoader.getController();
            List<String> list = mainModel.searchUserByUserName(currentUser);
            if (!list.isEmpty()) {
                updateView.setTxtFields(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6));
            }
        }
        catch (IOException e){}
        //signUpView.signUpButton = (Button)root.lookup("#signUpButton");
        updateView.start(new ButtonUpdateClickedHandler());
    }

    public void setCurrentUser(String currentUser){
        this.currentUser=currentUser;
    }

    public class ButtonUpdateClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            if (updateView.filledUpdate()) {
                if (!mainModel.updateUser(updateView.usernameTextBox.getText(),currentUser, updateView.passwordTextBox.getText(), updateView.birthdayDatePicker.getValue().toString(), updateView.firstNameTextBox.getText(),
                        updateView.lastNameTextBox.getText(), updateView.cityTextBox.getText(), updateView.emailTextBox.getText())) {
                    updateView.errorusernameLable.setVisible(true);
                    updateView.errorusernameLable.setText("Username already exists");
                } else {
                    window.close();
                    mainController.signInSuccessfuly(updateView.usernameTextBox.getText());
                    updateView.showAlert("Updated successfully");
                }
            }
        }
    }


}
