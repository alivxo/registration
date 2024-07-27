package org.alivxo.javafxdemo.dao;


import org.alivxo.javafxdemo.model.User;
import org.alivxo.javafxdemo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User getUserByUsername (String username) throws SQLException {

        // Defining the SQL query to select a user by a username
        String sql = "SELECT * FROM users WHERE username = ?";

        /* using try-with-resources method
        - Automatic Closing: Resources like database connections,
        statements, and result sets are automatically closed at
        the end of the try block.
        - Less Boilerplate: No need for a final block to close
         resources manually.
         - Cleaner Code: Makes the code easier to read and maintain
         */

        try(Connection connection = DBUtil.getConnection(); // Get a connection to the database
            PreparedStatement statement = connection.prepareStatement(sql)){ // Preparing the SQL statement

            //set the value of the first parameter in the SQL query to the provided username
            statement.setString(1, username);

            // Execute the query and get the result set
            /*
            - Execute the query: This line executes the SQL query defined earlier
             ("SELECT * FROM users WHERE username = ?"), where the ? has been replaced by the actual username value.
            - Get the result set: The executeQuery() method returns a ResultSet object, which contains the results of
             the SQL query. This ResultSet will have all the rows and columns that match the query conditions.
             */
            ResultSet resultSet = statement.executeQuery();

            // If a user with the specified username exits , create a User object
            if (resultSet.next()){
                return new User (
                        resultSet.getInt("id"), // get the userID
                        resultSet.getString("username"), // get the users username
                        resultSet.getString("password"), // get the users password
                        resultSet.getString("email") // gets the users email
                );
            }

        }
        // return the null if no users is found with the specified username
        return null;
    }
    public boolean addUsers(User users) throws SQLException {
        //Defines the SQL query to insert a new user into the user table
        String sql = "INSERT INTO user (username, password, email) VALUES (? , ? ,?)";

         /* using try-with-resources method
        - Automatic Closing: Resources like database connections,
        statements, and result sets are automatically closed at
        the end of the try block.
        - Less Boilerplate: No need for a final block to close
         resources manually.
         - Cleaner Code: Makes the code easier to read and maintain
         */
        try(Connection connection = DBUtil.getConnection(); // Get connection to the database
            PreparedStatement statement = connection.prepareStatement(sql)){ //Prepare the SQL statement
            // Set the values of the parameters in the SQL query to the user's data
            statement.setString(1, users.getUsername()); // set the username parameters
            statement.setString(2, users.getPassword()); // set the users passowrds
            statement.setString(3, users.getEmail()); // set the users email

            // Execute the update and check if at least one row was affected (indicating success)
            return statement.executeUpdate() > 0;

        }

    }



}
