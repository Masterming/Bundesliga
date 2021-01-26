package model;

import controller.MainController;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Rene
 */
@Entity
@Table(name = "ligas")
public class Liga extends Observable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ligaId;
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "ligaId"), inverseJoinColumns = @JoinColumn(name = "clubId"))
    private List<Club> clubs;

    public Liga() {
        this.ligaId = -1;
        this.name = "";
        clubs = new ArrayList<>();
    }

    public Liga(String name) {
        this.ligaId = -1;
        this.name = name;
        this.clubs = new ArrayList<>();
    }

    public Liga(int id, String name) {
        this.ligaId = id;
        this.name = name;
        this.clubs = new ArrayList<>();
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
        return sucess;
    }

    public boolean removeClub(String name) {
        boolean sucess = false;
        for (Club c : clubs) {
            if (c.getName().equals(name)) {
                sucess = clubs.remove(c);
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Liga: " + name;
    }

}
