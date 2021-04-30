package program;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import presenter.MainPresenter;
import model.*;
import view.MainView;

/**
 * @author Rene
 */
public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Custom logging
        try {
            ExtendedLogger.useConsole(true);
            ExtendedLogger.enableHtml();
            ExtendedLogger.setDebugLevel(Level.INFO); // SEVERE or INFO
        } catch (IOException ex) {
            LOGGER.warning(ex.getLocalizedMessage());
        }

        try {
            // testAdd();
            MainView view = new MainView();
            MainPresenter controller = new MainPresenter(view);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        }
    }

    public static void testAdd() {
        Liga l1;
        Liga l2;
        Liga l3;
        l1 = new Liga("1. Bundesliga");
        l2 = new Liga("2. Bundesliga");
        l3 = new Liga("3. Bundesliga");
        LigaDBMapper dao_l = new LigaDBMapper();
        l1.setId(dao_l.addLiga(l1));
        l2.setId(dao_l.addLiga(l2));
        l3.setId(dao_l.addLiga(l3));
    }
}
