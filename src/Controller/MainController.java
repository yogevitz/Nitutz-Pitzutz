package Controller;

import Model.MainModel;

public class MainController{
    MainModel model;

    public void setMainModel(MainModel model){
        this.model = model;
    }

    public boolean signIn(String user_name, String password){
        return true;
    }
    public boolean createUser (String user_name, String password, String birth_day, String first_name, String last_name, String city, String email) {
        return model.createUser(user_name, password, birth_day, first_name, last_name, city, email);
    }

}
