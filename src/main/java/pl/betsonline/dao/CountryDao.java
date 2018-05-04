package pl.betsonline.dao;

import pl.betsonline.web.CountryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CountryDao {

    private static final String CREATE_COUNTRY_QUERY = "INSERT INTO country(id, name) VALUES (?,?)";



    public static void add(CountryDto country) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_COUNTRY_QUERY);) {

            statement.setString(2, country.getName());
            statement.setLong(1, country.getApiCountryId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }
}


