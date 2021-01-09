/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Robin
 */
public class PlanModelDBMapper {

    private final static Logger LOGGER = Logger.getLogger(PlanModelDBMapper.class.getName());

    public void addPlanModel(PlanModel pm) {
        EntityManager em = ManagerFactory.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.persist(pm);
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

    public PlanModel getPlanModel(int id) {
        EntityManager em = ManagerFactory.createEntityManager();
        String query = "SELECT p FROM planmodels p WHERE p.id = :id";
        TypedQuery<PlanModel> tq = em.createQuery(query, PlanModel.class);
        tq.setParameter("id", id);
        PlanModel pm = null;

        try {
            pm  = tq.getSingleResult();
            LOGGER.log(Level.INFO, "QUERY: {0}", pm.toString());
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No PlanModel found for id = {0}", id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return pm;
    }

    public List<PlanModel> getAllPlanModels() {
        EntityManager em = ManagerFactory.createEntityManager();
        String strQuery = "SELECT p FROM planmodel p WHERE p.id IS NOT NULL";
        TypedQuery<PlanModel> tq = em.createQuery(strQuery, PlanModel.class);
        List<PlanModel> pms = new ArrayList<>();

        try {
            pms = tq.getResultList();
            LOGGER.log(Level.INFO, "QUERY: {0}", Arrays.toString(pms.toArray()));
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No pms found in table");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        } finally {
            em.close();
        }
        return pms;
    }

    public int reset() {
        EntityManager em = ManagerFactory.createEntityManager();
        EntityTransaction et = null;

        String strQuery = "DELETE FROM planmodels";
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
    
    public boolean deletePlanModel(PlanModel pm){        
        boolean bSuccess = true;        
        EntityManager em = ManagerFactory.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.remove(pm);
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
    
    public boolean updatePlanModel(PlanModel pm){        
        boolean bSuccess = true;        
        EntityManager em = ManagerFactory.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.merge(pm);
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
}
