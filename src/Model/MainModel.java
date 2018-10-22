package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class MainModel {
    Map<String, String> users_passwords_Dic = new HashMap<String, String>();
    Map<String, User> users_Dic = new HashMap<String, User>();
    public void createUser(String user_name, String password, String birth_day, String first_name, String last_name, String city, String email)
    {
        if(users_passwords_Dic.containsKey(user_name))
        {
            // return to vontroler an error please enter new user name
        }

        else
        {
            users_passwords_Dic.put(user_name,password);
            insertUserToDB(user_name,password,birth_day,first_name,last_name,city,email);
            users_Dic.put(user_name,new User(user_name,password,birth_day,first_name,last_name,city,email));
        }
    }
    private Connection connect() {
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

    private void insertUserToDB(String User_name, String Password, String Birth_day, String First_name, String Last_name, String City,String Email) {
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

    public List<String> searchUser (String user_name){
        if (!users_passwords_Dic.containsKey(user_name)){
            return null;
        }
        return users_Dic.get(user_name).listOfUserDetails();
    }

    public void updateUser(String user_name, String password, String birth_day, String first_name, String last_name, String city, String email) {
        String sql = "UPDATE Users SET User_name = ? , "
                                    + "Password = ? ,"
                                    + "Birth_day = ? ,"
                                    + "First_name = ? ,"
                                    + "Last_name = ? ,"
                                    + "City = ? ,"
                                    + "Email = ? "
                                    + "WHERE User_name  = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, user_name);
            pstmt.setString(2, password);
            pstmt.setString(3, birth_day);
            pstmt.setString(4, first_name);
            pstmt.setString(5, last_name);
            pstmt.setString(6, city);
            pstmt.setString(7, email);
            pstmt.setString(8, user_name);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
