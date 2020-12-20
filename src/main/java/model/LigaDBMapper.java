package model;

import java.util.Arrays;
import java.util.List;
import java.util.logging.*;
import javax.persistence.*;

/**
 * @author Rene
 */
public class LigaDBMapper {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Bundesliga");
    private final static Logger LOGGER = Logger.getLogger(LigaDBMapper.class.getName());

    public void addLiga(String name) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Liga liga = new Liga(name);

        try {
            et = em.getTransaction();
            et.begin();
            em.persist(liga);
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

    public Liga getLiga(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT l FROM ligas l WHERE l.id = :id";
        TypedQuery<Liga> tq = em.createQuery(query, Liga.class);
        tq.setParameter("id", id);
        Liga liga = null;

        try {
            liga = tq.getSingleResult();
            LOGGER.log(Level.INFO, liga.toString());
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No liga found for id = {0}", id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return liga;
    }

    public List<Liga> getLigas() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT l FROM ligas l WHERE l.id IS NOT NULL";
        TypedQuery<Liga> tq = em.createQuery(strQuery, Liga.class);
        List<Liga> ligas = null;

        try {
            ligas = tq.getResultList();
            LOGGER.log(Level.INFO, Arrays.toString(ligas.toArray()));
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No ligas found in table");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return ligas;
    }
}