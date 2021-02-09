package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Rene
 */
@Entity
@Table(name = "games")
public class Game implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;

    private boolean finished = false;

    @ManyToMany(mappedBy = "games")
    private List<Liga> ligas;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "club1_id")
    private Club club1;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "club2_id")
    private Club club2;

    private int score1;
    private int score2;
    private LocalDateTime startTime;

    public Game() {
        this.gameId = -1;
    }

    public Game(Club club1, Club club2, LocalDateTime start) {
        ligas = new ArrayList();
        this.gameId = -1;
        this.club1 = club1;
        this.club2 = club2;
        this.startTime = start;
    }

    public Game(Club club1, Club club2, LocalDateTime start, Liga l1, Liga l2) {
        ligas = new ArrayList();
        this.gameId = -1;
        this.club1 = club1;
        this.club2 = club2;
        this.startTime = start;
        if (l1.getId() == l2.getId()) {
            ligas.add(l1);
        } else {
            ligas.add(l1);
            ligas.add(l2);
        }
    }

    public Game(int id, Club club1, Club club2, LocalDateTime start) {
        ligas = new ArrayList();
        this.gameId = id;
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

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public List<Liga> getLigas() {
        return ligas;
    }

}
