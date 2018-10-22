package sample;

import Model.MainModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
}


    public static void createNewDatabase(String fileName) {
        // create new data base on the path /Users/galvaitzman/IdeaProjects/NitutzJavaFX/
        String url = "jdbc:sqlite:" + fileName;
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:Vacation4U.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Users(\n"
                + "	User_name varchar(255) NOT NULL PRIMARY KEY,\n"
                + "	Password varchar(255) NOT NULL,\n"
                + "	Birth_day varchar(255) NOT NULL,\n"
                + "	First_name varchar(255) NOT NULL,\n"
                + "	Last_name varchar(255) NOT NULL,\n"
                + "	City varchar(255) NOT NULL,\n"
                + "	Email varchar(255) NOT NULL\n"
                //  + "	Picture BLOB NOT NULL,\n"
                + ");" ;
        //Yogev
        //Gal
        //Liron

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("the table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:Vacation4U.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     * @param User_name
     * @param Password
     * @param Birth_day
     * @param First_name
     * @param Last_name
     * @param City
     */

    public static void insert(String User_name, String Password, String Birth_day, String First_name, String Last_name, String City,String Email) {
        String sql = "INSERT INTO Users(User_name,Password,Birth_day,First_name,Last_name,City,Email) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, User_name);
            pstmt.setString(2, Password);
            pstmt.setString(3, Birth_day);
            pstmt.setString(4, First_name);
            pstmt.setString(5, Last_name);
            pstmt.setString(6, City);
            pstmt.setString(7, Email);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        //launch(args);
        //createNewDatabase("Vacation4U.db");
       // createNewTable();

        // insert three new rows
        MainModel m = new MainModel();
      //  m.createUser("goni", "agj","bgfj", "cjgf", "dgfj","egfj", "galvaitzman@gmail.com");
        m.updateUser("goni", "agj","bgfj", "cjgf", "dgfj","egfj", "gonilevinhaihhhmi@gmail.com");
    }
}
