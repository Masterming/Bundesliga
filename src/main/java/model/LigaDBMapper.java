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
public class LigaDBMapper {

    private final static Logger LOGGER = Logger.getLogger(LigaDBMapper.class.getName());

    public int addLiga(Liga l) {
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction et = null;
        int id = -1;

        try {
            et = em.getTransaction();
            et.begin();
            Liga merge = em.merge(l);
            id = merge.getId();
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            // em.close();
        }
        return id;
    }

    public Liga getLiga(int id) {
        EntityManager em = ManagerFactory.getEntityManager();
        String query = "SELECT l FROM Liga l WHERE l.id = :id";
        TypedQuery<Liga> tq = em.createQuery(query, Liga.class);
        tq.setParameter("id", id);
        Liga liga = null;

        try {
            liga = tq.getSingleResult();
            LOGGER.log(Level.INFO, "QUERY: {0}", liga.toString());
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No liga found for id = {0}", id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            // em.close();
        }
        return liga;
    }

    public List<Liga> getLigas() {
        EntityManager em = ManagerFactory.getEntityManager();
        String strQuery = "SELECT l FROM Liga l WHERE l.id IS NOT NULL";
        TypedQuery<Liga> tq = em.createQuery(strQuery, Liga.class);
        List<Liga> ligas = new ArrayList<>();

        try {
            ligas = tq.getResultList();
            LOGGER.log(Level.INFO, "QUERY: {0}", Arrays.toString(ligas.toArray()));
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No ligas found in table");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            // em.close();
        }
        return ligas;
    }

    public int reset() {
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction et = null;

        String strQuery = "DELETE FROM Liga";
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

    public boolean deleteLiga(Liga l) {
        boolean bSuccess = true;
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction et = null;

        try {
            LOGGER.log(Level.INFO, "Deleting {0}", l.toString());
            et = em.getTransaction();
            et.begin();
            em.remove(l);
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

    public Liga updateLiga(Liga l) {
        Liga ret = null;
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction et = null;
        // LOGGER.log(Level.INFO, "Update: {0}", l.toString());

        try {
            et = em.getTransaction();
            et.begin();
            // ret = em.merge(l);
            ret = em.merge(l);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            // em.close();
        }
        return ret;
    }
}
