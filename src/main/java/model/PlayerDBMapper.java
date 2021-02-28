package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author Rene
 */
public class PlayerDBMapper {

    private final static Logger LOGGER = Logger.getLogger(PlayerDBMapper.class.getName());

    public int addPlayer(Player player) {
        EntityManager em = ManagerFactory.getEntityManager();
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
            // em.close();
        }
        return player.getId();
    }

    public Player getPlayer(int id) {
        EntityManager em = ManagerFactory.getEntityManager();
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
            // em.close();
        }
        return player;
    }

    public List<Player> getAllPlayers() {
        EntityManager em = ManagerFactory.getEntityManager();
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
            // em.close();
        }
        return players;
    }

    public int reset() {
        EntityManager em = ManagerFactory.getEntityManager();
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
            // em.close();
        }
        return i;
    }

    public boolean deletePlayer(Player p) {
        boolean bSuccess = true;
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.remove(p);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            bSuccess = false;
        } finally {
            // em.close();
        }
        return bSuccess;
    }

    public boolean updatePlayer(Player p) {
        boolean bSuccess = true;
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.merge(p);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            bSuccess = false;
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            // em.close();
        }
        return bSuccess;
    }
}
