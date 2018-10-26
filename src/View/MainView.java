package View;


import Controller.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class MainView {
    private MainController mc = new MainController();

    @FXML
    public javafx.scene.control.Button loginButton;
    public javafx.scene.control.TextField usernameTextBox;
    public javafx.scene.control.TextField passwordTextBox;
    public javafx.scene.control.DatePicker birthdayDatePicker;
    public javafx.scene.control.TextField firstNameTextBox;
    public javafx.scene.control.TextField lastNameTextBox;
    public javafx.scene.control.TextField cityTextBox;
    public javafx.scene.control.TextField emailTextBox;
    public javafx.scene.control.Label errorusernameLable;
    public javafx.scene.control.Label errorpasswordLable;
    public javafx.scene.control.Label errorfirstnameLable;
    public javafx.scene.control.Label errorlastnameLable;
    public javafx.scene.control.Label errorcityLable;
    public javafx.scene.control.Label erroremailLable;
    public javafx.scene.control.Label errorbirthdayLable;


    public MainController getMainController() {
        return mc;
    }

    public void signUp() {
        try {

            Stage primaryStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("SignUpView.fxml"));
            primaryStage.setTitle("Vacation4U");
            primaryStage.setScene(new Scene(root, 411, 350));
            primaryStage.show();
        } catch (Exception e) {
        }
    }


    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("itay");
        alert.show();
    }

    private boolean missMandatoryField(Label l, TextField t) {
        if (t.getText().equals("")) {
            l.setText("Mandatory field miss");
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

    public void filledSignUp() {


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
        boolean emailBool=true;
        boolean birthdayBool=true;

        if(!isValidEmail(emailTextBox.getText()))
        {
            erroremailLable.setVisible(true);
            erroremailLable.setText("Invalid email");
            emailBool=false;
        }

        if(birthdayDatePicker.getValue()==null)
        {
            errorbirthdayLable.setText("Mandatory field miss");
            errorbirthdayLable.setVisible(true);
            birthdayBool=false;
        }
        else {
            LocalDate ld = birthdayDatePicker.getValue();
            if (LocalDate.from(ld).until(LocalDate.now(), ChronoUnit.YEARS) < 18) {
                errorbirthdayLable.setText("The user must be over the age of 18");
                errorbirthdayLable.setVisible(true);
                birthdayBool=false;
            }

        }

        if(     !missMandatoryField(errorusernameLable, usernameTextBox) &&
                !missMandatoryField(errorpasswordLable, passwordTextBox)&&
                !missMandatoryField(errorfirstnameLable, firstNameTextBox)&&
                !missMandatoryField(errorlastnameLable, lastNameTextBox)&&
                !missMandatoryField(errorcityLable, cityTextBox)&&
                !missMandatoryField(erroremailLable, emailTextBox)&&
                emailBool && birthdayBool)
        {
            mc.createUser(usernameTextBox.getText(),passwordTextBox.getText(),birthdayDatePicker.getValue().toString(),firstNameTextBox.getText(),lastNameTextBox.getText(),cityTextBox.getText(),emailTextBox.getText());

        }
        // missMandatoryField(errorpasswordLable);
        //missMandatoryField(errorfirstnameLable);
        //missMandatoryField(errorlastnameLable);
        //missMandatoryField(errorcityLable);

        //missMandatoryField(erroremailLable,emailTextBox);
        //if(!missMandatoryField(errorbirthdayLable,emailTextBox)){
        //  System.out.println(birthdayDatePicker.getValue());
        //LocalDate ld = birthdayDatePicker.getValue();
        //if(LocalDate.from(ld).until(LocalDate.now(), ChronoUnit.YEARS)<18)
        //{
        //  errorbirthdayLable.setText("The user must be over the age of 18");
        //errorbirthdayLable.setVisible(true);
        // }
    }

}
