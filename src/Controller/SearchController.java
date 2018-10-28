package Controller;

import View.SearchView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SearchController extends Controller{

    SearchView searchView;

    @Override
    public void start() {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            root = fxmlLoader.load(getClass().getResource("Search.fxml").openStream());
            Scene scene = new Scene (root);
            window = new Stage();
            window.setScene(scene);
            window.show();
            window.setTitle("Search");
            searchView = fxmlLoader.getController();
        }
        catch (IOException e){}
        //signUpView.signUpButton = (Button)root.lookup("#signUpButton");

        searchView.start(new ButtonSearchUserClickedHandler());
    }

    public class ButtonSearchUserClickedHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            List<String> list = mainModel.searchUserByUserName(searchView.usernameTextBox.getText());
            if (!list.isEmpty()){
               searchView.setTxtFields(list.get(2),list.get(3),list.get(4),list.get(5),list.get(6));
            }
            else{

                searchView.setTxtFields("","","","","");
                searchView.errorUsernameLable.setVisible(true);
            }
        }
    }

    public class ButtonClearDataClickedHandler implements EventHandler{
        @Override
        public void handle(Event event) {

        }
    }
}
