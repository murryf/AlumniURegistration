package dev.fitzgerald.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A utility to connect to AWS hosting and return the connection for data storage and retrieval
 * */

public class ConnectionUtil {

    /**
     * Method to connect to database
     *
     * @return a connection to the database
     * */
    public static Connection createConnection(){
        try {
            Connection conn = DriverManager.getConnection("Your credentials here");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
