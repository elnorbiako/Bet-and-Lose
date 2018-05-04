package pl.betsonline.dao;

import pl.betsonline.model.User;
import pl.betsonline.web.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {

    private static final String CREATE_USER_QUERY = "INSERT INTO User(id, firstName, lastName, streetAddress, cityAddress, phone, email) VALUES (?,?,?,?,?,?,?)";



    public static void add(UserDto user) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER_QUERY);) {

            statement.setLong(1, user.getUserId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getStreetAddress());
            statement.setString(5, user.getCityAddress());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getEmail());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }
}
