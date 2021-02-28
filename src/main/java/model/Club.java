package model;

import controller.MainController;
import java.io.Serializable;
import java.util.*;
import java.util.logging.*;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Rene
 */
@Entity
@Table(name = "clubs")
public class Club implements Serializable, Comparable {
    
    private final static Logger LOGGER = Logger.getLogger(Club.class.getName());

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clubId;
    private String name;
    private String stadion;
    private int points         = 0;
    private int gamesCount     = 0;
    private int wins           = 0;
    private int draw           = 0;
    private int losses         = 0;
    // Für die Anzeige des Torverhältnisses
    private int madeGoals      = 0;
    private int receivedGoals  = 0;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
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

    public Player removePlayer(String playerName) {
        Player ret = null;
        for (Player p : players) {
            if (p.getName().equals(playerName)) {
                ret = p;
                players.remove(p);
                break;
            }
        }
        return ret;
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

    public boolean changePlayerName(String name, String newName) {
        for (Player p : players) {
            if (p.getName().equals(name)) {
                p.setName(newName);
                return true;
            }
        }
        return false;
    }

    public boolean changePlayerGoals(String name, int count) {
        for (Player p : players) {
            if (p.getName().equals(name)) {
                p.setGoals(count);
                return true;
            }
        }
        return false;
    }

    public boolean copy(Club other) {
        boolean success = true;
        if (!equals(other)) {
            System.out.println("Club mismatch");
            success = false;
        }
        this.name = other.name;
        this.stadion = other.stadion;
        this.points = other.points;
        this.gamesCount = other.gamesCount;
        this.wins = other.wins;
        this.draw = other.draw;
        this.losses = other.losses;
        this.madeGoals = other.madeGoals;
        this.receivedGoals = other.receivedGoals;

        List<Integer> ids = new ArrayList<>();
        for (Player p : other.players) {
            ids.add(p.getId());
            if (players.contains(p)) {
                if (!players.get(players.indexOf(p)).copy(p)) {
                    success = false;
                }
            } else {
                players.add(p);
            }
        }
        List<Player> toRemove = new ArrayList<>();
        for (Player p : players) {
            if (!ids.contains(p.getId())) {
                toRemove.add(p);
            }
        }
        for (Player p : toRemove) {
            players.remove(p);
        }
        return success;
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        Club c = (Club) o;
        // field comparison
        return this.clubId == c.clubId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.clubId;
        return hash;
    }

    @Override
    public String toString() {
        return "Club: " + name;
    }

    @Override
    public int compareTo(Object o) {
        //null check
        if(o == null)
            throw new NullPointerException("comparing " + this.name + " to null");
        // type check and cast
        if (getClass() != o.getClass()) {
            throw new ClassCastException("cannot compare class Club with class " + o.getClass());
        }
        Club c = (Club) o;
        //equality check
        if(this.equals(c))
            return 0;        
        //comparisons
        //points
        if(points != c.points)
            return (points > c.points ? 1 : -1);
        //goal difference
        int diff1 = madeGoals - receivedGoals;
        int diff2 = c.madeGoals - c.receivedGoals;
        if(diff1 != diff2)
            return (diff1 > diff2 ? 1 : -1);
        //total result from direct comparison
        int tot1 = 0; //total score for this team
        int tot2 = 0; //total score for other team
        for (int i = 1; i < 3; i++){
            if(MainController.getLigas().get(i).getClubs().contains(this)){
                List<Game> tmp = MainController.getLigas().get(i).getGames(); //get all games from own league
                for(Game g : tmp){ //find all games with both teams in them
                    if(this.equals(g.getClub1()) && c.equals(g.getClub2())){
                        tot1 += g.getScore1(); //add game score to according total score
                        tot2 += g.getScore2();
                    }
                    else if(this.equals(g.getClub2()) && c.equals(g.getClub1())){
                        tot1 += g.getScore2();
                        tot2 += g.getScore1();
                    }
                }
                break;
            }
        }
        if(tot1 != tot2)
            return (tot1 > tot2 ? 1 : -1);
        /*
        Hier wird theoretisch noch ausgewertet, wer im direkten vergleich mehr Auswärts-Tore erzielt hat,
        dafür müssten wir aber die Heimmannschaft im Game-Objekt tracken.
        Passiert eh fast nie, wird also (erstmal) weggelassen.
        -> Heimteam immer Club1 im Game Objekt!! -> TODO
        */
        return 0;
    }
}
