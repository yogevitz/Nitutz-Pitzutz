package Controller;

import Model.MainModel;

public class MainController{
    MainModel model = new MainModel();

    public void setMainModel(MainModel model){
        this.model = model;
    }

    public boolean signIn(String user_name, String password){
        return model.validateUserNameAndPassword(user_name,password);
    }
    public boolean createUser (String user_name, String password, String birth_day, String first_name, String last_name, String city, String email) {
        //System.out.println(user_name);
        //System.out.println(password);
        //System.out.println(birth_day);
        //System.out.println(first_name);
        //System.out.println(last_name);
        //System.out.println(city);
        //System.out.println(email);
        return model.createUser(user_name, password, birth_day, first_name, last_name, city, email);
    }

}
