package model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 * @author Rene
 */
@Entity
@Table(name = "clubs")
public class Club implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final int id;
    private String name;
    private int points;

    @OneToMany(mappedBy = "club")
    private List<Player> players;

    public Club() {
        this.id = -1;
    }

    public Club(String name) {
        this.id = -1;
        this.name = name;
        this.points = 0;
        this.players = new ArrayList<>();
    }

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

    @Override
    public String toString() {
        return "Club: " + name;
    }
}
