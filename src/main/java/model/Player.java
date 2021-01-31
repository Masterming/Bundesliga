package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Rene
 */
@Entity
@Table(name = "players")
public class Player implements Serializable {

    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    private String name;
    private int goals;

    public Player() {
        this.playerId = -1;
        this.name = "";
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

    public void setId(int id) {
        playerId = id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "Player: " + name + ": " + goals + " goals";
    }
    
    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Player player = (Player) o;
        // field comparison
        return this.playerId == player.playerId;
    } 

    public void clone(Player p) {
        name = p.name;
        goals = p.goals;
    }
}
