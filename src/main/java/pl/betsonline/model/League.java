package pl.betsonline.model;

import java.util.Set;

public class League {

    private long id;
    private String name;
    private Country country;
    private Set<Team> teams;

    public League(long id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public League() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    // pozostałe atrybuty i metody
}

