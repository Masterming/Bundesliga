package program;

import model.*;
import view.*;
import controller.*;

/**
 * @author Rene
 */
public class Main {

    public static void main(String[] args) {
        Liga firstLiga = createTestLiga();
        LigaView view = new LigaView();
        LigaController controller = new LigaController(firstLiga, view);

        controller.updateView();
    }

    private static Liga retrieveLigaFromDB() {
        // TODO: connect to db and get data
        return null;
    }

    private static Liga createTestLiga() {
        Liga firstLiga = new Liga(1, "1.Bundesliga");
        firstLiga.addClub(new Club(1, "FC Bayern Muenchen"));
        firstLiga.addClub(new Club(2, "Bayer 04 Leverkusen"));
        firstLiga.addClub(new Club(3, "RB Leipzig"));
        firstLiga.addClub(new Club(4, "Borussia Dortmund"));
        firstLiga.addClub(new Club(5, "VfL Wolfsburg"));
        firstLiga.addClub(new Club(6, "1. FC Union Berlin"));
        return firstLiga;
    }

}
