package dev.fitzgerald.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection createConnection(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://fitzgerald-db.cgngn3tlalok.us-west-2.rds.amazonaws.com/postgres?user=postgres&password=Andr0mid4$tr41n");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
