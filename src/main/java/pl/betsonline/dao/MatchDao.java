package pl.betsonline.dao;

import pl.betsonline.web.MatchDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MatchDao {

    /**
     * table name 'game' instead of match - it causes problems in SQL
     */

    private static final String CREATE_MATCH_QUERY = "INSERT INTO game(id, date, league_id, homeTeam, awayTeam, homeGoals, awayGoals) VALUES (?,?,?,?,?,?,?)";



    public static void add(MatchDto match) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_MATCH_QUERY);) {

            statement.setLong(1, match.getId());
            statement.setString(2, match.getDate());
            statement.setLong(3, match.getApiLeagueId());
            statement.setString(4, match.getHomeTeam());
            statement.setString(5, match.getAwayTeam());
            statement.setInt(6, match.getHomeGoals());
            statement.setInt(7, match.getAwayGoals());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }
}


