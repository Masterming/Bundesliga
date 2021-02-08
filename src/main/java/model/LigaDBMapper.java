package model;

import java.util.*;
import java.util.logging.*;
import javax.persistence.*;

/**
 * @author Rene
 */
public class LigaDBMapper {

    private final static Logger LOGGER = Logger.getLogger(LigaDBMapper.class.getName());

    public int addLiga(Liga l) {
        EntityManager em = ManagerFactory.createEntityManager();
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
            em.close();
        }
        return id;
    }

    public Liga getLiga(int id) {
        EntityManager em = ManagerFactory.createEntityManager();
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
            em.close();
        }
        return liga;
    }

    public List<Liga> getLigas() {
        EntityManager em = ManagerFactory.createEntityManager();
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
            em.close();
        }
        return ligas;
    }

    public int reset() {
        EntityManager em = ManagerFactory.createEntityManager();
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
            em.close();
        }
        return i;
    }

    public boolean deleteLiga(Liga l) {
        boolean bSuccess = true;
        EntityManager em = ManagerFactory.createEntityManager();
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
            em.close();
        }
        return bSuccess;
    }

    public Liga updateLiga(Liga l) {
        Liga ret = null;
        EntityManager em = ManagerFactory.createEntityManager();
        EntityTransaction et = null;
        LOGGER.log(Level.INFO, "Update: {0}", l.toString());

        try {
            et = em.getTransaction();
            et.begin();
            //ret = em.merge(l);
            ret = em.find(Liga.class, l.getId());
            ret.copy(l);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return ret;
    }
}
