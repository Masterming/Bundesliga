package model;

import javax.persistence.*;

/**
 * @author Rene
 */
public class ManagerFactory {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bundesliga");

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
}
