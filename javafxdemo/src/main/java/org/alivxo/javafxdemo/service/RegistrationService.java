package org.alivxo.javafxdemo.service;
import org.alivxo.javafxdemo.dao.UserDAO;
import org.alivxo.javafxdemo.model.User;

import java.sql.SQLException;

public class RegistrationService {
    private final UserDAO userDAO;

    public RegistrationService () {
        userDAO = new UserDAO();
    }

    public boolean register (String username , String password , String email) throws SQLException {
        User user   = new User(0, username,password,email);

        // add the user to the database
        return userDAO.addUsers(user);
    }
}
