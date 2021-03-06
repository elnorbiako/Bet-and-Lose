package pl.betsonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.betsonline.dao.*;
import pl.betsonline.web.*;

@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping("/get-countries")
    public String getCountriesAction() {
        String url = "https://apifootball.com/api/?action=get_countries&APIkey=c4e29ebddc8c975cfd056599e5421d65d34ea41eab067765b95e776416e59cb6";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CountryDto[]> responseCountries = restTemplate.getForEntity(
                url, CountryDto[].class);
        CountryDto[] countries = responseCountries.getBody();
        for (CountryDto country: countries) {
            logger.info("countries {}", country);
            CountryDao.add(country);
        }
        return "some result";
    }

    @RequestMapping("/get-leagues")
    public String getLeaguesAction() {
        String url = "https://apifootball.com/api/?action=get_leagues&APIkey=c4e29ebddc8c975cfd056599e5421d65d34ea41eab067765b95e776416e59cb6";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LeagueDto[]> responseLeagues = restTemplate.getForEntity(
                url, LeagueDto[].class);
        LeagueDto[] leagues = responseLeagues.getBody();
        for (LeagueDto league: leagues) {
            logger.info("leagues {}", league);
            LeagueDao.add(league);
        }
        return "some result - leagues";
    }

    @RequestMapping("/get-teams/{leagueId}")
    public String getTeamsAction(@PathVariable ("leagueId") int leagueId) {
        String url = "https://apifootball.com/api/?action=get_standings&league_id=" + leagueId + "&APIkey=c4e29ebddc8c975cfd056599e5421d65d34ea41eab067765b95e776416e59cb6";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TeamDto[]> responseTeams = restTemplate.getForEntity(
                url, TeamDto[].class);
        TeamDto[] teams = responseTeams.getBody();
        for (TeamDto team: teams) {
            logger.info("teams {}", team);
            TeamDao.add(team);
        }
        return "some result - teams";
    }


    @RequestMapping("/get-match")
    public String getMatchAction() {
        String url = "https://apifootball.com/api/?action=get_events&from=2016-10-30&to=2016-11-11&league_id=63&APIkey=c4e29ebddc8c975cfd056599e5421d65d34ea41eab067765b95e776416e59cb6";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MatchDto[]> responseMatch = restTemplate.getForEntity(
                url, MatchDto[].class);
        MatchDto[] matches = responseMatch.getBody();
        for (MatchDto match : matches) {
            logger.info("matches {}", match);
            MatchDao.add(match);
        }
        return "some result - match";
    }

    @RequestMapping("/get-user")
    public String getUserAction() {
        String url = "http://localhost:8080/api/fake-users";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto[]> responseUser = restTemplate.getForEntity(
                url, UserDto[].class);
        UserDto[] users = responseUser.getBody();
        for (UserDto user : users) {
            logger.info("users {}", user);
            UserDao.add(user);
        }
        return "some result - user";
    }

}