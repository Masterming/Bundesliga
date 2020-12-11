package model;

import java.util.*;

/**
 * @author Rene
 */
public class Liga {
    private final int id;
    private final String name;
    private List<Club> clubs;

    public Liga(int id, String name) {
        this.id = id;
        this.name = name;
        this.clubs = new ArrayList<Club>();
    }

    public int getId() {
        return id;
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
}
