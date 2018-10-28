package Controller;

import Model.MainModel;

public class MainController{

    Controller initialController = new InitialController();
    Controller signUpController = new SignUpController();
    Controller afterSignInController = new AfterSignInController();
    Controller searchController = new SearchController();
    Controller updateController = new UpdateController();
    Controller currentController = initialController;
    Controller previousController = null;

    public MainController (){
        Controller.setMainController(this);
        Controller.setMainModel(new MainModel());
        currentController.start();
    }

    public void signInSuccessfuly(String user_name){
        ((AfterSignInController)afterSignInController).setCurrentUser(user_name);
        previousController = currentController;
        currentController = afterSignInController;
        currentController.start();
    }

    public void signUp(){
        signUpController.start();
    }

    public void update(String userName){
        ((UpdateController)updateController).setCurrentUser(userName);
        updateController.start();
    }

    public void search(){
        searchController.start();
    }

    public void delete(){
        System.out.println("delete oved");
    }

}
