package model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Rene
 */
@Entity
@Table(name = "clubs")
public class Club implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clubId;
    private String name;
    private String stadion;
    private int points;
    private int gamesCount;
    private int wins;
    private int draw;
    private int losses;
    //Für die Anzeige des Torverhältnisses
    private int madeGoals;
    private int receivedGoals;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "clubId"), inverseJoinColumns = @JoinColumn(name = "playerId"))
    private List<Player> players;

    public Club() {
        this.clubId = -1;
        this.name = "";
        this.stadion = "";
        this.players = new ArrayList<>();
    }

    public Club(String name) {
        this.clubId = -1;
        this.name = name;
        this.stadion = "";
        this.players = new ArrayList<>();
    }

    public Club(String name, String stadion) {
        this.clubId = -1;
        this.name = name;
        this.stadion = stadion;
        this.players = new ArrayList<>();
    }

    public Club(int id, String name) {
        this.clubId = id;
        this.name = name;
        this.stadion = "";
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
    
    public boolean removePlayer(String playerName){
        boolean success=false;
        for(Player p : players){
            if(p.getName().equals(playerName)){
                players.remove(draw);
            }
        }
        return success;
    }

    @Override
    public String toString() {
        return "Club: " + name;
    }

    public int getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(int gamesCount) {
        this.gamesCount = gamesCount;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getMadeGoals() {
        return madeGoals;
    }

    public void setMadeGoals(int madeGoals) {
        this.madeGoals = madeGoals;
    }

    public int getReceivedGoals() {
        return receivedGoals;
    }

    public void setReceivedGoals(int receivedGoals) {
        this.receivedGoals = receivedGoals;
    }

    public String getStadion() {
        return stadion;
    }

    public void setStadion(String stadion) {
        this.stadion = stadion;
    }

    public void setName(String name) {
        this.name = name;
    }

}
