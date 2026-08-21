// CREATE DATABASE studentdb;

// USE studentdb;

// CREATE TABLE students (
//     id INT PRIMARY KEY AUTO_INCREMENT,
//     name VARCHAR(100) NOT NULL,
//     email VARCHAR(100),
//     age INT
// );



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "elpdev";
    private static final String PASSWORD = "elphill123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}