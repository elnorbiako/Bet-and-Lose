package pl.betsonline.dao;

import pl.betsonline.web.CountryDto;
import pl.betsonline.web.LeagueDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LeagueDao {

    private static final String CREATE_LEAGUE_QUERY = "INSERT INTO league(id, name, country_id) VALUES (?,?,?)";



    public static void add(LeagueDto league) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_LEAGUE_QUERY);) {

            statement.setString(2, league.getName());
            statement.setLong(1, league.getApiLeagueId());
            statement.setLong(3, league.getApiCountryId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }
}


