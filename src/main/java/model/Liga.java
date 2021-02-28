package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Rene
 */
@Entity
@Table(name = "ligas")
public class Liga extends Observable implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ligaId;
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "ligaId"), inverseJoinColumns = @JoinColumn(name = "clubId"))
    private List<Club> clubs;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "ligaId"), inverseJoinColumns = @JoinColumn(name = "gameId"))
    private List<Game> games;

    public Liga() {
        this.ligaId = -1;
        this.name = "";
        clubs = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    public Liga(String name) {
        this.ligaId = -1;
        this.name = name;
        this.clubs = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    public Liga(int id, String name) {
        this.ligaId = id;
        this.name = name;
        this.clubs = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    public int getId() {
        return ligaId;
    }

    public void setId(int id) {
        ligaId = id;
        notifyObservers(this);
    }

    public String getName() {
        return name;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public boolean addClub(Club c) {
        boolean sucess = clubs.add(c);
        setChanged();
        notifyObservers(this);
        return sucess;
    }

    public boolean removeClub(Club c) {
        boolean sucess = clubs.remove(c);
        setChanged();
        notifyObservers(this);
        removeGames(c);
        return sucess;
    }

    public Club removeClub(String name) {
        Club temp = null;
        for (Club c : clubs) {
            if (c.getName().equals(name)) {
                temp = c;
                clubs.remove(c);

                setChanged();
                notifyObservers(this);
                break;
            }
        }
        if (temp == null) {
            return temp;
        }
        removeGames(temp);
        return temp;
    }

    public Club getClub(String name) {
        for (Club c : clubs) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public boolean updateClub(Club c) {
        boolean sucess = false;
        ListIterator<Club> iterator = clubs.listIterator();
        while (iterator.hasNext()) {
            Club next = iterator.next();
            if (next.equals(c)) {
                // Replace element
                iterator.set(c);
                sucess = true;
                setChanged();
                notifyObservers(this);
                break;
            }
        }
        return sucess;
    }

    public boolean changeClubName(String name, String newName) {
        for (Club c : clubs) {
            if (c.getName().equals(name)) {
                c.setName(newName);
                setChanged();
                notifyObservers(this);
                return true;
            }
        }
        return false;
    }

    public boolean changeClubStadion(String name, String newName) {
        for (Club c : clubs) {
            if (c.getName().equals(name)) {
                c.setStadion(newName);
                setChanged();
                notifyObservers(this);
                return true;
            }
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers(this);
    }

    public List<Game> getGames() {
        return games;
    }

    public boolean updateGame(Game g) {
        if (!this.games.contains(g)) {
            this.games.add(g);
            setChanged();
            notifyObservers(this);
            return true;
        } else {
            setChanged();
            notifyObservers(this);
            return false;
        }
    }
    
    public boolean updateGames(List<Game> gl) {
        boolean success = true;
        for (Game g : gl) {
            if (!this.games.contains(g)) {
                this.games.add(g);
            } else {
                success = false;
            }
        }
        setChanged();
        notifyObservers(this);
        return success;
    }

    private void removeGames(Club temp) {
        List<Game> gamesToRemove = new ArrayList<>();
        for (Game g : games) {
            if (!g.isFinished() && (g.getClub1().equals(temp) || g.getClub2().equals(temp))) {
                gamesToRemove.add(g);
            }
        }

        // Use Iterator to remove the games from all appropiate lists
        Iterator<Game> iter = gamesToRemove.iterator();
        while (iter.hasNext()) {
            Game g = iter.next();
            List<Liga> ligTemp = g.getLigas();
            if (ligTemp.size() == 2) {
                ligTemp.get(1).removeGame(g);
            }
            ligTemp.get(0).removeGame(g);
        }
    }

    private void removeGame(Game g) {
        setChanged();
        notifyObservers(this);
        games.remove(g);
    }

    public boolean copy(Liga other) {
        boolean success = true;
        if (!equals(other)) {
            success = false;
        }

        this.name = other.name;

        List<Integer> ids = new ArrayList<>();
        for (Club c : other.clubs) {
            ids.add(c.getId());
            if (clubs.contains(c)) {
                if (!clubs.get(clubs.indexOf(c)).copy(c)) {
                    success = false;
                }
            } else {
                clubs.add(c);
            }
        }
        List<Club> toRemove = new ArrayList<>();
        for (Club c : clubs) {
            if (!ids.contains(c.getId())) {
                toRemove.add(c);
            }
        }
        for (Club c : toRemove) {
            clubs.remove(c);
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
        Liga l = (Liga) o;
        // field comparison
        return this.ligaId == l.ligaId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.ligaId;
        return hash;
    }

    @Override
    public String toString() {
        return "Liga: " + name;
    }
    
    public void reset() {
        for (Club c : getClubs()) {
            c.reset();
        }
        games.clear();
        setChanged();
        notifyObservers();
    }
}
