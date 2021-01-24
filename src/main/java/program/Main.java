package program;

import controller.MainController;
import model.*;

import java.util.logging.*;
import java.io.IOException;
import java.time.LocalDateTime;

import view.MainView;

/**
 * @author Rene
 */
public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Custom logging
        try {
            ExtendedLogger.disableConsole();
            ExtendedLogger.enableHtml();
            ExtendedLogger.setDebugLevel(Level.INFO); // SEVERE or INFO
        } catch (IOException ex) {
            LOGGER.warning(ex.getLocalizedMessage());
        }

        try {
            // Insert Code here
            testAdd();
            MainView mv2 = new MainView();
            MainController m2 = new MainController(mv2);
            // resetDB(); //current persistence settings auto-drop on startup
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
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

    public static void testAdd() {
        Player p1;
        Player p2;
        Club c1;
        Club c2;
        Liga l1;
        Liga l2;
        Liga l3;
        Game g1;

        p1 = new Player("Thomas Mueller", 0);
        p2 = new Player("Luca Schuler", 0);
        PlayerDBMapper dao_p = new PlayerDBMapper();
        p1.setId(dao_p.addPlayer(p1));
        p2.setId(dao_p.addPlayer(p2));

        c1 = new Club("FC Augsburg");
        c2 = new Club("FC Schalke 04");
        c1.addPlayer(p1);
        c2.addPlayer(p2);
        ClubDBMapper dao_c = new ClubDBMapper();
        c1.setId(dao_c.addClub(c1));
        c2.setId(dao_c.addClub(c2));

        l1 = new Liga("1. Bundesliga");
        l2 = new Liga("2. Bundesliga");
        l3 = new Liga("3. Liga");
        l1.addClub(c1);
        l1.addClub(c2);
        LigaDBMapper dao_l = new LigaDBMapper();
        l1.setId(dao_l.addLiga(l1));
        l2.setId(dao_l.addLiga(l2));
        l3.setId(dao_l.addLiga(l3));

        g1 = new Game(c1, c2, LocalDateTime.now());
        GameDBMapper dao_g = new GameDBMapper();
        g1.setId(dao_g.addGame(g1));
    }
}
