package model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 * @author Rene
 */
@Entity
@Table(name = "ligas")
public class Liga implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final int ligaId;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = @JoinColumn(name = "ligaId"), inverseJoinColumns = @JoinColumn(name = "clubId"))
    private List<Club> clubs;

    public Liga() {
        this.ligaId = -1;
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

    public String getName() {
        return name;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public boolean addClub(Club c) {
        return clubs.add(c);
    }

    public boolean removeClub(Club c) {
        return clubs.remove(c);
    }

    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public String toString() {
        return "Liga: " + name;
    }
}
