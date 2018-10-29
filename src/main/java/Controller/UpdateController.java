package Controller;

import View.UpdateView;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.List;

public class UpdateController extends Controller {

    private UpdateView updateView;
    private String currentUser;

    public UpdateController(){
        super("Update.fxml");
        updateView = fxmlLoader.getController();
        updateView.start(new ButtonUpdateClickedHandler());
    }
    @Override
    public void start() {
        window.show();
        window.setTitle("Update");
        List<String> list = mainModel.searchUserByUserName(currentUser);
        if (!list.isEmpty()) {
            updateView.setTxtFields(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6));
        }
        //signUpView.signUpButton = (Button)root.lookup("#signUpButton");

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

                    mainController.signInSuccessfuly(updateView.usernameTextBox.getText());
                    updateView.showAlert("Updated successfully");
                    window.close();
                }
            }
        }
    }


}
