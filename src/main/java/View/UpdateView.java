package View;

import Controller.UpdateController;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class UpdateView {

    @FXML
    public Button updateButton;
    public TextField usernameTextBox;
    public TextField passwordTextBox;
    public DatePicker birthdayDatePicker;
    public TextField firstNameTextBox;
    public TextField lastNameTextBox;
    public TextField cityTextBox;
    public TextField emailTextBox;
    public Label errorusernameLable;
    public Label errorpasswordLable;
    public Label errorfirstnameLable;
    public Label errorlastnameLable;
    public Label errorcityLable;
    public Label erroremailLable;
    public Label errorbirthdayLable;
    public Label mandatoryFieldsMissing;

  /*
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("wrong user name or password. please try again");
        alert.show();
    }*/

    private boolean missMandatoryField(Label l, TextField t) {
        if (t.getText().equals("")) {
            l.setText("*");
            l.setVisible(true);
            return true;
        }
        return false;
    }

    private void clearErrorLable(Label l) {
        l.setText("");
        l.setVisible(false);
    }

    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public void showAlert(String alertMessage){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(alertMessage);
        alert.show();
    }
    public boolean filledUpdate() {
        mandatoryFieldsMissing.setVisible(false);
        clearErrorLable(errorusernameLable);
        clearErrorLable(errorpasswordLable);
        clearErrorLable(errorfirstnameLable);
        clearErrorLable(errorlastnameLable);
        clearErrorLable(errorcityLable);
        clearErrorLable(errorbirthdayLable);
        clearErrorLable(erroremailLable);
        missMandatoryField(errorusernameLable, usernameTextBox);
        missMandatoryField(errorpasswordLable, passwordTextBox);
        missMandatoryField(errorfirstnameLable, firstNameTextBox);
        missMandatoryField(errorlastnameLable, lastNameTextBox);
        missMandatoryField(errorcityLable, cityTextBox);
        missMandatoryField(erroremailLable, emailTextBox);
        boolean emailBool = true;
        boolean birthdayBool = true;

        if (!isValidEmail(emailTextBox.getText()) && !missMandatoryField(erroremailLable, emailTextBox)){
            erroremailLable.setVisible(true);
            erroremailLable.setText("Invalid email");
            emailBool = false;
        }

        if (birthdayDatePicker.getValue() == null) {
            errorbirthdayLable.setText("*");
            errorbirthdayLable.setVisible(true);
            birthdayBool = false;
        } else {
            LocalDate ld = birthdayDatePicker.getValue();
            if (LocalDate.from(ld).until(LocalDate.now(), ChronoUnit.YEARS) < 18) {
                errorbirthdayLable.setText("The user must be over the age of 18");
                errorbirthdayLable.setVisible(true);
                birthdayBool = false;
            }

        }

        if (!missMandatoryField(errorusernameLable, usernameTextBox) &&
                !missMandatoryField(errorpasswordLable, passwordTextBox) &&
                !missMandatoryField(errorfirstnameLable, firstNameTextBox) &&
                !missMandatoryField(errorlastnameLable, lastNameTextBox) &&
                !missMandatoryField(errorcityLable, cityTextBox) &&
                !missMandatoryField(erroremailLable, emailTextBox) &&
                emailBool && birthdayBool) {
            return true;
        }
        else{
            if(errorusernameLable.getText().equals("*") ||
                    errorpasswordLable.getText().equals("*") ||
                    errorbirthdayLable.getText().equals("*") ||
                    errorfirstnameLable.getText().equals("*") ||
                    errorlastnameLable.getText().equals("*") ||
                    errorcityLable.getText().equals("*") ||
                    erroremailLable.getText().equals("*") )
                mandatoryFieldsMissing.setVisible(true);
            return false;
        }

    }

    public void start(UpdateController.ButtonUpdateClickedHandler buttonUpdateClickedHandler){
        updateButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonUpdateClickedHandler);
    }

    public void setTxtFields(String userName,String password, String birthday, String firstName, String lastName, String city, String email ){
        usernameTextBox.setText(userName);
        passwordTextBox.setText(password);
        birthdayDatePicker.setValue(LocalDate.parse(birthday));
        firstNameTextBox.setText(firstName);
        lastNameTextBox.setText(lastName);
        cityTextBox.setText(city);
        emailTextBox.setText(email);
    }
}
