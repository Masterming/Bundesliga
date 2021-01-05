package model;

import java.util.*;
import java.util.logging.*;
import javax.persistence.*;

/**
 * @author Rene
 */
public class GameDBMapper {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Bundesliga");
    private final static Logger LOGGER = Logger.getLogger(GameDBMapper.class.getName());

    public int addGame(Game game) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

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
        return game.getId();
    }

    public Game getGame(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT g FROM Game g WHERE g.id = :id";
        TypedQuery<Game> tq = em.createQuery(query, Game.class);
        tq.setParameter("id", id);
        Game game = null;

        try {
            game = tq.getSingleResult();
            LOGGER.log(Level.INFO, "QUERY: {0}", game.toString());
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No game found for id = {0}", id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return game;
    }

    public List<Game> getAllGames() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT g FROM Game c WHERE g.id IS NOT NULL";
        TypedQuery<Game> tq = em.createQuery(strQuery, Game.class);
        List<Game> games = new ArrayList<>();

        try {
            games = tq.getResultList();
            LOGGER.log(Level.INFO, "QUERY: {0}", Arrays.toString(games.toArray()));
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No games found in table");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return games;
    }

    public int reset() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        String strQuery = "DELETE FROM Game";
        Query q = em.createQuery(strQuery);
        int i = 0;
        try {
            et = em.getTransaction();
            et.begin();
            i = q.executeUpdate();
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return i;
    }
}
