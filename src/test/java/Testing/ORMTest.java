package Testing;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import program.ExtendedLogger;
import model.Club;
import model.ClubDBMapper;
import model.Game;
import model.GameDBMapper;
import model.Liga;
import model.LigaDBMapper;
import model.Player;
import model.PlayerDBMapper;

import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * @author Rene
 */
public class ORMTest {

    private final static Logger LOGGER = Logger.getLogger(ORMTest.class.getName());
    private static Player p1;
    private static Player p2;
    private static Club c1;
    private static Club c2;
    private static Liga l1;
    private static Game g1;

    @BeforeClass
    public static void setUp() {
        try {
            ExtendedLogger.disableConsole();
            ExtendedLogger.enableHtml();
            ExtendedLogger.setDebugLevel(Level.INFO);
        } catch (IOException ex) {
            LOGGER.warning(ex.getLocalizedMessage());
        }
        LOGGER.log(Level.WARNING, "Setup");

        testAdd();
    }

    // @After
    public void resetDB() {
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
        testAddPlayer();
        testAddClub();
        testAddLiga();
        // testAddGame();
    }

    public static void testAddPlayer() {
        LOGGER.log(Level.WARNING, "Test 1: Add Player");
        p1 = new Player("Thomas Müller", 0);
        p2 = new Player("Luca Schuler", 0);

        PlayerDBMapper dao = new PlayerDBMapper();
        p1.setId(dao.addPlayer(p1));
        p2.setId(dao.addPlayer(p2));
    }

    public static void testAddClub() {
        LOGGER.log(Level.WARNING, "Test 2: Add Club");
        c1 = new Club("FC Augsburg");
        c2 = new Club("FC Schalke 04");
        c1.addPlayer(p1);
        c2.addPlayer(p2);

        ClubDBMapper dao = new ClubDBMapper();
        c1.setId(dao.addClub(c1));
        c2.setId(dao.addClub(c2));
    }

    public static void testAddLiga() {
        LOGGER.log(Level.WARNING, "Test 3: Add Liga");
        l1 = new Liga("1. Bundesliga");
        l1.addClub(c1);
        l1.addClub(c2);

        LigaDBMapper dao = new LigaDBMapper();
        l1.setId(dao.addLiga(l1));
    }

    public static void testAddGame() {
        LOGGER.log(Level.WARNING, "Test 4: Add Game");
        g1 = new Game(c1, c2, LocalDateTime.now());
        l1.addClub(c1);
        l1.addClub(c2);

        GameDBMapper dao = new GameDBMapper();
        g1.setId(dao.addGame(g1));
    }

    // @Test
    public void testGetPlayer() {
        LOGGER.log(Level.WARNING, "Test 5");
        PlayerDBMapper dao = new PlayerDBMapper();
        Player player = dao.getPlayer(1);
        Assert.assertNotNull(player);
    }

    // @Test
    public void testGetClub() {
        LOGGER.log(Level.WARNING, "Test 6");
        ClubDBMapper dao = new ClubDBMapper();
        Club club = dao.getClub(1);
        Assert.assertNotNull(club);
    }

    @Test
    public void testGetLiga() {
        LOGGER.log(Level.WARNING, "Test 7");
        LigaDBMapper dao = new LigaDBMapper();
        Liga liga = dao.getLiga(1);
        Assert.assertNotNull(liga);
    }

    // @Test
    public void testGetGame() {
        LOGGER.log(Level.WARNING, "Test 8");
        GameDBMapper dao = new GameDBMapper();
        Game game = dao.getGame(1);
        Assert.assertNotNull(game);
    }

    // @Test
    public void testGetPlayerAttribute() {
        LOGGER.log(Level.WARNING, "Test 9");
        PlayerDBMapper dao = new PlayerDBMapper();
        Player player = dao.getPlayer(1);
        Assert.assertEquals(p1.getName(), player.getName());
    }

    // @Test
    public void testGetClubAttribute() {
        LOGGER.log(Level.WARNING, "Test 10");
        ClubDBMapper dao = new ClubDBMapper();
        Club club = dao.getClub(1);
        Assert.assertEquals(c1.getPlayers().get(0).getName(), club.getPlayers().get(0).getName());
    }

    // @Test
    public void testGetLigaAttribute() {
        LOGGER.log(Level.WARNING, "Test 11");
        LigaDBMapper dao = new LigaDBMapper();
        Liga liga = dao.getLiga(1);
        Assert.assertEquals(liga.getClubs().get(0).getName(), l1.getClubs().get(0).getName());
    }

    // @Test
    public void testGetGameAttribute() {
        LOGGER.log(Level.WARNING, "Test 12");
        GameDBMapper dao = new GameDBMapper();
        Game game = dao.getGame(1);
        Assert.assertEquals(game.getClub1().getName(), g1.getClub1().getName());
    }
}
