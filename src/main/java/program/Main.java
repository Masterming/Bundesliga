package program;

import model.*;
import view.*;
import controller.*;

import java.util.logging.*;
import java.io.IOException;

/**
 * @author Rene
 */
public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ExtendedLogger.setDebugLevel(Level.SEVERE);
        try {
            ExtendedLogger.setup();
        } catch (IOException ex) {
            LOGGER.warning(ex.getLocalizedMessage());
        }

        test();
        // 3 different ways of handling persistence:
        // 1) get data at start of appliocation and update db only at intervals/end of application
        // 2) every action changes the java object and persits it completely(heavy load)
        // 3) add and get work with JPA/ update statements use JDBC query
    }

    private static void test() {
        Liga firstLiga = new Liga(1, "1.Bundesliga");
        LigaView lv = new LigaView();
        LigaController lcontroller = new LigaController(firstLiga, lv);
        lcontroller.addClub(new Club("FC Bayern Muenchen"));
        lcontroller.addClub(new Club("RB Leipzig"));
        lcontroller.addClub(new Club("Borussia Dortmund"));
        lcontroller.addClub(new Club("VfL Wolfsburg"));

        lcontroller.updateView();
    }
}
