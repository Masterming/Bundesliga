package model;

import java.util.*;
import java.util.logging.*;
import javax.persistence.*;

/**
 * @author Rene
 */
public class PlayerDBMapper {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Bundesliga");

    private final static Logger LOGGER = Logger.getLogger(PlayerDBMapper.class.getName());

    public int addPlayer(Player player) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            
            et = em.getTransaction();
            et.begin();
            em.persist(player);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return player.getId();
    }

    public Player getPlayer(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT p FROM Player p WHERE p.id = :id";
        TypedQuery<Player> tq = em.createQuery(query, Player.class);
        tq.setParameter("id", id);
        Player player = null;

        try {
            player = tq.getSingleResult();
            LOGGER.log(Level.INFO, "QUERY: {0}", player.toString());
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No player found for id = {0}", id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return player;
    }

    public List<Player> getAllPlayers() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT p FROM Player p WHERE p.id IS NOT NULL";
        TypedQuery<Player> tq = em.createQuery(strQuery, Player.class);
        List<Player> players = new ArrayList<>();

        try {
            players = tq.getResultList();
            LOGGER.log(Level.INFO, "QUERY: {0}", Arrays.toString(players.toArray()));
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No players found in table");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return players;
    }

    public int reset() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        String strQuery = "DELETE FROM Player";
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
