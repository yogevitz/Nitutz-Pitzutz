package View;

import Controller.SearchController;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;


public class SearchView {

    public Button searchButton;
    public TextField usernameTextBox;
    public DatePicker birthdayDatePicker;
    public TextField firstNameTextBox;
    public TextField lastNameTextBox;
    public TextField cityTextBox;
    public TextField emailTextBox;
    public Label errorUsernameLable;



    public void start(SearchController.ButtonSearchUserClickedHandler buttonSearchUserClickedHandler){
        searchButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonSearchUserClickedHandler);
    }

    public void setTxtFields(String birthday, String firstName, String lastName, String city, String email ){
        errorUsernameLable.setVisible(false);
        if (!birthday.equals(""))
            birthdayDatePicker.setValue(LocalDate.parse(birthday));
        else
            birthdayDatePicker.setValue(null);
        firstNameTextBox.setText(firstName);
        lastNameTextBox.setText(lastName);
        cityTextBox.setText(city);
        emailTextBox.setText(email);
    }

}
