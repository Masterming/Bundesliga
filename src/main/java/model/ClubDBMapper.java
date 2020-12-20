package model;

import java.util.Arrays;
import java.util.List;
import java.util.logging.*;
import javax.persistence.*;

/**
 * @author Rene
 */
public class ClubDBMapper {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Bundesliga");
    private final static Logger LOGGER = Logger.getLogger(ClubDBMapper.class.getName());

    public ClubDBMapper() {
    }


    public void addClub(String name) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Club club = new Club(name);

        try {
            et = em.getTransaction();
            et.begin();
            em.persist(club);
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

    public Club getClub(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM clubs c WHERE c.id = :id";
        TypedQuery<Club> tq = em.createQuery(query, Club.class);
        tq.setParameter("id", id);
        Club cust = null;

        try {
            cust = tq.getSingleResult();
            LOGGER.log(Level.INFO, cust.toString());
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No customer found for id = {0}", id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return cust;
    }

    public List<Club> getClubs() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT c FROM customers c WHERE c.id IS NOT NULL";
        TypedQuery<Club> tq = em.createQuery(strQuery, Club.class);
        List<Club> custs = null;

        try {
            custs = tq.getResultList();
            LOGGER.log(Level.INFO, Arrays.toString(custs.toArray()));
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No customers found in table");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return custs;
    }
}
