package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Rene
 */
@Entity
@Table(name = "games")
public class Game implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GenericGenerator(name = "GameIdGenerator", strategy = "model.GameIdGenerator")
    @GeneratedValue(generator = "GameIdGenerator")
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

    public Game(Club club1, Club club2, LocalDateTime start, Liga l1, Liga l2) {
        ligas = new ArrayList();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyMMdd");
        try {
            //String id = LocalDateTime.now().format(f);
            String id = String.format("%02d%02d", club1.getId(), club2.getId());
            gameId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            gameId = -1;
        }
        System.out.println(gameId);
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
        if(finished){
            if(score1 < score2){
                club2.setWins(club2.getWins() + 1);
                club2.setGamesCount(club2.getGamesCount() + 1);
                club2.addPoints(3);
                club1.setLosses(club1.getLosses() + 1);
                club1.setGamesCount(club1.getGamesCount() + 1);
            }
            else if(score1 > score2){
                club1.setWins(club1.getWins() + 1);
                club1.setGamesCount(club1.getGamesCount() + 1);
                club1.addPoints(3);
                club2.setLosses(club2.getLosses() + 1);
                club2.setGamesCount(club2.getGamesCount() + 1);
            }
            else if(score1 == score2){
                club1.setGamesCount(club1.getGamesCount() + 1);
                club1.setDraw(club1.getDraw() + 1);
                club1.addPoints(1);
                club2.setGamesCount(club2.getGamesCount() + 1);
                club2.setDraw(club2.getDraw() + 1);
                club2.addPoints(1);                
            }
        }
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
        Game g = (Game) o;
        // field comparison
        return this.gameId == g.gameId;
    }
}
