package pl.betsonline.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchDto {

    @JsonProperty("league_id")
    long apiLeagueId;
    @JsonProperty("match_id")
    long id;
    @JsonProperty("match_date")
    String date;
    @JsonProperty("match_hometeam_name")
    String homeTeam;
    @JsonProperty("match_awayteam_name")
    String awayTeam;
    @JsonProperty("match_hometeam_score")
    int homeGoals;
    @JsonProperty("match_awayteam_score")
    int awayGoals;


    public MatchDto(long apiLeagueId, long id, String date, String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
        this.apiLeagueId = apiLeagueId;
        this.id = id;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public MatchDto() {
    }

    public long getApiLeagueId() {
        return apiLeagueId;
    }

    public void setApiLeagueId(long apiLeagueId) {
        this.apiLeagueId = apiLeagueId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    @Override
    public String toString() {
        return "MatchDto{" +
                "apiLeagueId=" + apiLeagueId +
                ", id=" + id +
                ", date='" + date + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", homeGoals=" + homeGoals +
                ", awayGoals=" + awayGoals +
                '}';
    }
}