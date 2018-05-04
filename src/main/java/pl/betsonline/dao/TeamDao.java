package pl.betsonline.dao;

import pl.betsonline.web.TeamDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TeamDao {

    private static final String CREATE_TEAM_QUERY = "INSERT INTO team(name, league_id, position, points) VALUES (?,?,?,?)";



    public static void add(TeamDto team) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_TEAM_QUERY);) {

            statement.setString(1, team.getName());
            statement.setLong(2, team.getApiLeagueId());
            statement.setInt(3, team.getPosition());
            statement.setInt(4, team.getPoints());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }
}
