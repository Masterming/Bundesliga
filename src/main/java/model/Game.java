package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

/**
 * @author Rene
 */
@Entity
@Table(name = "games")
public class Game implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;

    private boolean finished = false;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "gameId"), inverseJoinColumns = @JoinColumn(name = "ligaId"))
    private List<Liga> leagues;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "club1_id")
    private Club club1;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "club2_id")
    private Club club2;

    private int score1;
    private int score2;
    private LocalDateTime startTime;

    public Game() {
        this.gameId = -1;
        this.score1 = 0;
        this.score2 = 0;
    }

    public Game(Club club1, Club club2, LocalDateTime start) {
        this.gameId = -1;
        this.score1 = 0;
        this.score2 = 0;
        this.club1 = club1;
        this.club2 = club2;
        this.startTime = start;
    }

    public Game(int id, Club club1, Club club2, LocalDateTime start) {
        this.gameId = id;
        this.score1 = 0;
        this.score2 = 0;
        this.club1 = club1;
        this.club2 = club2;
        this.startTime = start;
    }

    public int getId() {
        return gameId;
    }

    public void setId(int id) {
        gameId = id;
    }

    public Club getClub1() {
        return club1;
    }

    public Club getClub2() {
        return club2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public LocalDateTime getStart() {
        return startTime;
    }

    public void setStart(LocalDateTime start) {
        this.startTime = start;
    }

    public void increaseScore1() {
        score1++;
    }

    public void increaseScore2() {
        score2++;
    }

    @Override
    public String toString() {
        return "Game: " + club1.getName() + " vs " + club2.getName();
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
