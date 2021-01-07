package model;

import java.util.*;
import java.util.logging.*;
import javax.persistence.*;

/**
 * @author Rene
 */
public class ClubDBMapper {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Bundesliga");

    private final static Logger LOGGER = Logger.getLogger(ClubDBMapper.class.getName());

    public int addClub(Club club) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        int id = -1;

        try {
            et = em.getTransaction();
            et.begin();
            Club merge = em.merge(club);
            id = merge.getId();
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return id;
    }

    public Club getClub(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM Club c WHERE c.id = :id";
        TypedQuery<Club> tq = em.createQuery(query, Club.class);
        tq.setParameter("id", id);
        Club cust = null;

        try {
            cust = tq.getSingleResult();
            LOGGER.log(Level.INFO, "QUERY: {0}", cust.toString());
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No club found for id = {0}", id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return cust;
    }

    public List<Club> getAllClubs() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT c FROM Club c WHERE c.id IS NOT NULL";
        TypedQuery<Club> tq = em.createQuery(strQuery, Club.class);
        List<Club> custs = new ArrayList<>();

        try {
            custs = tq.getResultList();
            LOGGER.log(Level.INFO, "QUERY: {0}", Arrays.toString(custs.toArray()));
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No clubs found in table");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return custs;
    }

    public int reset() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        String strQuery = "DELETE FROM Club";
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
