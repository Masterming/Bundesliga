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
            // Insert Code here
            testAdd();
            MainView view = new MainView();
            MainPresenter controller = new MainPresenter(view);
            // resetDB(); //current persistence settings auto-drop on startup
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        }
    }

    public static void testAdd() {
        //// Player p1;
        //// Player p2;
        //// Club c1;
        //// Club c2;
        Liga l1;
        Liga l2;
        Liga l3;
        ////
        //// p1 = new Player("Thomas Mueller", 0);
        //// p2 = new Player("Luca Schuler", 0);
        //// PlayerDBMapper dao_p = new PlayerDBMapper();
        //// p1.setId(dao_p.addPlayer(p1));
        //// p2.setId(dao_p.addPlayer(p2));
        ////
        //// c1 = new Club("FC Augsburg");
        //// c2 = new Club("FC Schalke 04");
        //// c1.addPlayer(p1);
        //// c2.addPlayer(p2);
        //// ClubDBMapper dao_c = new ClubDBMapper();
        //// c1.setId(dao_c.addClub(c1));
        //// c2.setId(dao_c.addClub(c2));
        ////
        l1 = new Liga("1. Bundesliga");
        l2 = new Liga("2. Bundesliga");
        l3 = new Liga("3. Bundesliga");
        //// l1.addClub(c1);
        //// l1.addClub(c2);
        ////
        //// for(int i=0; i<20;i++){
        //// Club c = new Club("Club " + i);
        //// l1.addClub(c);
        //// }
        LigaDBMapper dao_l = new LigaDBMapper();
        l1.setId(dao_l.addLiga(l1));
        l2.setId(dao_l.addLiga(l2));
        l3.setId(dao_l.addLiga(l3));
    }
}
