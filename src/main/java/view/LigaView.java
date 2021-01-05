package view;

import java.util.*;
import model.Club;
import model.Liga;

/**
 * @author Rene
 */
public class LigaView {

    public void printOverview(Liga model) {
        List<Club> clubs = model.getClubs();
        clubs.sort((o1, o2) -> o2.getPoints() - o1.getPoints());
        System.out.println(model.getName() + ": ");
        for (Club c : clubs) {
            System.out.println(c.getName() + ": " + c.getPoints());
        }
    }
}
