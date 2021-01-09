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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ligaId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    @Override
    public String toString() {
        return "Liga: " + name;
    }
}
