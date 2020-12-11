package model;

import java.time.LocalDateTime;

/**
 * @author Rene
 */
public class Game {
    private final int id;
    private final int clubA;
    private final int clubB;
    private int scoreA;
    private int scoreB;

    private LocalDateTime start;

    public Game(int id, int clubA, int clubB, int scoreA, int scoreB, LocalDateTime start) {
        this.id = id;
        this.clubA = clubA;
        this.clubB = clubB;
        this.scoreA = 0;
        this.scoreB = 0;
        this.start = start;
    }

    public int getId() {
        return id;
    }

    public int getClubA() {
        return clubA;
    }

    public int getClubB() {
        return clubB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void increaseScoreA() {
        scoreA++;
    }

    public void increaseScoreB() {
        scoreB++;
    }
}
