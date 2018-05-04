package pl.betsonline.dao;

import com.mysql.jdbc.Driver;
import org.springframework.stereotype.Component;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

@Component
public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/bets_online?useSSL=false";
    public static final String USER = "root";
    public static final String PASS = "coderslab";


    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}