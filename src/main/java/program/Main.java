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
        ExtendedLogger.setDebugLevel(Level.SEVERE); // SEVERE or INFO
        try {
            ExtendedLogger.setup();
        } catch (IOException ex) {
            LOGGER.warning(ex.getLocalizedMessage());
        }

        try {
            testAddPlayer();
            testGetPlayer();

            // resetDB(); //current persistence settings auto-drop tables for testing
            // purposes on startup
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        }

        // 3 different ways of handling persistence:
        // 1) get data at start of appliocation and update db only at intervals/end of
        // application
        // 2) every action changes the java object and persits it completely(heavy load)
        // 3) add and get work with JPA/ update statements use JDBC query
        //
    }

    private static void testAddPlayer() {
        Player model = new Player("Thomas Müller", 0);
        PlayerView view = new PlayerView();
        PlayerController controller = new PlayerController(model, view);

        controller.incrementGoals();

        PlayerDBMapper dao = new PlayerDBMapper();
        dao.addPlayer(model);
    }

    private static void testGetPlayer() {
        PlayerDBMapper dao = new PlayerDBMapper();
        for (Player model : dao.getPlayers()) {
            PlayerView view = new PlayerView();
            PlayerController controller = new PlayerController(model, view);

            // currently just prints name of player to console
            controller.updateView();
        }
    }

    private static void resetDB() {
        LigaDBMapper ldao = new LigaDBMapper();
        ClubDBMapper cdao = new ClubDBMapper();
        GameDBMapper gdao = new GameDBMapper();
        PlayerDBMapper pdao = new PlayerDBMapper();

        int count = 0;
        count += ldao.reset();
        count += cdao.reset();
        count += gdao.reset();
        count += pdao.reset();

        LOGGER.log(Level.INFO, "Removed {0} entries", count);
    }
}
