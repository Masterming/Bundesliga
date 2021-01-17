package Testing;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import program.ExtendedLogger;
import model.Player;
import model.PlayerDBMapper;
import model.Club;
import model.ClubDBMapper;
import model.Liga;
import model.LigaDBMapper;
import model.Game;
import model.GameDBMapper;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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
        LOGGER.log(Level.INFO, "Setup");

        testAdd();
    }

    // @AfterClass
    public void resetDB() {
        LigaDBMapper ldao = new LigaDBMapper();
        ClubDBMapper cdao = new ClubDBMapper();
        PlayerDBMapper pdao = new PlayerDBMapper();
        GameDBMapper gdao = new GameDBMapper();

        int count = 0;
        count += pdao.reset();
        count += cdao.reset();
        count += ldao.reset();
        count += gdao.reset();

        LOGGER.log(Level.INFO, "Removed {0} entries", count);
    }

    public static void testAdd() {
        testAddPlayer();
        testAddClub();
        testAddLiga();
        testAddGame();
    }

    public static void testAddPlayer() {
        LOGGER.log(Level.INFO, "Test 1: Add Player");
        p1 = new Player("Thomas Mueller", 0);
        p2 = new Player("Luca Schuler", 0);

        PlayerDBMapper dao = new PlayerDBMapper();
        p1.setId(dao.addPlayer(p1));
        p2.setId(dao.addPlayer(p2));
        LOGGER.log(Level.INFO, "Player1 ID: {0}", p1.getId());
        LOGGER.log(Level.INFO, "Player2 ID: {0}", p2.getId());

    }

    public static void testAddClub() {
        LOGGER.log(Level.INFO, "Test 2: Add Club");
        c1 = new Club("FC Augsburg");
        c2 = new Club("FC Schalke 04");
        c1.addPlayer(p1);
        c2.addPlayer(p2);

        ClubDBMapper dao = new ClubDBMapper();
        c1.setId(dao.addClub(c1));
        c2.setId(dao.addClub(c2));
        LOGGER.log(Level.INFO, "Club1 ID: {0}", c1.getId());
        LOGGER.log(Level.INFO, "Club2 ID: {0}", c2.getId());
    }

    public static void testAddLiga() {
        LOGGER.log(Level.INFO, "Test 3: Add Liga");
        l1 = new Liga("1. Bundesliga");
        l1.addClub(c1);
        l1.addClub(c2);

        LigaDBMapper dao = new LigaDBMapper();
        l1.setId(dao.addLiga(l1));
        LOGGER.log(Level.INFO, "Liga ID: {0}", l1.getId());
    }

    public static void testAddGame() {
        LOGGER.log(Level.INFO, "Test 4: Add Game");
        g1 = new Game(c1, c2, LocalDateTime.now());

        GameDBMapper dao = new GameDBMapper();
        g1.setId(dao.addGame(g1));
        LOGGER.log(Level.INFO, "Game ID: {0}", g1.getId());
    }

    @Test
    public void testGetPlayer() {
        LOGGER.log(Level.INFO, "Test 5");
        PlayerDBMapper dao = new PlayerDBMapper();
        Player player = dao.getPlayer(1);
        Assert.assertNotNull(player);
    }

    @Test
    public void testGetClub() {
        LOGGER.log(Level.INFO, "Test 6");
        ClubDBMapper dao = new ClubDBMapper();
        Club club = dao.getClub(1);
        Assert.assertNotNull(club);
    }

    @Test
    public void testGetLiga() {
        LOGGER.log(Level.INFO, "Test 7");
        LigaDBMapper dao = new LigaDBMapper();
        Liga liga = dao.getLiga(1);
        Assert.assertNotNull(liga);
    }

    @Test
    public void testGetGame() {
        LOGGER.log(Level.INFO, "Test 8");
        GameDBMapper dao = new GameDBMapper();
        Game game = dao.getGame(1);
        Assert.assertNotNull(game);
    }

    @Test
    public void testGetPlayerAttribute() {
        LOGGER.log(Level.INFO, "Test 9");
        PlayerDBMapper dao = new PlayerDBMapper();
        Player player = dao.getPlayer(1);
        Assert.assertEquals(p1.getName(), player.getName());
    }

    @Test
    public void testGetClubAttribute() {
        LOGGER.log(Level.INFO, "Test 10");
        ClubDBMapper dao = new ClubDBMapper();
        Club club = dao.getClub(1);
        Assert.assertEquals(c1.getPlayers().get(0).getName(), club.getPlayers().get(0).getName());
    }

    @Test
    public void testGetLigaAttribute() {
        LOGGER.log(Level.INFO, "Test 11");
        LigaDBMapper dao = new LigaDBMapper();
        Liga liga = dao.getLiga(1);
        Assert.assertEquals(liga.getClubs().get(0).getName(), l1.getClubs().get(0).getName());
    }

    @Test
    public void testGetGameAttribute() {
        LOGGER.log(Level.INFO, "Test 12");
        GameDBMapper dao = new GameDBMapper();
        Game game = dao.getGame(1);
        Assert.assertEquals(game.getClub1().getName(), g1.getClub1().getName());
    }
}
