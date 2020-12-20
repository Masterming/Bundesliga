package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Rene
 */
@Entity
@Table(name = "players")
public class Player implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final int playerId;
    private String name;
    private int goals;

    public Player() {
        this.playerId = -1;
    }

    public Player(String name, int goals) {
        this.playerId = -1;
        this.name = name;
        this.goals = goals;
    }

    public Player(int id, String name, int goals) {
        this.playerId = id;
        this.name = name;
        this.goals = goals;
    }

    public int getId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public void increaseGoals() {
        goals++;
    }

    @Override
    public String toString() {
        return "Player: " + name + ": " + goals + " goals";
    }
}
