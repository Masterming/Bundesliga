package model;

import java.util.Arrays;
import java.util.List;
import java.util.logging.*;
import javax.persistence.*;

/**
 * @author Rene
 */
public class PlayerDBMapper {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Bundesliga");
    private final static Logger LOGGER = Logger.getLogger(PlayerDBMapper.class.getName());

    public void addPlayer(String name, String country, int goals) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Player player = new Player(name, country, goals);

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
    }

    public Player getPlayer(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT p FROM players p WHERE p.id = :id";
        TypedQuery<Player> tq = em.createQuery(query, Player.class);
        tq.setParameter("id", id);
        Player player = null;

        try {
            player = tq.getSingleResult();
            LOGGER.log(Level.INFO, player.toString());
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No players found for id = {0}", id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return player;
    }

    public List<Player> getPlayers() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT p FROM players p WHERE p.id IS NOT NULL";
        TypedQuery<Player> tq = em.createQuery(strQuery, Player.class);
        List<Player> players = null;

        try {
            players = tq.getResultList();
            LOGGER.log(Level.INFO, Arrays.toString(players.toArray()));
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No players found in table");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return players;
    }
}
