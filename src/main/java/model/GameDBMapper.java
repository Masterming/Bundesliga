package model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.*;
import javax.persistence.*;

/**
 * @author Rene
 */
public class GameDBMapper {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Bundesliga");
    private final static Logger LOGGER = Logger.getLogger(GameDBMapper.class.getName());

    public void addGame(Club a, Club b, LocalDateTime time) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Game game = new Game(a, b, time);

        try {
            et = em.getTransaction();
            et.begin();
            em.persist(game);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
    }

    public Game getGame(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT g FROM games g WHERE g.id = :id";
        TypedQuery<Game> tq = em.createQuery(query, Game.class);
        tq.setParameter("id", id);
        Game game = null;

        try {
            game = tq.getSingleResult();
            LOGGER.log(Level.INFO, game.toString());
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No game found for id = {0}", id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return game;
    }

    public List<Game> getGames() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT g FROM games c WHERE g.id IS NOT NULL";
        TypedQuery<Game> tq = em.createQuery(strQuery, Game.class);
        List<Game> games = null;

        try {
            games = tq.getResultList();
            LOGGER.log(Level.INFO, Arrays.toString(games.toArray()));
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No games found in table");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return games;
    }
}
