package org.alivxo.javafxdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/finance_manager";
    private static final String USER = "root";  // Change to your MySQL username
    private static final String PASSWORD = "YUm15510n";  // Change to your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
