package model;

/**
 * @author Rene
 */
public class Club {
    private final int id;
    private final String name;
    private int points;

    public Club(int id, String name) {
        this.id = id;
        this.name = name;
        this.points = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void resetPoints() {
        this.points = 0;
    }
}
