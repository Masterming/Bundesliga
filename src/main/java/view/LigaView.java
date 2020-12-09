package view;

import java.util.*;
import model.Club;

/**
 * @author Rene
 */
public class LigaView {

    public void printSortedClubs(List<Club> clubs) {
        clubs.sort((o1, o2) -> o2.getPoints() - o1.getPoints());
        System.out.println("Ligatabelle");
        for(Club c: clubs){
            System.out.println(c.getName() + ": " + c.getPoints());
        }
    }

}
