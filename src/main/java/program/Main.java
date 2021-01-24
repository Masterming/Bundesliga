package program;

import controller.MainController;
import model.*;

import java.util.logging.*;
import java.io.IOException;
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
        MainView mv2 = new MainView();
        MainController m2 = new MainController(mv2, new Liga("Liga 1"));
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
}
