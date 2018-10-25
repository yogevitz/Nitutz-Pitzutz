package View;


import Controller.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class MainView{
    private MainController mc = new MainController();


    @FXML
    public javafx.scene.control.Button loginButton;
    public javafx.scene.control.TextField usernameTextBox;
    public javafx.scene.control.TextField passwordTextBox;
    public javafx.scene.control.TextField birthdayTextBox;
    public javafx.scene.control.TextField firstNameTextBox;
    public javafx.scene.control.TextField lastNameTextBox;
    public javafx.scene.control.TextField cityTextBox;
    public javafx.scene.control.TextField emailTextBox;

    public MainController getMainController(){
        return mc;
    }

    public void signUp(){
        try {
            Stage primaryStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("SignUpView.fxml"));
            primaryStage.setTitle("Vacation4U");
            primaryStage.setScene(new Scene(root, 411, 350));
            primaryStage.show();
        }
        catch (Exception e){}
    }



    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("itay");
        alert.show();
    }

    public void filledSignUp(){

    }

}
