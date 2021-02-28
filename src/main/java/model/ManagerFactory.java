package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Rene
 */
public class ManagerFactory {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bundesliga");
    private static final EntityManager em = emf.createEntityManager();

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return em;
    }
}
