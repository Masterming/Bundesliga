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
public class ClubDBMapper {

    private final static Logger LOGGER = Logger.getLogger(ClubDBMapper.class.getName());

    public int addClub(Club club) {
        EntityManager em = ManagerFactory.getEntityManager();
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
            // em.close();
        }
        return id;
    }

    public Club getClub(int id) {
        EntityManager em = ManagerFactory.getEntityManager();
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
            // em.close();
        }
        return cust;
    }

    public List<Club> getAllClubs() {
        EntityManager em = ManagerFactory.getEntityManager();
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
            // em.close();
        }
        return custs;
    }

    public int reset() {
        EntityManager em = ManagerFactory.getEntityManager();
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
            // em.close();
        }
        return i;
    }

    public boolean deleteClub(Club c) {
        boolean bSuccess = true;
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.remove(c);
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

    public boolean updateClub(Club c) {
        boolean bSuccess = true;
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.merge(c);
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

        LOGGER.log(Level.INFO, "Update: {0}", c);
        return bSuccess;
    }
}
