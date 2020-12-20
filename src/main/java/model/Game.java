package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 * @author Rene
 */
@Entity
@Table(name = "games")
public class Game implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final int id;

    @OneToOne
    @JoinColumn(name = "club1id")
    private Club club1;

    @OneToOne
    @JoinColumn(name = "club2id")
    private Club club2;

    private int score1;
    private int score2;
    private LocalDateTime startTime;

    public Game() {
        this.id = -1;
    }

    public Game(Club clubA, Club clubB, LocalDateTime start) {
        this.id = -1;
        this.club1 = clubA;
        this.club2 = clubB;
        this.score1 = 0;
        this.score2 = 0;
        this.startTime = start;
    }

    public Game(int id, Club clubA, Club clubB, LocalDateTime start) {
        this.id = id;
        this.club1 = clubA;
        this.club2 = clubB;
        this.score1 = 0;
        this.score2 = 0;
        this.startTime = start;
    }

    public int getId() {
        return id;
    }

    public Club getClubA() {
        return club1;
    }

    public Club getClubB() {
        return club2;
    }

    public int getScoreA() {
        return score1;
    }

    public int getScoreB() {
        return score2;
    }

    public LocalDateTime getStart() {
        return startTime;
    }

    public void setStart(LocalDateTime start) {
        this.startTime = start;
    }

    public void increaseScoreA() {
        score1++;
    }

    public void increaseScoreB() {
        score2++;
    }

    @Override
    public String toString() {
        return "Game: " + club1.getName() + " vs " + club2.getName();
    }
}
