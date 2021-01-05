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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clubId;
    private String name;
    private int points;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "clubId"), inverseJoinColumns = @JoinColumn(name = "playerId"))
    private List<Player> players;

    public Club() {
        // this.clubId = -1;
        this.players = new ArrayList<>();
    }

    public Club(String name) {
        // this.clubId = -1;
        this.name = name;
        this.points = 0;
        this.players = new ArrayList<>();
    }

    public Club(int id, String name) {
        this.clubId = id;
        this.name = name;
        this.points = 0;
        this.players = new ArrayList<>();
    }

    public int getId() {
        return clubId;
    }

    public void setId(int id) {
        clubId = id;
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

    public List<Player> getPlayers() {
        return players;
    }

    public boolean addPlayer(Player p) {
        return players.add(p);
    }

    public boolean removePlayer(Player p) {
        return players.remove(p);
    }

    @Override
    public String toString() {
        return "Club: " + name;
    }
}
