package repositories;

import com.sun.org.slf4j.internal.LoggerFactory;
import jdk.internal.instrumentation.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionHelper {

    private static Connection connection;
    public static final String URL = "jdbc:postgresql://localhost:5432/travel";
    public static final String USER = "postgres";
    public static final String PASSWORD = "edoxill";

    public static Connection getConnection(){
        if(connection == null){
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("bd connection fail");
            }
        }
        return connection;
    }
}
