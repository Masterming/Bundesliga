package model;

import javax.persistence.*;

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
