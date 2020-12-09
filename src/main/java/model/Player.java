package model;

/**
 * @author Rene
 */
public class Player {
    private final int id;
    private final String name;
    private String country;
    private int goals;

    public Player(int id, String name, String country, int goals) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.goals = goals;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getGoals() {
        return goals;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void increaseGoals() {
        goals++;
    }
}
