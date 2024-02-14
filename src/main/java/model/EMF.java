package model;




import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class EMF {

    private static final EntityManagerFactory emfInstance;

    static {
        emfInstance = Persistence.createEntityManagerFactory("default");
    }

    protected EMF() {}

    public static EntityManagerFactory getEMF() {
        return emfInstance;

    }

    public static EntityManager getEM() {
        return getEMF().createEntityManager();
    }



}